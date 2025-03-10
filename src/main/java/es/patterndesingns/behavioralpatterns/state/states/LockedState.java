package es.patterndesingns.behavioralpatterns.state.states;

import es.patterndesingns.behavioralpatterns.state.ui.Player;

public class LockedState extends State{

    private static final String LOCKED = "Locked";

    LockedState(Player player) {
        super(player);
        player.setPlaying(false);
    }

    @Override
    public String onLock() {
        if (player.isPlaying()) {
            player.changeState(new ReadyState(player));
            return "Stop playing";
        }

        return LOCKED;
    }

    @Override
    public String onPlay() {
        player.changeState(new ReadyState(player));
        return "Ready";
    }

    @Override
    public String onNext() {
        return LOCKED;
    }

    @Override
    public String onPrevious() {
        return LOCKED;
    }
}
