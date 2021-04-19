package ch.so.agi.vsavalidator;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.interlis2.validator.Validator;

import ch.ehi.basics.logging.EhiLogger;
import ch.ehi.basics.settings.Settings;

public class Knoten {
    private static final String TEST_IN = "src/test/data/";
    private final String LOGFILE_NAME = "ilivalidator.log";

    @Test
    public void Cid_1020_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"knoten/1020/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"knoten/1020/config.toml");
        
        boolean valid = Validator.runValidation(TEST_IN+"knoten/1020/1020_fail.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 21: VSADSSMINI_2020_LV95.VSADSSMini.Knoten: tid deg5mQXX20001001"));
    }

    @Test
    public void Cid_1020_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"knoten/1020/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"knoten/1020/config.toml");
        
        boolean valid = Validator.runValidation(TEST_IN+"knoten/1020/1020_ok.xtf", settings);
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
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"knoten/1021/");
        
        boolean valid = Validator.runValidation(TEST_IN+"knoten/1021/1021_fail.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 21: VSADSSMINI_2020_LV95.VSADSSMini.Knoten: tid 34B23C95-8F24-4B3D-A4C3-5997B4A7FFE7: value <34B23C95-8F24-4B3D-A4C3-5997B4A7FFE7> is not a valid OID"));
    }

    @Test
    public void Cid_1021_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"knoten/1021/");
        
        boolean valid = Validator.runValidation(TEST_IN+"knoten/1021/1021_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test 
    public void Cid_2010_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();

        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"knoten/2010/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"knoten/2010/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");
        
        boolean valid = Validator.runValidation(TEST_IN+"knoten/2010/2010_fail.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 50: VSADSSMINI_2020_LV95.VSADSSMini.Knoten: tid deg5mQXX20001005: Knoten ohne Auslauf"));
    }
    
    @Test 
    public void Cid_2010_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();

        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"knoten/2010/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"knoten/2010/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");
        
        boolean valid = Validator.runValidation(TEST_IN+"knoten/2010/2010_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test 
    public void Cid_2020_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"knoten/2020/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"knoten/2020/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");
        
        boolean valid = Validator.runValidation(TEST_IN+"knoten/2020/2020_fail.xtf", settings);
        assertTrue(valid);

        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 45: VSADSSMINI_2020_LV95.VSADSSMini.Knoten: tid deg5mQXX20001003: Mit keiner Leitung verbundener Knoten"));
    }
    
    @Test 
    public void Cid_2020_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"knoten/2020/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"knoten/2020/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");
        
        boolean valid = Validator.runValidation(TEST_IN+"knoten/2020/2020_ok.xtf", settings);
        assertTrue(valid);

        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_2030_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"knoten/2030/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"knoten/2030/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"knoten/2030/2030_fail.xtf", settings);
        assertFalse(valid);

        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 20: VSADSSMINI_2020_LV95.VSADSSMini.Knoten: tid deg5mQXX20001001: Nicht als solches attributiertes Sonderbauwerk"));
    }

    @Test
    public void Cid_2030_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"knoten/2030/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"knoten/2030/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"knoten/2030/2030_ok.xtf", settings);
        assertTrue(valid);

        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }

    @Test
    public void Cid_2040_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"knoten/2040/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"knoten/2040/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"knoten/2040/2040_fail.xtf", settings);
        assertTrue(valid);

        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 37: VSADSSMINI_2020_LV95.VSADSSMini.Knoten: tid deg5mQXX20001002: Kein Ueberlauf_Foerderaggregat erfasst"));        
    }

    @Test
    public void Cid_2040_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"knoten/2040/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"knoten/2040/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"knoten/2040/2040_ok.xtf", settings);
        assertTrue(valid);

        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_2050_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"knoten/2050/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"knoten/2050/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"knoten/2050/2050_fail.xtf", settings);
        assertFalse(valid);

        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 32: VSADSSMINI_2020_LV95.VSADSSMini.Knoten: tid deg5mQXX20001002: Nicht-gewaesserrelevante Einleitstelle mit PAA-Einlauf"));
    }
    
    @Test
    public void Cid_2050_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"knoten/2050/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"knoten/2050/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"knoten/2050/2050_ok.xtf", settings);
        assertTrue(valid);

        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_2110_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"knoten/2110/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"knoten/2110/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"knoten/2110/2110_fail.xtf", settings);
        assertFalse(valid);

        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 23: VSADSSMINI_2020_LV95.VSADSSMini.Knoten: tid deg5mQXX20001001: Knotensohle höher als Leitungssohlen"));
    }
    
    @Test
    public void Cid_2110_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"knoten/2110/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"knoten/2110/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"knoten/2110/2110_ok.xtf", settings);
        assertTrue(valid);

        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_2120_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"knoten/2120/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"knoten/2120/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"knoten/2120/2120_fail.xtf", settings);
        assertTrue(valid);

        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 50: VSADSSMINI_2020_LV95.VSADSSMini.Knoten: tid deg5mQXX20001004: Auslauf höher als Zulauf"));
    }
    
    @Test
    public void Cid_2120_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"knoten/2120/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"knoten/2120/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"knoten/2120/2120_ok.xtf", settings);
        assertTrue(valid);

        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_2130_01_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"knoten/2130_01/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"knoten/2130_01/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"knoten/2130_01/2130_fail.xtf", settings);
        assertTrue(valid);

        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 32: VSADSSMINI_2020_LV95.VSADSSMini.Knoten: tid deg5mQXX20001002: Verschmutztes Abwasser in Einleitstelle"));
    }
    
    @Test
    public void Cid_2130_01_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"knoten/2130_01/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"knoten/2130_01/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"knoten/2130_01/2130_ok.xtf", settings);
        assertTrue(valid);

        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_2130_02_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"knoten/2130_02/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"knoten/2130_02/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"knoten/2130_02/2130_fail.xtf", settings);
        assertTrue(valid);

        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 32: VSADSSMINI_2020_LV95.VSADSSMini.Knoten: tid deg5mQXX20001002: Verschmutztes Abwasser in Einleitstelle"));
    }
    
    @Test
    public void Cid_2130_02_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"knoten/2130_02/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"knoten/2130_02/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"knoten/2130_02/2130_ok.xtf", settings);
        assertTrue(valid);

        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }

    @Disabled("https://github.com/claeis/ilivalidator/issues/300")
    @Test
    public void Cid_2140_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"knoten/2140/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"knoten/2140/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");
        //EhiLogger.getInstance().setTraceFilter(false);
        
        boolean valid = Validator.runValidation(TEST_IN+"knoten/2140/2140_fail.xtf", settings);
        assertFalse(valid);

        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
