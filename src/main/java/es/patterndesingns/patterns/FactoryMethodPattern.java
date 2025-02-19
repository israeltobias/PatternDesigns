package es.patterndesingns.patterns;

import es.patterndesingns.creationalpatterns.factorymethod.factory.Dialog;
import es.patterndesingns.creationalpatterns.factorymethod.factory.HtmlDialog;
import es.patterndesingns.creationalpatterns.factorymethod.factory.WindowsDialog;

public class FactoryMethodPattern {

    public static void execute() {
        Dialog dialog;
        if (System.getProperty("os.name").equals("Windows 10")) {
            dialog = new WindowsDialog();
        } else {
            dialog = new HtmlDialog();
        }
        dialog.renderWindow();
    }
}
