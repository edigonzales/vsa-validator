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

public class IGSGetFirstPointIoxPlugin implements InterlisFunction {
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
        
        // Polyline kann mehrere Sequence haben, wir interessieren uns
        // aber nur für den ersten Punkt, also auch nur für die 
        // erste Sequence etc.
        IomObject segmentsValue=lineObj.getattrobj("sequence", 0);
        IomObject firstCoord = segmentsValue.getattrobj("segment", 0);

        List<IomObject> coordList = new ArrayList<IomObject>();
        coordList.add(firstCoord);
        
        return new Value(coordList);
    }

    @Override
    public String getQualifiedIliName() {
        return "IGSFunction.IGS_getFirstPoint";
    }

    @Override
    public void init(TransferDescription td, Settings settings, 
            IoxValidationConfig validationConfig, ObjectPool objectPool, 
            LogEventFactory logEventFactory) {

        this.logger = logEventFactory;
        this.logger.setValidationConfig(validationConfig);
    }
}
