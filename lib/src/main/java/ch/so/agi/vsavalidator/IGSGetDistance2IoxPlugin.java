package ch.so.agi.vsavalidator;

import java.util.HashMap;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

import ch.ehi.basics.settings.Settings;
import ch.interlis.ili2c.Ili2cException;
import ch.interlis.ili2c.metamodel.ObjectPath;
import ch.interlis.ili2c.metamodel.TransferDescription;
import ch.interlis.ili2c.metamodel.Viewable;
import ch.interlis.iom.IomObject;
import ch.interlis.iox.IoxValidationConfig;
import ch.interlis.iox_j.jts.Iox2jts;
import ch.interlis.iox_j.jts.Iox2jtsException;
import ch.interlis.iox_j.logging.LogEventFactory;
import ch.interlis.iox_j.validator.InterlisFunction;
import ch.interlis.iox_j.validator.ObjectPool;
import ch.interlis.iox_j.validator.Validator;
import ch.interlis.iox_j.validator.Value;

public class IGSGetDistance2IoxPlugin implements InterlisFunction {
    public static final double strokeP = 0.002;

    private LogEventFactory logger = null;
    private TransferDescription td = null;
    private Validator validator = null;

    @Override
    public Value evaluate(String validationKind, String usageScope, IomObject mainObj, Value[] actualArguments) {
        if (actualArguments[0].skipEvaluation()) {
            return actualArguments[0];
        }
        if (actualArguments[1].skipEvaluation()) {
            return actualArguments[1];
        }
        if (actualArguments[2].skipEvaluation()) {
            return actualArguments[1];
        }
        if (actualArguments[3].skipEvaluation()) {
            return actualArguments[1];
        }
        if (actualArguments[0].isUndefined()) {
            return Value.createSkipEvaluation();
        }
        if (actualArguments[1].isUndefined()) {
            return Value.createSkipEvaluation();
        }
        if (actualArguments[2].isUndefined()) {
            return Value.createSkipEvaluation();
        }
        if (actualArguments[3].isUndefined()) {
            return Value.createSkipEvaluation();
        }
        
        IomObject startObj = (IomObject) actualArguments[0].getComplexObjects().toArray()[0];
        String startAttributePath = actualArguments[1].getValue();

        IomObject endObj = (IomObject) actualArguments[2].getComplexObjects().toArray()[0];
        String endAttributePath = actualArguments[3].getValue();
        
        Value startValue = null;
        Value endValue = null;
        try {
            startValue = this.getValueFromObjectPath(startObj, startAttributePath);
            endValue = this.getValueFromObjectPath(endObj, endAttributePath);
        } catch (Ili2cException e) {
            e.printStackTrace();
            logger.addEvent(logger.logErrorMsg("Could not parse object or attribute path."));
            return Value.createSkipEvaluation();
        }
        
        // Es ist wiederum nur die Variane DSS-mini implementiert, d.h.
        // erster Parameter ist eine Koordinate, zweiter Parameter eine
        // einfaches Polygon.
        IomObject geomStartObj = (IomObject) startValue.getComplexObjects().toArray()[0];
        IomObject geomEndObj = (IomObject) endValue.getComplexObjects().toArray()[0];
        
        Coordinate coord = null;
        Polygon polygon = null;
        try {
            coord = Iox2jts.coord2JTS(geomStartObj);
            polygon = Iox2jts.surface2JTS(geomEndObj, strokeP);
        } catch (Iox2jtsException e) {
            e.printStackTrace();
            logger.addEvent(logger.logErrorMsg("Could not parse geometry object."));
            return Value.createSkipEvaluation();
        }
        
        if (coord == null || polygon == null) {
            logger.addEvent(logger.logErrorMsg("Could not parse geometry object."));
            return Value.createSkipEvaluation();
        }
        
        double distance = polygon.distance(new GeometryFactory().createPoint(coord));
        return new Value(distance);
    }

    @Override
    public String getQualifiedIliName() {
        return "IGSFunction.IGS_getDistance2";
    }

    @Override
    public void init(TransferDescription td, Settings settings, 
            IoxValidationConfig validationConfig, ObjectPool objectPool, 
            LogEventFactory logEventFactory) {

        this.logger = logEventFactory;
        this.logger.setValidationConfig(validationConfig);
        this.td = td;
        this.validator = (Validator) settings.getTransientObject(this.IOX_VALIDATOR);
    }
    
    private Value getValueFromObjectPath(IomObject iomObj, String attributePath) throws Ili2cException {
        Viewable currentClass = (Viewable) td.getElement(iomObj.getobjecttag());        
        ObjectPath attrPath = validator.parseObjectOrAttributePath(currentClass,attributePath);
        Value valueOfObjectPath = validator.getValueFromObjectPath(null, iomObj, attrPath.getPathElements(), null);
        return valueOfObjectPath;
    }
}
