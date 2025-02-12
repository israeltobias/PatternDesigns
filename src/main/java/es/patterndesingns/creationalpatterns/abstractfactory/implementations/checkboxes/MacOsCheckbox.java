package es.patterndesingns.creationalpatterns.abstractfactory.implementations.checkboxes;

import es.patterndesingns.creationalpatterns.abstractfactory.interfaces.CheckBox;

public class MacOsCheckbox implements CheckBox {
    @Override
    public void paint() {
        System.out.println("You have created MacOSCheckbox.");
    }
}
