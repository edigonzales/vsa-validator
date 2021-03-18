package ch.so.agi.vsavalidator;

import java.util.HashMap;

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

    @Override
    public Value evaluate(String validationKind, String usageScope, IomObject mainObj, Value[] actualArguments) {
        if (actualArguments[0].skipEvaluation()) {
            return actualArguments[0];
        }
        if (actualArguments[0].isUndefined()) {
            return Value.createSkipEvaluation();
        }

        System.out.println("foo bar");
        System.out.println(actualArguments[0].getComplexObjects());

        IoxDataPool pipelinePool = (IoxDataPool) settings.getTransientObject(InterlisFunction.IOX_DATA_POOL);
        String cache = (String) pipelinePool.getIntermediateValue("ch.so.meincache");
        System.out.println(cache);
        
        
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
        pipelinePool.setIntermediateValue("ch.so.meincache", "meincache");
    }

}
