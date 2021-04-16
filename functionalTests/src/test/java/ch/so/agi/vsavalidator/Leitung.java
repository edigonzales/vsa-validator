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
    
    @Test
    public void Cid_3040_fehler(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3040_fehler/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3040_fehler/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3040_fehler/3040.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 61: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002002: PAA-Leitung oberhalb von SAA-Leitung"));
    }
    
    @Test
    public void Cid_3040(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3040/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3040/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3040/3040.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    } 
    
    @Test
    public void Cid_3050a_fehler(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3050a_fehler/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3050a_fehler/config.toml");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3050a_fehler/3050.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 50: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Knoten_nach und Leitung_nach erfasst"));
    }
    
    @Test
    public void Cid_3050a(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3050a/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3050a/config.toml");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3050a/3050.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_3050b_fehler(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3050b_fehler/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3050b_fehler/config.toml");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3050b_fehler/3050.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 50: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Knoten_nach und Leitung_nach erfasst"));
    }
    
    @Test
    public void Cid_3050b(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3050b/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3050b/config.toml");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3050b/3050.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_3070_fehler(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3070_fehler/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3070_fehler/config.toml");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3070_fehler/3070.xtf", settings);
        assertFalse(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Error: line 31: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Start- und Endknoten identisch"));
    }
    
    @Test
    public void Cid_3070(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3070/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3070/config.toml");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3070/3070.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_3080_fehler(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3080_fehler/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3080_fehler/config.toml");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3080_fehler/3080.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 50: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002002: Parallelleitung vorhanden"));
    }
    
    @Test
    public void Cid_3110_fehler(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3110_fehler/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3110_fehler/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        //EhiLogger.getInstance().setTraceFilter(false);

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3110_fehler/3110.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 41: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Erfasste Länge <> berechnete Länge"));
    }
    
    @Test
    public void Cid_3110(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3110/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3110/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");


        boolean valid = Validator.runValidation(TEST_IN+"leitung/3110/3110.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }

    @Test
    public void Cid_3120_fehler(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3120_fehler/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3120_fehler/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3120_fehler/3120.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 44: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Distanz Knoten zu Auslauf > Toleranzwert"));
    }
    
    @Test
    public void Cid_3120(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3120/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3120/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3120/3120.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_3130_fehler(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3130_fehler/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3130_fehler/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3130_fehler/3130.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 44: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Distanz Knoten zu Einlauf > Toleranzwert"));
    }

    @Test
    public void Cid_3130(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3130/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3130/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3130/3130.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_3140_fehler(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3140_fehler/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3140_fehler/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3140_fehler/3140.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 50: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Die berechnete Leitungslänge ist wesentlich kürzer als die Distanz zwischen den Knoten"));
    }
    
    @Test
    public void Cid_3140(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3140/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3140/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3140/3140.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertFalse(content.contains("Warning"));
        assertFalse(content.contains("Error"));
    }
    
    @Test
    public void Cid_3150_fehler(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3150_fehler/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3150_fehler/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3150_fehler/3150.xtf", settings);
        assertTrue(valid);
        
        String content = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertTrue(content.contains("Warning: line 50: VSADSSMINI_2020_LV95.VSADSSMini.Leitung: tid deg5mQXX20002001: Die berechnete Leitungslänge ist wesentlich grösser als die Distanz zwischen den Knoten"));
    }
    
    @Test
    public void Cid_3150(@TempDir Path tempDir) throws Exception {
        String logFileName = Paths.get(tempDir.toFile().getAbsolutePath(), LOGFILE_NAME).toFile().getAbsolutePath();
        
        Settings settings = new Settings();
        settings.setValue(Validator.SETTING_LOGFILE, logFileName);
        settings.setValue(Validator.SETTING_ILIDIRS, TEST_IN+"models/;"+TEST_IN+"leitung/3150/");
        settings.setValue(Validator.SETTING_CONFIGFILE, TEST_IN+"leitung/3150/config.toml");
        settings.setValue(Validator.SETTING_PLUGINFOLDER, "../lib/build/libs");

        boolean valid = Validator.runValidation(TEST_IN+"leitung/3150/3150.xtf", settings);
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

        boolean valid = Validator.runValidation(TEST_IN+"leitung/9102_02/9102_02_ok.xtf", settings);
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
