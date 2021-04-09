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

public class IGSMinIoxPlugin implements InterlisFunction {
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
        
        List<IomObject> iomObjects = (List<IomObject>) actualArguments[0].getComplexObjects();
        String attrName = actualArguments[1].getValue();

        double minValue = 0;
        int index = 0;
        for (IomObject iomObj : iomObjects) {
            String value = iomObj.getattrvalue(attrName);
            if (value == null) continue; 
            double tmpValue = Double.parseDouble(value);
            if (index == 0) {
                minValue = tmpValue;
            } else {
                minValue = java.lang.Math.min(minValue, tmpValue);
            }
            index++;            
        }
        return new Value(minValue);
    }

    @Override
    public String getQualifiedIliName() {
        return "IGSFunction.IGS_min";
    }

    @Override
    public void init(TransferDescription td, Settings settings, 
            IoxValidationConfig validationConfig, ObjectPool objectPool, 
            LogEventFactory logEventFactory) {

        this.logger = logEventFactory;
        this.logger.setValidationConfig(validationConfig);
    }
}
