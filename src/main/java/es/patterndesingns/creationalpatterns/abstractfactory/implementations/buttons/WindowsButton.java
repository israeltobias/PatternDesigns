package es.patterndesingns.creationalpatterns.abstractfactory.implementations.buttons;

import es.patterndesingns.creationalpatterns.abstractfactory.interfaces.Button;

public class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("You have created WindowsButton.");
    }
}
