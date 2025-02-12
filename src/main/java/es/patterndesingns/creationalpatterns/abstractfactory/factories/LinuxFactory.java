package es.patterndesingns.creationalpatterns.abstractfactory.factories;

import es.patterndesingns.creationalpatterns.abstractfactory.implementations.buttons.LinuxButton;
import es.patterndesingns.creationalpatterns.abstractfactory.implementations.checkboxes.LinuxCheckbox;
import es.patterndesingns.creationalpatterns.abstractfactory.interfaces.Button;
import es.patterndesingns.creationalpatterns.abstractfactory.interfaces.CheckBox;
import es.patterndesingns.creationalpatterns.abstractfactory.interfaces.GUIFactory;

public class LinuxFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new LinuxButton();
    }

    @Override
    public CheckBox createCheckbox() {
        return new LinuxCheckbox();
    }
}
