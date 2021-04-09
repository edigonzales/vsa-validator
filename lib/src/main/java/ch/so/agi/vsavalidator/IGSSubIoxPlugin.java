package ch.so.agi.vsavalidator;

import ch.ehi.basics.settings.Settings;
import ch.interlis.ili2c.metamodel.TransferDescription;
import ch.interlis.iom.IomObject;
import ch.interlis.iox.IoxValidationConfig;
import ch.interlis.iox_j.logging.LogEventFactory;
import ch.interlis.iox_j.validator.InterlisFunction;
import ch.interlis.iox_j.validator.ObjectPool;
import ch.interlis.iox_j.validator.Value;

public class IGSSubIoxPlugin implements InterlisFunction {
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
        
        Double value1;
        Double value2;
        if (actualArguments[0].getValue() != null) {
            value1 = Double.parseDouble(actualArguments[0].getValue());
        } else {
            value1 = Double.valueOf(actualArguments[0].getNumeric());
        }
        
        if (actualArguments[1].getValue() != null) {
            value2 = Double.parseDouble(actualArguments[1].getValue());
        } else {
            value2 = Double.valueOf(actualArguments[1].getNumeric());
        }
        
        return new Value(value1 - value2);
    }

    @Override
    public String getQualifiedIliName() {
        return "IGSFunction.IGS_sub";
    }

    @Override
    public void init(TransferDescription td, Settings settings, 
            IoxValidationConfig validationConfig, ObjectPool objectPool, 
            LogEventFactory logEventFactory) {

        this.logger = logEventFactory;
        this.logger.setValidationConfig(validationConfig);
    }
}
