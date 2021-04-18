package ch.so.agi.vsavalidator;

import ch.ehi.basics.settings.Settings;
import ch.interlis.ili2c.metamodel.TransferDescription;
import ch.interlis.iom.IomObject;
import ch.interlis.iox.IoxValidationConfig;
import ch.interlis.iox_j.logging.LogEventFactory;
import ch.interlis.iox_j.validator.InterlisFunction;
import ch.interlis.iox_j.validator.ObjectPool;
import ch.interlis.iox_j.validator.Value;

public class IGSGetDistanceIoxPlugin implements InterlisFunction {
    private LogEventFactory logger = null;

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
                
        IomObject startObj = (IomObject) actualArguments[0].getComplexObjects().toArray()[0];
        IomObject endObj = (IomObject) actualArguments[1].getComplexObjects().toArray()[0];
                
        Double x1 = Double.parseDouble(startObj.getattrvalue("C1"));
        Double y1 = Double.parseDouble(startObj.getattrvalue("C2"));
        double z1 = 0;
        if (startObj.getattrvalue("C3") != null) {
            z1 = Double.parseDouble(startObj.getattrvalue("C3"));
        }
        
        Double x2 = Double.parseDouble(endObj.getattrvalue("C1"));
        Double y2 = Double.parseDouble(endObj.getattrvalue("C2"));
        double z2 = 0;
        if (endObj.getattrvalue("C3") != null) {
            z2 = Double.parseDouble(endObj.getattrvalue("C3"));
        }

        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) + Math.pow(z2 - z1, 2));
        return new Value(distance);
    }

    @Override
    public String getQualifiedIliName() {
        return "IGSFunction.IGS_getDistance";
    }

    @Override
    public void init(TransferDescription td, Settings settings, 
            IoxValidationConfig validationConfig, ObjectPool objectPool, 
            LogEventFactory logEventFactory) {

        this.logger = logEventFactory;
        this.logger.setValidationConfig(validationConfig);
    }
}
