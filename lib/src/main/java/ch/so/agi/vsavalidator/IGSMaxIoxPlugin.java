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

public class IGSMaxIoxPlugin implements InterlisFunction {
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
        
        if (attrName.startsWith("IGS_mul")) {            
            String[] attrNameArray = attrName.substring(8, attrName.length()-1).split(",");
            String attrName1 = attrNameArray[0];
            String attrName2 = attrNameArray[1];
            
            Double tmpValue = null;
            double maxValue = 0;
            int index = 0;
            for (IomObject iomObj : iomObjects) {
                String value1 = iomObj.getattrvalue(attrName1);
                String value2 = iomObj.getattrvalue(attrName2);
                if (value1 == null || value2 == null) continue;
                tmpValue = Double.parseDouble(value1) * Double.parseDouble(value2);
                if (index == 0) {
                    maxValue = tmpValue;
                } else {
                    maxValue = java.lang.Math.max(maxValue, tmpValue);
                }
                index++;  
            } 
            if (tmpValue == null) {
                return Value.createSkipEvaluation();
            } else {
                return new Value(maxValue);
            }
        } else {
            Double tmpValue = null;
            double maxValue = 0;
            int index = 0;
            for (IomObject iomObj : iomObjects) {
                String value = iomObj.getattrvalue(attrName);
                if (value == null) continue; 
                tmpValue = Double.parseDouble(value);
                if (index == 0) {
                    maxValue = tmpValue;
                } else {
                    maxValue = java.lang.Math.max(maxValue, tmpValue);
                }
                index++;                
            }
            if (tmpValue == null) {
                return Value.createSkipEvaluation();
            } else {
                return new Value(maxValue);
            }
        }
    }

    @Override
    public String getQualifiedIliName() {
        return "IGSFunction.IGS_max";
    }

    @Override
    public void init(TransferDescription td, Settings settings, 
            IoxValidationConfig validationConfig, ObjectPool objectPool, 
            LogEventFactory logEventFactory) {

        this.logger = logEventFactory;
        this.logger.setValidationConfig(validationConfig);
    }
}
