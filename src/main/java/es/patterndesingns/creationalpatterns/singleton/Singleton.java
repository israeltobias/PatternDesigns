package es.patterndesingns.creationalpatterns.singleton;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Singleton {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(Singleton.class));
    private static Singleton instance;
    private final String value;

    public String getValue() {
        return value;
    }

    private Singleton(String value) {
        // The following code emulates slow initialization.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            LOGGER.log(Level.SEVERE, "Interrupted!", ex);
            /* Clean up whatever needs to be handled before interrupting  */
            Thread.currentThread().interrupt();
        }
        this.value = value;
    }

    public static Singleton getInstance(String value) {
        if (instance == null) {
            instance = new Singleton(value);
        }
        return instance;
    }
}
