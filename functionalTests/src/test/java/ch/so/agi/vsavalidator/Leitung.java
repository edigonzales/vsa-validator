package ch.so.agi.vsavalidator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.interlis2.validator.Validator;
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
}
