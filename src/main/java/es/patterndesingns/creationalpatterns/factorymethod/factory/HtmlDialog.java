package es.patterndesingns.creationalpatterns.factorymethod.factory;

import es.patterndesingns.creationalpatterns.factorymethod.buttons.Button;
import es.patterndesingns.creationalpatterns.factorymethod.buttons.HtmlButton;

public class HtmlDialog extends Dialog {
    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
