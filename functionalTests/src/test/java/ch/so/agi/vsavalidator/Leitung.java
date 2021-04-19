package ch.so.agi.vsavalidator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.interlis2.validator.Validator;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import ch.ehi.basics.logging.EhiLogger;
import ch.ehi.basics.settings.Settings;

public class Leitung {
    private static final String TEST_IN = "src/test/data/";
    private final String LOGFILE_NAME = "ilivalidator.log";

    @Test
    public void Cid_1020_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/1020/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/1020/config.toml");
        
        boolean valid = Validator.runValidation(TEST_IN+"leitung/1020/1020_fail.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 21: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Die Bezeichnung 'Leitung_1' enthält nicht empfohlene Zeichen (alle ausser [0-9], [A-Z], [.] und [-])"));
    }

    @Test
    public void Cid_1020_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/1020/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/1020/config.toml");
        
        boolean valid = Validator.runValidation(TEST_IN+"leitung/1020/1020_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_1021_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/1021/");
        
        boolean valid = Validator.runValidation(TEST_IN+"leitung/1021/1021_fail.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 21: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid 34B23C95-8F24-4B3D-A4C3-5997B4A7FFE7: value <34B23C95-8F24-4B3D-A4C3-5997B4A7FFE7> is not a valid OID"));
    }
    
    @Test
    public void Cid_1021_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/1021/");
        
        boolean valid = Validator.runValidation(TEST_IN+"leitung/1021/1021_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_3010_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3010/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3010/config.toml");
        
        boolean valid = Validator.runValidation(TEST_IN+"leitung/3010/3010_fail.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 21: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Fehlender Knoten_von (PAA)"));
    }
    
    @Test
    public void Cid_3010_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3010/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3010/config.toml");
        
        boolean valid = Validator.runValidation(TEST_IN+"leitung/3010/3010_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_3020_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3020/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3020_fehler/config.toml");
        
        boolean valid = Validator.runValidation(TEST_IN+"leitung/3020/3020_fail.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 21: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Fehlender Knoten_nach (PAA)"));
    }
    
    @Test
    public void Cid_3020_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3020/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3020/config.toml");
        
        boolean valid = Validator.runValidation(TEST_IN+"leitung/3020/3020_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_3030_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3030/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3030/config.toml");
        
        boolean valid = Validator.runValidation(TEST_IN+"leitung/3030/3030_fail.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 21: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Leitung_nach erfasst bei PAA"));
    }
    
    @Test
    public void Cid_3030_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3030/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3030/config.toml");
        
        boolean valid = Validator.runValidation(TEST_IN+"leitung/3030/3030_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_3040_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3040/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3040/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3040/3040_fail.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 61: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002002: PAA-Leitung oberhalb von SAA-Leitung"));
    }
    
    @Test
    public void Cid_3040_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3040/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3040/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3040/3040_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    } 
    
    @Test
    public void Cid_3050_01_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3050_01/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3050_01/config.toml");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3050_01/3050_fail.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 50: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Knoten_nach und Leitung_nach erfasst"));
    }
    
    @Test
    public void Cid_3050_01_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3050_01/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3050_01/config.toml");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3050_01/3050_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_3050_02_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3050_02/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3050_02/config.toml");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3050_02/3050_fail.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 50: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Knoten_nach und Leitung_nach erfasst"));
    }
    
    @Test
    public void Cid_3050_02_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3050_02/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3050_02/config.toml");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3050_02/3050_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_3070_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3070/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3070/config.toml");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3070/3070_fail.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 31: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Start- und Endknoten identisch"));
    }
    
    @Test
    public void Cid_3070_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3070/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3070/config.toml");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3070/3070_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_3080_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3080/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3080/config.toml");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3080/3080_fail.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 50: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002002: Parallelleitung vorhanden"));
    }
    
    @Test
    public void Cid_3110_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3110/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3110/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        //EhiLogger.getInstance().setTraceFilter(false);

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3110/3110_fail.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 41: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Erfasste Länge <> berechnete Länge"));
    }
    
    @Test
    public void Cid_3110_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3110/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3110/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3110/3110_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }

    @Test
    public void Cid_3120_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3120/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3120/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3120/3120_fail.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 44: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Distanz Knoten zu Auslauf > Toleranzwert"));
    }
    
    @Test
    public void Cid_3120_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3120/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3120/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3120/3120_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_3130_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3130/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3130/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3130/3130_fail.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 44: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Distanz Knoten zu Einlauf > Toleranzwert"));
    }

    @Test
    public void Cid_3130_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3130/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3130/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3130/3130_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_3140_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3140/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3140/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3140/3140_fail.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 50: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Die berechnete Leitungslänge ist wesentlich kürzer als die Distanz zwischen den Knoten"));
    }
    
    @Test
    public void Cid_3140_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3140/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3140/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3140/3140_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_3150_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3150/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3150/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3150/3150_fail.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 50: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Die berechnete Leitungslänge ist wesentlich grösser als die Distanz zwischen den Knoten"));
    }
    
    @Test
    public void Cid_3150_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3150/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3150/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3150/3150_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_3210_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3210/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3210/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3210/3210_fail.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 38: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: PAA mit kleiner Nennweite"));
    }
    
    @Test
    public void Cid_3210_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3210/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3210/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3210/3210_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_3220_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3220/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3220/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3220/3220_fail.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 38: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Gegengefälle in Freispiegelleitung"));
    }
    
    @Test
    public void Cid_3220_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3220/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3220/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3220/3220_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }    
    
    @Test
    public void Cid_3230_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3230/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3230/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3230/3230_fail.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 38: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Gefälle in Pumpenleitung"));
    }
    
    @Test
    public void Cid_3230_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3230/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3230/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3230/3230_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_3240_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3240/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3240/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3240/3240_fail.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 38: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Grosskalibrige SAA"));
    }
    
    @Test
    public void Cid_3240_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3240/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3240/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3240/3240_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_3250_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3250/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3250/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3250/3250_fail.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 38: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Kreisprofil ist nicht gleich breit wie hoch"));
    }
    
    @Test
    public void Cid_3250_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3250/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3250/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3250/3250_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_3260_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3260/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3260/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3260/3260_fail.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 38: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Eiprofil ist breiter als hoch"));
    }
    
    @Test
    public void Cid_3260_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3260/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3260/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3260/3260_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_3270_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3270/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3270/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3270/3270_fail.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 38: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Höhe zu Breite entspricht nicht Normeiprofil"));
    }
    
    @Test
    public void Cid_3270_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3270/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3270/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3270/3270_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_3310_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3310/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3310/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3310/3310_fail.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 38: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Drainageleitung führt nicht nur Reinabwasser"));
    }
    
    @Test
    public void Cid_3310_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3310/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3310/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3310/3310_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_3320_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3320/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3320/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3320/3320_fail.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 38: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Strassenentwässerung führt nicht Regen- oder Mischabwasser"));
    }
    
    @Test
    public void Cid_3320_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3320/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3320/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3320/3320_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_3330_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3330/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3330/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3330/3330_fail.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 46: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: In Betrieb stehende Leitung mündet in nicht in Betrieb stehende Leitung"));
    }
    
    @Test
    public void Cid_3330_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3330/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3330/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3330/3330_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_3340_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3340/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3340/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3340/3340_fail.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 46: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Leitung mit verschmutztem Abwasser mündet in Leitung mit unverschmutztem Abwasser (Ist-Zustand)"));
    }
    
    @Test
    public void Cid_3340_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3340/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3340/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3340/3340_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_3341_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3341/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3341/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3341/3341_fail.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 46: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Leitung mit verschmutztem Abwasser mündet in Leitung mit unverschmutztem Abwasser (Planungszustand)"));
    }
    
    @Test
    public void Cid_3341_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3341/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3341/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3341/3341_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_3350_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3350/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3350/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3350/3350_fail.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 46: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Leitung mit Niederschlagsabwasser mündet in Leitung ohne Niederschlagsabwasser (Ist-Zustand)"));
    }
    
    @Test
    public void Cid_3350_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3350/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3350/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3350/3350_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_3351_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3351/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3351/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3351/3351_fail.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 46: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Leitung mit Niederschlagsabwasser mündet in Leitung ohne Niederschlagsabwasser (Planungszustand)"));
    }
    
    @Test
    public void Cid_3351_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3351/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3351/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3351/3351_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Disabled("https://github.com/claeis/ilivalidator/issues/300")
    @Test
    public void Cid_3360_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3360/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3360/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3360/3360_fail.xtf", settings);
        assertFalse(valid);
        
        // TODO
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 46: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Leitung mit Niederschlagsabwasser mündet in Leitung ohne Niederschlagsabwasser (Planungszustand)"));
    }
    
    @Disabled("https://github.com/claeis/ilivalidator/issues/300")
    @Test
    public void Cid_3360_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3360/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3360/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3360/3360_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Disabled("https://github.com/claeis/ilivalidator/issues/300")
    @Test
    public void Cid_3370_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3370/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3370/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3370/3370_fail.xtf", settings);
        assertFalse(valid);
        
        // TODO
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 46: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Leitung mit Niederschlagsabwasser mündet in Leitung ohne Niederschlagsabwasser (Planungszustand)"));
    }
    
    @Disabled("https://github.com/claeis/ilivalidator/issues/300")
    @Test
    public void Cid_3370_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3370/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3370/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3370/3370_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_9101_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/9101/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/9101/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/9101/9101_fail.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 38: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Baujahr ist nicht plausibel"));
    }
    
    @Test
    public void Cid_9101_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/9101/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/9101/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/9101/9101_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_9102_01_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/9102_01/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/9102_01/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/9102_01/9102_fail.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 38: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Kote_von ist nicht plausibel"));
    }
    
    @Test
    public void Cid_9102_01_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/9102_01/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/9102_01/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/9102_01/9102_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_9102_02_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/9102_02/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/9102_02/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/9102_02/9102_fail.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 38: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Kote_nach ist nicht plausibel"));
    }
    
    @Test
    public void Cid_9102_02_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/9102_02/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/9102_02/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/9102_02/9102_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_9104_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/9104/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/9104/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/9104/9104_fail.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 38: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: LaengeEffektiv ist nicht plausibel"));
    }
    
    @Test
    public void Cid_9104_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/9104/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/9104/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/9104/9104_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_9105_01_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/9105_01/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/9105_01/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/9105_01/9105_fail.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 38: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Lichte_Breite ist nicht plausibel"));
    }
    
    @Test
    public void Cid_9105_01_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/9105_01/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/9105_01/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/9105_01/9105_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_9105_02_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/9105_02/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/9105_02/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/9105_02/9105_fail.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 38: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Lichte_Hoehe ist nicht plausibel"));
    }
    
    @Test
    public void Cid_9105_02_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/9105_02/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/9105_02/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/9105_02/9105_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_9106_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/9106/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/9106/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/9106/9106_fail.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 38: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: WBW_Basisjahr ist nicht plausibel"));
    }
    
    @Test
    public void Cid_9106_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/9106/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/9106/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/9106/9106_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_9107_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/9107/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/9107/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/9107/9107_fail.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 38: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Wiederbeschaffungswert ist nicht plausibel"));
    }
    
    @Test
    public void Cid_9107_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/9107/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/9107/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/9107/9107_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
}
