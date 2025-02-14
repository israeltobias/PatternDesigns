package es.patterndesingns.creationalpatterns.factorymethod.factory;

import es.patterndesingns.creationalpatterns.factorymethod.buttons.Button;
import es.patterndesingns.creationalpatterns.factorymethod.buttons.WindowsButton;

public class WindowsDialog extends Dialog {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
