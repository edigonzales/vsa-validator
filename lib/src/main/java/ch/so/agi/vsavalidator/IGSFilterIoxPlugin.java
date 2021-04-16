package ch.so.agi.vsavalidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ch.ehi.basics.settings.Settings;
import ch.interlis.ili2c.metamodel.TransferDescription;
import ch.interlis.ili2c.metamodel.Viewable;
import ch.interlis.iom.IomObject;
import ch.interlis.iox.IoxValidationConfig;
import ch.interlis.iox_j.logging.LogEventFactory;
import ch.interlis.iox_j.validator.InterlisFunction;
import ch.interlis.iox_j.validator.ObjectPool;
import ch.interlis.iox_j.validator.Value;

// TODO:
// - Kann man etwas vom ili2c resp. iox-ili verwenden? Dort gibt es evaluateExpression()
// - Für das reine Parsen können man geotools cql verwenden. -> Unschöne Abhängigkeit. Kosten/Nutzen?
// - org.xbib.cql Parser: Undokumentiert. Braucht Java 11.
// - org.z3950.zing.cql.CQLParser.

/*
 * Syntax:
 * - Mehrere Filterbedingungen (AND resp. &&) sind mittels Semikolon getrennt.
 * - Es wird nur '=' unterstützt.
 * - Wildcard ('*') ist am Ende des Textes resp. des Aufzähltypes möglich -> startsWith().
 * - Nur einfache Werte können gefiltert werden.
 */

public class IGSFilterIoxPlugin implements InterlisFunction {
    private LogEventFactory logger = null;

    @Override
    public Value evaluate(String validationKind, String usageScope, IomObject mainObj, Value[] actualArguments) {
        // TODO: isUndefined scheint mir klar. Wann kommt es aber zu
        // skipEvaluation() und was macht man bei zwei Parametern?
        if (actualArguments[0].skipEvaluation()) {
            return actualArguments[0];
        }
        if (actualArguments[0].isUndefined()) {
            return Value.createSkipEvaluation();
        }
        if (actualArguments[1].isUndefined()) {
            return Value.createSkipEvaluation();
        }
        
        List<IomObject> iomObjects = (List<IomObject>) actualArguments[0].getComplexObjects();
        String filterString = actualArguments[1].getValue();
                
        List<IomObject> filteredObjects = new ArrayList<IomObject>();

        for (IomObject iomObj : iomObjects) {
            if(evaluateFilter(iomObj, filterString)) {
                filteredObjects.add(iomObj);
            } 
        } 
        return new Value(filteredObjects);
    }

    @Override
    public String getQualifiedIliName() {
        return "IGSFunction.IGS_filter";
    }

    @Override
    public void init(TransferDescription td, Settings settings, 
            IoxValidationConfig validationConfig, ObjectPool objectPool, 
            LogEventFactory logEventFactory) {

        this.logger = logEventFactory;
        this.logger.setValidationConfig(validationConfig);
    }
    
    private boolean evaluateFilter(IomObject iomObj, String filterString) {
        String[] filterArray = filterString.split(";");
        
        // Jeder Filter muss erfüllt sein.
        List<String> evaluatedFilters = new ArrayList<String>(); 
        for (String filter : filterArray) {            
            String attrName = filter.split("=")[0];
            String valuesString = filter.split("=")[1];
            String[] values = valuesString.split(",");

            String attrValue = iomObj.getattrvalue(attrName);
            if (attrValue == null) {
                // Falls der Wert eines Attributes nicht vorhanden ist (=null), 
                // wird die komplette Auswertung des Filters nichtig.
                // -> Das Objekt erfüllt die Filterkriterien nicht. Es
                // muss nicht weiter geprüft werden.
                return false;
            } else {
                // Mindestens einmal muss value dem Wert des Attributes entsprechen.
                // Oder mit value beginnen.
                for (String value : values) {
                    if (value.endsWith("*")) {
                        if (attrValue.startsWith(value.substring(0, value.length() - 1))) {
                            evaluatedFilters.add(filter);
                        } 
                    } else {
                        if (attrValue.equals(value)) {
                            evaluatedFilters.add(filter);
                        }
                    }
                }
            }
        }
        if (evaluatedFilters.size() == filterArray.length) {
            return true;
        } else {
            return false;
        }
    }
}
