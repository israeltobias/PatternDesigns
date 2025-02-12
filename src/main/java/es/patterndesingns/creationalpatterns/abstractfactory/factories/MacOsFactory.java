package es.patterndesingns.creationalpatterns.abstractfactory.factories;

import es.patterndesingns.creationalpatterns.abstractfactory.implementations.buttons.MacOsButton;
import es.patterndesingns.creationalpatterns.abstractfactory.implementations.checkboxes.MacOsCheckbox;
import es.patterndesingns.creationalpatterns.abstractfactory.interfaces.Button;
import es.patterndesingns.creationalpatterns.abstractfactory.interfaces.CheckBox;
import es.patterndesingns.creationalpatterns.abstractfactory.interfaces.GUIFactory;

public class MacOsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOsButton();
    }

    @Override
    public CheckBox createCheckbox() {
        return new MacOsCheckbox();
    }
}
