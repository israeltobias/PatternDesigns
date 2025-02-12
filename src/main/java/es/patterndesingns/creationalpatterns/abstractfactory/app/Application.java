package es.patterndesingns.creationalpatterns.abstractfactory.app;

import es.patterndesingns.creationalpatterns.abstractfactory.interfaces.Button;
import es.patterndesingns.creationalpatterns.abstractfactory.interfaces.CheckBox;
import es.patterndesingns.creationalpatterns.abstractfactory.interfaces.GUIFactory;


public class Application {
    private Button button;
    private CheckBox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }
}
