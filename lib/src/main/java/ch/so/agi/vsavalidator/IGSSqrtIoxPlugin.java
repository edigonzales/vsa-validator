package ch.so.agi.vsavalidator;

import ch.ehi.basics.settings.Settings;
import ch.interlis.ili2c.metamodel.TransferDescription;
import ch.interlis.iom.IomObject;
import ch.interlis.iox.IoxValidationConfig;
import ch.interlis.iox_j.logging.LogEventFactory;
import ch.interlis.iox_j.validator.InterlisFunction;
import ch.interlis.iox_j.validator.ObjectPool;
import ch.interlis.iox_j.validator.Value;

public class IGSSqrtIoxPlugin implements InterlisFunction {
    private LogEventFactory logger = null;

    @Override
    public Value evaluate(String validationKind, String usageScope, IomObject mainObj, Value[] actualArguments) {
        if (actualArguments[0].skipEvaluation()) {
            return actualArguments[0];
        }
        if (actualArguments[0].isUndefined()) {
            return Value.createSkipEvaluation();
        }
        
        Double value;
        if (actualArguments[0].getValue() != null) {
            value = Double.parseDouble(actualArguments[0].getValue());
        } else {
            value = Double.valueOf(actualArguments[0].getNumeric());
        }
        
        return new Value(Math.sqrt(value));
    }

    @Override
    public String getQualifiedIliName() {
        return "IGSFunction.IGS_sqrt";
    }

    @Override
    public void init(TransferDescription td, Settings settings, 
            IoxValidationConfig validationConfig, ObjectPool objectPool, 
            LogEventFactory logEventFactory) {

        this.logger = logEventFactory;
        this.logger.setValidationConfig(validationConfig);
    }
}
