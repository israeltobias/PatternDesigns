package es.patterndesingns.patterns;

import es.patterndesingns.behavioralpatterns.state.ui.Player;
import es.patterndesingns.behavioralpatterns.state.ui.UI;

public class StatePattern {

    private StatePattern() {
        super();
    }

    public static void execute(boolean execute) {
        if(execute) {
            Player player = new Player();
            UI ui = new UI(player);
            ui.init();
        } else {
            System.out.println("State pattern not executed");
        }
    }
}
