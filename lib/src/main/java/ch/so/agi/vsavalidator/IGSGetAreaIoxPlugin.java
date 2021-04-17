package ch.so.agi.vsavalidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.Polygon;

import ch.ehi.basics.settings.Settings;
import ch.ehi.basics.types.OutParam;
import ch.interlis.ili2c.Ili2cException;
import ch.interlis.ili2c.metamodel.AbstractClassDef;
import ch.interlis.ili2c.metamodel.AssociationDef;
import ch.interlis.ili2c.metamodel.AssociationPath;
import ch.interlis.ili2c.metamodel.AttributeRef;
import ch.interlis.ili2c.metamodel.CompositionType;
import ch.interlis.ili2c.metamodel.EnumerationType;
import ch.interlis.ili2c.metamodel.LocalAttribute;
import ch.interlis.ili2c.metamodel.ObjectPath;
import ch.interlis.ili2c.metamodel.PathEl;
import ch.interlis.ili2c.metamodel.PathElAbstractClassRole;
import ch.interlis.ili2c.metamodel.PathElAssocRole;
import ch.interlis.ili2c.metamodel.PathElRefAttr;
import ch.interlis.ili2c.metamodel.PathElThis;
import ch.interlis.ili2c.metamodel.ReferenceType;
import ch.interlis.ili2c.metamodel.RoleDef;
import ch.interlis.ili2c.metamodel.StructAttributeRef;
import ch.interlis.ili2c.metamodel.TransferDescription;
import ch.interlis.ili2c.metamodel.Type;
import ch.interlis.ili2c.metamodel.TypeAlias;
import ch.interlis.ili2c.metamodel.Viewable;
import ch.interlis.ili2c.metamodel.ViewableTransferElement;
import ch.interlis.iom.IomObject;
import ch.interlis.iom_j.Iom_jObject;
import ch.interlis.iox.IoxValidationConfig;
import ch.interlis.iox_j.jts.Iox2jts;
import ch.interlis.iox_j.jts.Iox2jtsException;
import ch.interlis.iox_j.logging.LogEventFactory;
import ch.interlis.iox_j.validator.InterlisFunction;
import ch.interlis.iox_j.validator.ObjectPool;
import ch.interlis.iox_j.validator.Validator;
import ch.interlis.iox_j.validator.Value;

public class IGSGetAreaIoxPlugin implements InterlisFunction {
    public static final double strokeP = 0.002;

    private LogEventFactory logger = null;
    private TransferDescription td = null;
    private ObjectPool objectPool = null;
    private HashMap<String, Viewable> tag2class = null;
    private Validator validator = null;

    @Override
    public Value evaluate(String validationKind, String usageScope, IomObject mainObj, Value[] actualArguments) {        
        if (actualArguments[0].skipEvaluation()) {
            return actualArguments[0];
        }
        if (actualArguments[1].skipEvaluation()) {
            return actualArguments[1];
        }
        if (actualArguments[0].isUndefined()) {
            return Value.createSkipEvaluation();
        }
        if (actualArguments[1].isUndefined()) {
            return Value.createSkipEvaluation();
        }
        
        // Um die Klasse zu bestimmen, kann man das erste Objekt verwenden. Falls
        // es mehrere Objekte sind, sind es immer Objekte von der gleichen Klasse.
        IomObject iomObj = (IomObject) actualArguments[0].getComplexObjects().toArray()[0];
        Viewable currentClass = (Viewable) td.getElement(iomObj.getobjecttag());
        
        String attributePathStr = actualArguments[1].getValue();
        
        ObjectPath attributePath = null;
        try {
            attributePath =  validator.parseObjectOrAttributePath(currentClass,attributePathStr);
        } catch (Ili2cException e) {
            e.printStackTrace();
            logger.addEvent(logger.logErrorMsg("Could not parse object or attribute path."));
            return Value.createSkipEvaluation();
        }
        
        Value valueOfObjectPath = validator.getValueFromObjectPath(null, iomObj, attributePath.getPathElements(), null);
        
        // Siehe ilivalidator-custom-functions GeometryUtils, um
        // zu sehen wie mit den verschiedenen Geometrie-Möglichkeiten umgegangen
        // werden muss.
        // Zum jetzigen Zeitpunkt akzeptieren wir nur Geometrien,
        // wie sie im VSA-DSS-Mini kodiert sind.
        // Etwas für Geom.getArea() oder so.
      
        IomObject geomObj = (IomObject) valueOfObjectPath.getComplexObjects().toArray()[0];
        Polygon polygon = null;
        try {
            polygon = Iox2jts.surface2JTS(geomObj, strokeP);
        } catch (Iox2jtsException e) {
            e.printStackTrace();
            logger.addEvent(logger.logErrorMsg("Could not create jts polygon."));
            return Value.createSkipEvaluation();
        }
      
        return new Value(polygon.getArea());
    }

    @Override
    public String getQualifiedIliName() {
        return "IGSFunction.IGS_getArea";
    }

    @Override
    public void init(TransferDescription td, Settings settings, 
            IoxValidationConfig validationConfig, ObjectPool objectPool, 
            LogEventFactory logEventFactory) {

        this.logger = logEventFactory;
        this.logger.setValidationConfig(validationConfig);
        this.td = td;
        this.objectPool = objectPool;
        this.tag2class = ch.interlis.iom_j.itf.ModelUtilities.getTagMap(td);   
        this.validator = (Validator) settings.getTransientObject(this.IOX_VALIDATOR);
    }
}
