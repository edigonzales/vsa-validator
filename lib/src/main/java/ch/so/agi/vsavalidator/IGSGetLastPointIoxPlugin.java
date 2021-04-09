package ch.so.agi.vsavalidator;

import java.util.ArrayList;
import java.util.List;

import ch.ehi.basics.settings.Settings;
import ch.interlis.ili2c.metamodel.TransferDescription;
import ch.interlis.iom.IomObject;
import ch.interlis.iox.IoxValidationConfig;
import ch.interlis.iox_j.logging.LogEventFactory;
import ch.interlis.iox_j.validator.InterlisFunction;
import ch.interlis.iox_j.validator.ObjectPool;
import ch.interlis.iox_j.validator.Value;

public class IGSGetLastPointIoxPlugin implements InterlisFunction {
    private LogEventFactory logger = null;

    @Override
    public Value evaluate(String validationKind, String usageScope, IomObject mainObj, Value[] actualArguments) {
        if (actualArguments[0].skipEvaluation()) {
            return actualArguments[0];
        }
        if (actualArguments[0].isUndefined()) {
            return Value.createSkipEvaluation();
        }
        
        IomObject lineObj = (IomObject) actualArguments[0].getComplexObjects().toArray()[0];
        IomObject lastSegmentObj = lineObj.getattrobj("sequence", lineObj.getattrvaluecount("sequence") - 1);
        IomObject lastCoordObj = lastSegmentObj.getattrobj("segment", lastSegmentObj.getattrvaluecount("segment") - 1);
 
        List<IomObject> coordList = new ArrayList<IomObject>();
        coordList.add(lastCoordObj);
        
        return new Value(coordList);
    }

    @Override
    public String getQualifiedIliName() {
        return "IGSFunction.IGS_getLastPoint";
    }

    @Override
    public void init(TransferDescription td, Settings settings, 
            IoxValidationConfig validationConfig, ObjectPool objectPool, 
            LogEventFactory logEventFactory) {

        this.logger = logEventFactory;
        this.logger.setValidationConfig(validationConfig);
    }
}
