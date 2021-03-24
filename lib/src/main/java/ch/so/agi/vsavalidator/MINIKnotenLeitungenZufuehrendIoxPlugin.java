package ch.so.agi.vsavalidator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import ch.ehi.basics.settings.Settings;
import ch.interlis.ili2c.metamodel.TransferDescription;
import ch.interlis.ili2c.metamodel.Viewable;
import ch.interlis.iom.IomObject;
import ch.interlis.iox.IoxDataPool;
import ch.interlis.iox.IoxValidationConfig;
import ch.interlis.iox_j.logging.LogEventFactory;
import ch.interlis.iox_j.validator.InterlisFunction;
import ch.interlis.iox_j.validator.ObjectPool;
import ch.interlis.iox_j.validator.Value;

public class MINIKnotenLeitungenZufuehrendIoxPlugin implements InterlisFunction {
    private Settings settings = null;
    private LogEventFactory logger = null;
    
    private String KNOTEN_NACH_REF = "Knoten_nachRef";
    private String CACHE_NAME = "ch.so.agi.vsavalidator.Leitungen";

    @Override
    public Value evaluate(String validationKind, String usageScope, IomObject mainObj, Value[] actualArguments) {
        if (actualArguments[0].skipEvaluation()) {
            return actualArguments[0];
        }
        if (actualArguments[0].isUndefined()) {
            return Value.createSkipEvaluation();
        }

        IoxDataPool pipelinePool = (IoxDataPool) settings.getTransientObject(InterlisFunction.IOX_DATA_POOL);
        Set<IomObject> cache = (HashSet<IomObject>) pipelinePool.getIntermediateValue(CACHE_NAME);

        List<IomObject> iomObjects = (List<IomObject>) actualArguments[0].getComplexObjects();

        IomObject knotenIomObj = iomObjects.get(0);
        String knotenObjId = knotenIomObj.getobjectoid();
        
        List<IomObject> leitungenObjects = cache
        .stream()
        .filter(iomObj -> {
            IomObject vonKnoten = iomObj.getattrobj(KNOTEN_NACH_REF, 0);
            if (vonKnoten != null) {
                if (vonKnoten.getobjectrefoid().equals(knotenObjId)) {
                    return true;
                }
            } 
            return false;
            
        }).collect(Collectors.toList());

        return new Value(leitungenObjects);
    }

    @Override
    public String getQualifiedIliName() {
        return "MINIFunction.MINI_Knoten_Leitungen_zufuehrend";
    }

    @Override
    public void init(TransferDescription td, Settings settings, 
            IoxValidationConfig validationConfig, ObjectPool objectPool, 
            LogEventFactory logEventFactory) {
        
        this.settings = settings;
        this.logger = logEventFactory;
        this.logger.setValidationConfig(validationConfig);
        
        IoxDataPool pipelinePool = (IoxDataPool) settings.getTransientObject(InterlisFunction.IOX_DATA_POOL);

        if (pipelinePool.getIntermediateValue(CACHE_NAME) == null) {
            Set<IomObject> leitungenSet = Utils.createSimpleObjectCache(objectPool, "VSADSSMINI_2020_LV95.VSADSSMini.Leitung");
            pipelinePool.setIntermediateValue(CACHE_NAME, leitungenSet);
        }
    }

}
