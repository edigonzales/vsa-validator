package ch.so.agi.vsavalidator;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.interlis2.validator.Validator;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import ch.ehi.basics.logging.EhiLogger;
import ch.ehi.basics.settings.Settings;

public class VSADSSMINI_2020_LV95_CHECK_FP {
    private static final String TEST_IN = "src/test/data/";
    private final String LOGFILE_NAME = "ilivalidator.log";

    @Test
    @Tag("complete")
    public void completeBirmensdorf(@TempDir Path tempDir) throws Exception {
//        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        String logFileName = Paths.get("/Users/stefan/tmp/", LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"VSADSSMINI_2020_LV95_CHECK_FP/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"VSADSSMINI_2020_LV95_CHECK_FP/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");
        //EhiLogger.getInstance().setTraceFilter(false);

//        boolean valid = Validator.runValidation("/Users/stefan/sources/afu_ipw_testdaten/gep/birmensdorf/orig/bdf_sew_dss-mini-20_20210212.xtf", settings);
        boolean valid = Validator.runValidation("/Users/stefan/sources/afu_ipw_testdaten/gep/bern/fix/Bern_Mini_2020_org_Massnahme.xtf", settings);
//        assertFalse(valid);
        
//        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
//        assertTrue(content.contains("Warning: line 21: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Die Bezeichnung 'Leitung_1' enthält nicht empfohlene Zeichen (alle ausser [0-9], [A-Z], [.] und [-])"));
    }

}
