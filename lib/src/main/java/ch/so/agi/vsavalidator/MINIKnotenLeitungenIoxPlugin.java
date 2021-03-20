package ch.so.agi.vsavalidator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

public class MINIKnotenLeitungenIoxPlugin implements InterlisFunction {
    private Settings settings = null;
    private LogEventFactory logger = null;
    private HashMap<String, Viewable> tag2class = null;
    private TransferDescription td = null;
    
    private String LEITUNG_OBJECT_TAG = "VSADSSMINI_2020_LV95.VSADSSMini.Leitung";
    private String KNOTEN_NACH_REF = "Knoten_nachRef";
    private String KNOTEN_VON_REF = "Knoten_vonRef";
    private String CACHE_NAME = "ch.so.agi.vsavalidator.MINIKnotenLeitungen.Leitungen_Knoten";

    @Override
    public Value evaluate(String validationKind, String usageScope, IomObject mainObj, Value[] actualArguments) {
        if (actualArguments[0].skipEvaluation()) {
            return actualArguments[0];
        }
        if (actualArguments[0].isUndefined()) {
            return Value.createSkipEvaluation();
        }

        IoxDataPool pipelinePool = (IoxDataPool) settings.getTransientObject(InterlisFunction.IOX_DATA_POOL);
        Set<String> cache = (HashSet<String>) pipelinePool.getIntermediateValue(CACHE_NAME);
        System.out.println(cache);

        System.out.println("foo bar");
//        System.out.println(actualArguments[0].getComplexObjects());

        List<IomObject> iomObjects = (List<IomObject>) actualArguments[0].getComplexObjects();
        System.out.println(iomObjects.size());
        
        IomObject iomObj = iomObjects.get(0);
        System.out.println(iomObj.getobjectoid());
        String objId = iomObj.getobjectoid();
        
        System.out.println(cache.contains(objId));
        
        
        System.out.println("--------------------------------------------------\n");
        
        // TODO: korrekter Rückgabewert, sonst NPE.
        return Value.createSkipEvaluation();
    }

    @Override
    public String getQualifiedIliName() {
        return "MINIFunction.MINI_Knoten_Leitungen";
    }

    @Override
    public void init(TransferDescription td, Settings settings, 
            IoxValidationConfig validationConfig, ObjectPool objectPool, 
            LogEventFactory logEventFactory) {
        
        System.out.println("init...");

        this.settings = settings;
        this.logger = logEventFactory;
        this.logger.setValidationConfig(validationConfig);
        this.tag2class = ch.interlis.iom_j.itf.ModelUtilities.getTagMap(td);
        this.td = td;
        
        IoxDataPool pipelinePool = (IoxDataPool) settings.getTransientObject(InterlisFunction.IOX_DATA_POOL);

        if (pipelinePool.getIntermediateValue("ch.so.meincache") == null) {
            System.out.println("einmalig");
            pipelinePool.setIntermediateValue("ch.so.meincache", "meincache");
            
            Set<String> knotenSet = new HashSet<String>();
            objectPool.getBasketIds().stream().map((basketId) -> (objectPool.getObjectsOfBasketId(basketId)).valueIterator()).forEach((Iterator objectIterator) -> {
                while (objectIterator.hasNext()) {
                    IomObject iomObj = (IomObject) objectIterator.next();
                    if (iomObj != null && iomObj.getobjecttag().equals(LEITUNG_OBJECT_TAG)) {
                        IomObject nachKnoten = iomObj.getattrobj(KNOTEN_NACH_REF, 0);
                        if (nachKnoten != null) {
                            knotenSet.add(nachKnoten.getobjectrefoid());
                        }
                        IomObject vonKnoten = iomObj.getattrobj(KNOTEN_VON_REF, 0);
                        if (vonKnoten != null) {
                            knotenSet.add(vonKnoten.getobjectrefoid());
                        }
                    }
                }
            });
            pipelinePool.setIntermediateValue(CACHE_NAME, knotenSet);
            System.out.println(knotenSet);
        }
    }
}
