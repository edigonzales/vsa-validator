package ch.so.agi.vsavalidator;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ch.ehi.basics.logging.EhiLogger;
import ch.ehi.basics.settings.Settings;
import ch.interlis.ili2c.config.Configuration;
import ch.interlis.ili2c.config.FileEntry;
import ch.interlis.ili2c.config.FileEntryKind;
import ch.interlis.ili2c.metamodel.TransferDescription;
import ch.interlis.iom_j.xtf.XtfReader;
import ch.interlis.iox.EndTransferEvent;
import ch.interlis.iox.IoxEvent;
import ch.interlis.iox.IoxException;
import ch.interlis.iox_j.PipelinePool;
import ch.interlis.iox_j.logging.LogEventFactory;
import ch.interlis.iox_j.validator.ValidationConfig;
import ch.interlis.iox_j.validator.Validator;

public class MINIKnotenLeitungenIoxPluginTest {
    private TransferDescription td = null;
    private final static String OBJ_OID1 ="o1";
    private final static String ILI_TOPIC = "Testmodel.Topic";
    private final static String ILI_CLASSD = ILI_TOPIC+".ClassD";
    private final static String BID1 = "b1";
    private static final String TEST_IN = "src/test/data/xtf/";

    @BeforeEach
    public void setUp() throws Exception {
        Configuration ili2cConfig = new Configuration();
        {
            FileEntry fileEntry = new FileEntry("src/test/data/Units-20120220.ili", FileEntryKind.ILIMODELFILE);
            ili2cConfig.addFileEntry(fileEntry);
        }
        {
            FileEntry fileEntry = new FileEntry("src/test/data/Base_d-20181005.ili", FileEntryKind.ILIMODELFILE);
            ili2cConfig.addFileEntry(fileEntry);
        }
        {
            FileEntry fileEntry = new FileEntry("src/test/data/SIA405_Base_Abwasser-20201103.ili", FileEntryKind.ILIMODELFILE);
            ili2cConfig.addFileEntry(fileEntry);
        }
        {
            FileEntry fileEntry = new FileEntry("src/test/data/VSADSSMINI_2020_2_d_LV95-20201209.ili", FileEntryKind.ILIMODELFILE);
            ili2cConfig.addFileEntry(fileEntry);
        }
        {
            FileEntry fileEntry = new FileEntry("src/test/data/MINIFunction.ili", FileEntryKind.ILIMODELFILE);
            ili2cConfig.addFileEntry(fileEntry);
        }        
        {
            FileEntry fileEntry = new FileEntry("src/test/data/Validierung_MINI_Knoten_Leitungen.ili", FileEntryKind.ILIMODELFILE);
            ili2cConfig.addFileEntry(fileEntry);
        }
        td = ch.interlis.ili2c.Ili2c.runCompiler(ili2cConfig);
        assertNotNull(td);
    }
    
    private void runValidation(File xtffile, LogCollector logger) throws IoxException {
        EhiLogger.getInstance().setTraceFilter(false);
        XtfReader reader = new XtfReader(xtffile);
        Settings settings = new Settings();
        
        Map<String,Class> newFunctions = new HashMap<String,Class>();
        newFunctions.put("MINIFunction.MINI_Knoten_Leitungen", MINIKnotenLeitungenIoxPlugin.class);
        settings.setTransientObject(Validator.CONFIG_CUSTOM_FUNCTIONS, newFunctions);

        ch.interlis.iox_j.validator.Validator validator=null;
        LogEventFactory errFactory = new LogEventFactory();
        PipelinePool pool = new PipelinePool();
        ValidationConfig modelConfig = new ValidationConfig();
        modelConfig.setConfigValue(ValidationConfig.PARAMETER,ValidationConfig.ADDITIONAL_MODELS, "VSADSSMINI_2020_LV95_Validierung_FP;");
        validator = new ch.interlis.iox_j.validator.Validator(td, modelConfig, logger, errFactory, pool, settings);
        IoxEvent event = null;
        do {
            event = reader.read();
            validator.validate(event);
        } while (!(event instanceof EndTransferEvent));

    }
    
    @Test
    public void mitKeinerLeitungVerbundenerKnoten() throws Exception {
        System.out.println("fubar");
        
        LogCollector logger = new LogCollector();
        runValidation(new File(TEST_IN+"mit_keiner_leitung_verbundener_knoten.xtf"), logger);

    }
    
    

}
