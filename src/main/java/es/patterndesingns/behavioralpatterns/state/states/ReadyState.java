package es.patterndesingns.behavioralpatterns.state.states;

import es.patterndesingns.behavioralpatterns.state.ui.Player;

public class ReadyState extends State{

    private static final String LOCKED = "Locked...";
    
    public ReadyState(Player player) {
        super(player);
    }

    @Override
    public String onLock() {
        player.changeState(new LockedState(player));
        return LOCKED;
    }

    @Override
    public String onPlay() {
        String action = player.startPlayback();
        player.changeState(new PlayingState(player));
        return action;
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