//        assertTrue(content.contains("Warning: line 32: VSADSSMINI_2020_LV95.VSADSSMini.Knoten: tid deg5mQXX20001002: Verschmutztes Abwasser in Einleitstelle"));
    }
    
    @Disabled("https://github.com/claeis/ilivalidator/issues/300")
    @Test
    public void Cid_2140_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"knoten/2140/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"knoten/2140/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");
        
        boolean valid = Validator.runValidation(TEST_IN+"knoten/2140/2140_ok.xtf", settings);
        assertFalse(valid);

        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Disabled("https://github.com/claeis/ilivalidator/issues/300")
    @Test
    public void Cid_2150_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"knoten/2150/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"knoten/2150/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");
        
        boolean valid = Validator.runValidation(TEST_IN+"knoten/2150/2150_fail.xtf", settings);
        assertFalse(valid);

        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
//        assertTrue(content.contains("Warning: line 32: VSADSSMINI_2020_LV95.VSADSSMini.Knoten: tid deg5mQXX20001002: Verschmutztes Abwasser in Einleitstelle"));
    }

    @Disabled("https://github.com/claeis/ilivalidator/issues/300")
    @Test
    public void Cid_2150_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"knoten/2150/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"knoten/2150/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");
        
        boolean valid = Validator.runValidation(TEST_IN+"knoten/2150/2150_ok.xtf", settings);
        assertTrue(valid);

        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_2160_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"knoten/2160/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"knoten/2160/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");
        
        boolean valid = Validator.runValidation(TEST_IN+"knoten/2160/2160_fail.xtf", settings);
        assertFalse(valid);

        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 23: VSADSSMINI_2020_LV95.VSADSSMini.Knoten: tid deg5mQXX20001001: SAA-Knoten an PAA-Leitung"));
    }
    
    @Test
    public void Cid_2160_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"knoten/2160/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"knoten/2160/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");
        
        boolean valid = Validator.runValidation(TEST_IN+"knoten/2160/2160_ok.xtf", settings);
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
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"knoten/9101/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"knoten/9101/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");
        
        boolean valid = Validator.runValidation(TEST_IN+"knoten/9101/9101_fail.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 21: VSADSSMINI_2020_LV95.VSADSSMini.Knoten: tid deg5mQXX20001001: Baujahr ist nicht plausibel"));
    }
    
    @Test
    public void Cid_9101_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"knoten/9101/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"knoten/9101/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");
        
        boolean valid = Validator.runValidation(TEST_IN+"knoten/9101/9101_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_9102_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"knoten/9102/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"knoten/9102/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");
        
        boolean valid = Validator.runValidation(TEST_IN+"knoten/9102/9102_fail.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 21: VSADSSMINI_2020_LV95.VSADSSMini.Knoten: tid deg5mQXX20001001: Deckelkote ist nicht plausibel"));
    }
    
    @Test
    public void Cid_9102_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"knoten/9102/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"knoten/9102/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");
        
        boolean valid = Validator.runValidation(TEST_IN+"knoten/9102/9102_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_9103_fail(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"knoten/9103/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"knoten/9103/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");
        
        boolean valid = Validator.runValidation(TEST_IN+"knoten/9103/9103_fail.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 21: VSADSSMINI_2020_LV95.VSADSSMini.Knoten: tid deg5mQXX20001001: Sohlenkote ist nicht plausibel"));
    }
    
    @Test
    public void Cid_9103_ok(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"knoten/9103/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"knoten/9103/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");
        
        boolean valid = Validator.runValidation(TEST_IN+"knoten/9103/9103_ok.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
}
