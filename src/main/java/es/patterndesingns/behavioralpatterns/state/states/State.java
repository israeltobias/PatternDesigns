package es.patterndesingns.behavioralpatterns.state.states;

import es.patterndesingns.behavioralpatterns.state.ui.Player;

public abstract class State {

    Player player;

    /**
     * Context passes itself through the state constructor. This may help a
     * state to fetch some useful context data if needed.
     */
    State(Player player) {
        this.player = player;
    }

    public abstract String onLock();
    public abstract String onPlay();
    public abstract String onNext();
    public abstract String onPrevious();
}
