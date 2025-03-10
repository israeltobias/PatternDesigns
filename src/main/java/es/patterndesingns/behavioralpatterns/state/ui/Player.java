package es.patterndesingns.behavioralpatterns.state.ui;

import es.patterndesingns.behavioralpatterns.state.states.ReadyState;
import es.patterndesingns.behavioralpatterns.state.states.State;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private State state;
    private boolean playing = false;
    private final List<String> playlist = new ArrayList<>();
    private int currentTrack = 0;
    private static final String STR_PLAYING ="Playing ";

    public Player() {
        this.state = new ReadyState(this);
        setPlaying(true);
        for (int i = 1; i <= 12; i++) {
            playlist.add("Track " + i);
        }
    }

    public void changeState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public boolean isPlaying() {
        return playing;
    }

    public String startPlayback() {
        return STR_PLAYING + playlist.get(currentTrack);
    }

    public String nextTrack() {
        currentTrack = (currentTrack + 1) % playlist.size();
        return STR_PLAYING + playlist.get(currentTrack);
    }

    public String previousTrack() {
        currentTrack = (currentTrack - 1 + playlist.size()) % playlist.size();
        return STR_PLAYING + playlist.get(currentTrack);
    }

    public void setCurrentTrackAfterStop() {
        this.currentTrack = 0;
    }
}
