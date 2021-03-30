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
import ch.ehi.basics.settings.Settings;

public class Knoten {
    private static final String TEST_IN = "src/test/data/";
    private final String LOGFILE_NAME = "ilivalidator.log";

    @Test
    public void Cid_1020(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"knoten/1020/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"knoten/1020/config.toml");
        
        boolean valid = Validator.runValidation(TEST_IN+"knoten/1020/1020.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 21: VSADSSMINI_2020_LV95.VSADSSMini.Knoten: tid deg5mQXX20001001"));
    }
    
    @Test
    public void Cid_1021(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"knoten/1021/");
        
        boolean valid = Validator.runValidation(TEST_IN+"knoten/1021/1021.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 21: VSADSSMINI_2020_LV95.VSADSSMini.Knoten: tid 34B23C95-8F24-4B3D-A4C3-5997B4A7FFE7: value <34B23C95-8F24-4B3D-A4C3-5997B4A7FFE7> is not a valid OID"));
    }
    
    @Test 
    public void Cid_2010(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();

        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"knoten/2010/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"knoten/2010/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");
        
        boolean valid = Validator.runValidation(TEST_IN+"knoten/2010/2010.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 50: VSADSSMINI_2020_LV95.VSADSSMini.Knoten: tid deg5mQXX20001005: Knoten ohne Auslauf"));
    }
    
    @Test 
    public void Cid_2020(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"knoten/2020/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"knoten/2020/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");
        
        boolean valid = Validator.runValidation(TEST_IN+"knoten/2020/2020.xtf", settings);
        assertTrue(valid);

        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 45: VSADSSMINI_2020_LV95.VSADSSMini.Knoten: tid deg5mQXX20001003: Mit keiner Leitung verbundener Knoten"));
    }
    
    @Test
    public void Cid_2030(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"knoten/2030/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"knoten/2030/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"knoten/2030/2030.xtf", settings);
        assertFalse(valid);

        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 20: VSADSSMINI_2020_LV95.VSADSSMini.Knoten: tid deg5mQXX20001001: Nicht als solches attributiertes Sonderbauwerk"));
    }
    
    @Test
    public void Cid_2040(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"knoten/2040/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"knoten/2040/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"knoten/2040/2040.xtf", settings);
        assertTrue(valid);

        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 37: VSADSSMINI_2020_LV95.VSADSSMini.Knoten: tid deg5mQXX20001002: Kein Ueberlauf_Foerderaggregat erfasst"));        
    }
    
    @Test
    public void Cid_2050(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"knoten/2050/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"knoten/2050/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"knoten/2050/2050.xtf", settings);
        assertFalse(valid);

        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 32: VSADSSMINI_2020_LV95.VSADSSMini.Knoten: tid deg5mQXX20001002: Nicht-gewaesserrelevante Einleitstelle mit PAA-Einlauf"));
    }
    
    @Test
    public void Cid_2110(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"knoten/2110/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"knoten/2110/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"knoten/2110/2110.xtf", settings);
        assertFalse(valid);

        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        System.out.println(content);
//        assertTrue(content.contains("Error: line 32: VSADSSMINI_2020_LV95.VSADSSMini.Knoten: tid deg5mQXX20001002: Nicht-gewaesserrelevante Einleitstelle mit PAA-Einlauf"));
    }
}
