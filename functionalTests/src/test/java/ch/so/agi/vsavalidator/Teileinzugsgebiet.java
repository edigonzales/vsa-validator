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

public class Teileinzugsgebiet {
    private static final String TEST_IN = "src/test/data/";
    private final String LOGFILE_NAME = "ilivalidator.log";
    
    @Test
    public void Cid_1020_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/1020/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/1020/config.toml");
        
        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/1020/1020_fail.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 21: VSADSSMINI_2020_LV95.VSADSSMini.Teileinzugsgebiet: tid deg5mQXX20003001: Die Bezeichnung 'Teileinzugsgebiet_1' enthält nicht empfohlene Zeichen (alle ausser [0-9], [A-Z], [.] und [-])."));
    }

    @Test
    public void Cid_1020_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/1020/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/1020/config.toml");
        
        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/1020/1020_ok.xtf", settings);
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
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/1021/");
        
        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/1021/1021_fail.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 21: VSADSSMINI_2020_LV95.VSADSSMini.Teileinzugsgebiet: tid 34B23C95-8F24-4B3D-A4C3-5997B4A7FFE7: value <34B23C95-8F24-4B3D-A4C3-5997B4A7FFE7> is not a valid OID"));
    }
    
    @Test
    public void Cid_1021_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/1021/");
        
        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/1021/1021_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }

    @Test
    public void Cid_4010_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4010/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4010/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4010/4010_fail.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 53: VSADSSMINI_2020_LV95.VSADSSMini.Teileinzugsgebiet: tid deg5mQXX20003001: Anschluss an SAA (SW Ist)"));
    }
    
    @Test
    public void Cid_4010_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4010/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4010/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4010/4010_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_4011_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4011/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4011/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4011/4011_fail.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 53: VSADSSMINI_2020_LV95.VSADSSMini.Teileinzugsgebiet: tid deg5mQXX20003001: Anschluss an SAA (RW Ist)"));
    }
    
    @Test
    public void Cid_4011_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4011/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4011/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4011/4011_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_4012_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4012/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4012/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4012/4012_fail.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 53: VSADSSMINI_2020_LV95.VSADSSMini.Teileinzugsgebiet: tid deg5mQXX20003001: Anschluss an SAA (SW_geplant)"));
    }
    
    @Test
    public void Cid_4012_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4012/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4012/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4012/4012_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_4013_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4013/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4013/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4013/4013_fail.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 53: VSADSSMINI_2020_LV95.VSADSSMini.Teileinzugsgebiet: tid deg5mQXX20003001: Anschluss an SAA (RW_geplant)"));
    }
    
    @Test
    public void Cid_4013_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4013/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4013/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4013/4013_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_4020_01_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4020_01/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4020_01/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4020_01/4020_fail.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 51: VSADSSMINI_2020_LV95.VSADSSMini.Teileinzugsgebiet: tid deg5mQXX20003001: Anschluss an eine nicht in Betrieb stehende Leitung (Ist-Zustand)"));
    }
    
    @Test
    public void Cid_4020_01_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4020_01/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4020_01/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4020_01/4020_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_4020_02_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4020_02/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4020_02/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4020_02/4020_fail.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 51: VSADSSMINI_2020_LV95.VSADSSMini.Teileinzugsgebiet: tid deg5mQXX20003001: Anschluss an eine nicht in Betrieb stehende Leitung (Ist-Zustand)"));
    }
    
    @Test
    public void Cid_4020_02_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4020_02/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4020_02/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4020_02/4020_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_4021_01_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4021_01/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4021_01/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4021_01/4021_fail.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 51: VSADSSMINI_2020_LV95.VSADSSMini.Teileinzugsgebiet: tid deg5mQXX20003001: Anschluss an eine nicht in Betrieb stehende Leitung (Planungszustand)"));
    }
    
    @Test
    public void Cid_4021_01_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4021_01/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4021_01/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4021_01/4021_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_4021_02_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4021_02/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4021_02/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4021_02/4021_fail.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 51: VSADSSMINI_2020_LV95.VSADSSMini.Teileinzugsgebiet: tid deg5mQXX20003001: Anschluss an eine nicht in Betrieb stehende Leitung (Planungszustand)"));
    }
    
    @Test
    public void Cid_4021_02_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4021_02/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4021_02/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4021_02/4021_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_4110_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4110/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4110/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4110/4110_fail.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 50: VSADSSMINI_2020_LV95.VSADSSMini.Teileinzugsgebiet: tid deg5mQXX20003001: Fehlender Anschlussknoten (SW_Ist)"));
    }
    
    @Test
    public void Cid_4110_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4110/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4110/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4110/4110_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_4115_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4115/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4115/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4115/4115_fail.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 50: VSADSSMINI_2020_LV95.VSADSSMini.Teileinzugsgebiet: tid deg5mQXX20003001: Überflüssiger Anschlussknoten (RW_Ist)"));
    }
    
    @Test
    public void Cid_4115_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4115/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4115/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4115/4115_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_4120_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4120/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4120/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4120/4120_fail.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 50: VSADSSMINI_2020_LV95.VSADSSMini.Teileinzugsgebiet: tid deg5mQXX20003001: Fehlender Anschlussknoten (SW_Ist)"));
    }
    
    @Test
    public void Cid_4120_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4120/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4120/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4120/4120_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_4125_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4125/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4125/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4125/4125_fail.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 50: VSADSSMINI_2020_LV95.VSADSSMini.Teileinzugsgebiet: tid deg5mQXX20003001: Überflüssiger Anschlussknoten (SW_Ist)"));
    }
    
    @Test
    public void Cid_4125_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4125/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4125/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4125/4125_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_4130_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4130/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4130/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4130/4130_fail.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 50: VSADSSMINI_2020_LV95.VSADSSMini.Teileinzugsgebiet: tid deg5mQXX20003001: Überflüssiger Anschlussknoten (RW_Ist)"));
    }
    
    @Test
    public void Cid_4130_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4130/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4130/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4130/4130_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_4135_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4135/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4135/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4135/4135_fail.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 50: VSADSSMINI_2020_LV95.VSADSSMini.Teileinzugsgebiet: tid deg5mQXX20003001: Fehlender Anschlussknoten (SW_Ist oder RW_Ist)"));
    }
    
    @Test
    public void Cid_4135_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4135/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4135/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4135/4135_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_4140_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4140/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4140/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4140/4140_fail.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 50: VSADSSMINI_2020_LV95.VSADSSMini.Teileinzugsgebiet: tid deg5mQXX20003001: Fehlender Anschlussknoten (SW_geplant)"));
    }
    
    @Test
    public void Cid_4140_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4140/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4140/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4140/4140_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }

    @Test
    public void Cid_4145_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4145/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4145/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4145/4145_fail.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 50: VSADSSMINI_2020_LV95.VSADSSMini.Teileinzugsgebiet: tid deg5mQXX20003001: Fehlender Anschlussknoten (RW_geplant)"));
    }
    
    @Test
    public void Cid_4145_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4145/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4145/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4145/4145_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_4150_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4150/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4150/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4150/4150_fail.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 50: VSADSSMINI_2020_LV95.VSADSSMini.Teileinzugsgebiet: tid deg5mQXX20003001: Fehlender Anschlussknoten (SW_geplant)"));
    }
    
    @Test
    public void Cid_4150_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4150/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4150/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4150/4150_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }

    @Test
    public void Cid_4155_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4155/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4155/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4155/4155_fail.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 50: VSADSSMINI_2020_LV95.VSADSSMini.Teileinzugsgebiet: tid deg5mQXX20003001: Überflüssiger Anschlussknoten (SW_geplant)"));
    }
    
    @Test
    public void Cid_4155_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4155/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4155/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4155/4155_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_4160_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4160/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4160/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4160/4160_fail.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 50: VSADSSMINI_2020_LV95.VSADSSMini.Teileinzugsgebiet: tid deg5mQXX20003001: Überflüssiger Anschlussknoten (RW_geplant)"));
    }
    
    @Test
    public void Cid_4160_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4160/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4160/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4160/4160_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_4165_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4165/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4165/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4165/4165_fail.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 50: VSADSSMINI_2020_LV95.VSADSSMini.Teileinzugsgebiet: tid deg5mQXX20003001: Fehlender Anschlussknoten (SW_geplant oder RW_geplant)"));
    }
    
    @Test
    public void Cid_4165_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4165/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4165/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4165/4165_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_4210_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4210/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4210/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4210/4210_fail.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 50: VSADSSMINI_2020_LV95.VSADSSMini.Teileinzugsgebiet: tid deg5mQXX20003001: Schmutzabwasserparameter ohne Anschlussknoten (Ist-Zustand)"));
    }
    
    @Test
    public void Cid_4210_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4210/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4210/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4210/4210_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_4211_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4211/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4211/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4211/4211_fail.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 50: VSADSSMINI_2020_LV95.VSADSSMini.Teileinzugsgebiet: tid deg5mQXX20003001: Schmutzabwasserparameter ohne Anschlussknoten (Planungszustand)"));
    }
    
    @Test
    public void Cid_4211_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4211/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4211/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4211/4211_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_4220_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4220/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4220/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4220/4220_fail.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 50: VSADSSMINI_2020_LV95.VSADSSMini.Teileinzugsgebiet: tid deg5mQXX20003001: Regenabwasserparameter ohne Anschlussknoten (Ist-Zustand)"));
    }
    
    @Test
    public void Cid_4220_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4220/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4220/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4220/4220_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_4221_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4221/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4221/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4221/4221_fail.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 50: VSADSSMINI_2020_LV95.VSADSSMini.Teileinzugsgebiet: tid deg5mQXX20003001: Regenabwasserparameter ohne Anschlussknoten (Planungszustand)"));
    }
    
    @Test
    public void Cid_4221_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4221/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4221/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4221/4221_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_4230_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4230/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4230/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4230/4230_fail.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 50: VSADSSMINI_2020_LV95.VSADSSMini.Teileinzugsgebiet: tid deg5mQXX20003001: Summe Abflussbeiwerte >100 (Ist-Zustand)"));
    }
    
    @Test
    public void Cid_4230_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4230/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4230/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4230/4230_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_4231_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4231/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4231/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4231/4231_fail.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 50: VSADSSMINI_2020_LV95.VSADSSMini.Teileinzugsgebiet: tid deg5mQXX20003001: Summe Abflussbeiwerte >100 (Planungszustand)"));
    }
    
    @Test
    public void Cid_4231_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4231/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4231/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4231/4231_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_4240_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4240/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4240/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4240/4240_fail.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 50: VSADSSMINI_2020_LV95.VSADSSMini.Teileinzugsgebiet: tid deg5mQXX20003001: Summe Befestigungsgrade >100 (Ist-Zustand)"));
    }
    
    @Test
    public void Cid_4240_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4240/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4240/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4240/4240_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_4241_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4241/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4241/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4241/4241_fail.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 50: VSADSSMINI_2020_LV95.VSADSSMini.Teileinzugsgebiet: tid deg5mQXX20003001: Summe Befestigungsgrade >100 (Planungszustand)"));
    }
    
    @Test
    public void Cid_4241_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4241/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4241/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4241/4241_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_4310_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4310/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4310/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4310/4310_fail.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 21: VSADSSMINI_2020_LV95.VSADSSMini.Teileinzugsgebiet: tid deg5mQXX20003001: Differenz von erfasster zu berechneter Fläche"));
    }
    
    @Test
    public void Cid_4310_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4310/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4310/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4310/4310_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_4320_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4320/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4320/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4320/4320_fail.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: VSADSSMINI_2020_LV95.VSADSSMini.Teileinzugsgebiet: Intersection coord1 (2600010.000, 1200003.333)"));
    }
    
    @Test
    public void Cid_4320_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4320/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4320/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4320/4320_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Disabled
    @Test
    public void Cid_4330_01_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"teileinzugsgebiet/4330_01/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"teileinzugsgebiet/4330_01/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"teileinzugsgebiet/4330_01/4330_fail.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
//        assertTrue(content.contains("Error: VSADSSMINI_2020_LV95.VSADSSMini.Teileinzugsgebiet: Intersection coord1 (2600010.000, 1200003.333)"));
    }
}
