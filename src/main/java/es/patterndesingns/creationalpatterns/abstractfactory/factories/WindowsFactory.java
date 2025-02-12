package es.patterndesingns.creationalpatterns.abstractfactory.factories;

import es.patterndesingns.creationalpatterns.abstractfactory.implementations.buttons.WindowsButton;
import es.patterndesingns.creationalpatterns.abstractfactory.implementations.checkboxes.WindowsCheckbox;
import es.patterndesingns.creationalpatterns.abstractfactory.interfaces.Button;
import es.patterndesingns.creationalpatterns.abstractfactory.interfaces.CheckBox;
import es.patterndesingns.creationalpatterns.abstractfactory.interfaces.GUIFactory;

public class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public CheckBox createCheckbox() {
        return new WindowsCheckbox();
    }
}
