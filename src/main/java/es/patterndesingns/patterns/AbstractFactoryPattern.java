package es.patterndesingns.patterns;

import es.patterndesingns.creationalpatterns.abstractfactory.app.Application;
import es.patterndesingns.creationalpatterns.abstractfactory.factories.LinuxFactory;
import es.patterndesingns.creationalpatterns.abstractfactory.factories.MacOsFactory;
import es.patterndesingns.creationalpatterns.abstractfactory.factories.WindowsFactory;
import es.patterndesingns.creationalpatterns.abstractfactory.interfaces.GUIFactory;

public class AbstractFactoryPattern {

    public static void execute() {
        Application app;
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            factory = new MacOsFactory();
        } else if (osName.contains("linux")) {
            factory = new LinuxFactory();
        } else {
            factory = new WindowsFactory();
        }
        app = new Application(factory);
        app.paint();
    }
}
