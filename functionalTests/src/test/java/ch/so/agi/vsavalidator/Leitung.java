package ch.so.agi.vsavalidator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.interlis2.validator.Validator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import ch.ehi.basics.settings.Settings;

public class Leitung {
    private static final String TEST_IN = "src/test/data/";
    private final String LOGFILE_NAME = "ilivalidator.log";

    @Test
    public void Cid_1020_fehler(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/1020_fehler/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/1020_fehler/config.toml");
        
        boolean valid = Validator.runValidation(TEST_IN+"leitung/1020_fehler/1020.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 21: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Die Bezeichnung 'Leitung_1' enthält nicht empfohlene Zeichen (alle ausser [0-9], [A-Z], [.] und [-])"));
    }

    @Test
    public void Cid_1020(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/1020/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/1020/config.toml");
        
        boolean valid = Validator.runValidation(TEST_IN+"leitung/1020/1020.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_1021_fehler(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/1021_fehler/");
        
        boolean valid = Validator.runValidation(TEST_IN+"leitung/1021_fehler/1021.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 21: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid 34B23C95-8F24-4B3D-A4C3-5997B4A7FFE7: value <34B23C95-8F24-4B3D-A4C3-5997B4A7FFE7> is not a valid OID"));
    }
    
    @Test
    public void Cid_1021(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/1021/");
        
        boolean valid = Validator.runValidation(TEST_IN+"leitung/1021/1021.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_3010_fehler(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3010_fehler/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3010_fehler/config.toml");
        
        boolean valid = Validator.runValidation(TEST_IN+"leitung/3010_fehler/3010.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 21: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Fehlender Knoten_von (PAA)"));
    }
    
    @Test
    public void Cid_3010(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3010/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3010/config.toml");
        
        boolean valid = Validator.runValidation(TEST_IN+"leitung/3010/3010.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_3020_fehler(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3020_fehler/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3020_fehler/config.toml");
        
        boolean valid = Validator.runValidation(TEST_IN+"leitung/3020_fehler/3020.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 21: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Fehlender Knoten_nach (PAA)"));
    }
    
    @Test
    public void Cid_3020(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3020/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3020/config.toml");
        
        boolean valid = Validator.runValidation(TEST_IN+"leitung/3020/3020.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_3030_fehler(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3030_fehler/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3030_fehler/config.toml");
        
        boolean valid = Validator.runValidation(TEST_IN+"leitung/3030_fehler/3030.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 21: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Leitung_nach erfasst bei PAA"));
    }
    
    @Test
    public void Cid_3030(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3030/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3030/config.toml");
        
        boolean valid = Validator.runValidation(TEST_IN+"leitung/3030/3030.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
}
