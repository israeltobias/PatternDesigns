package es.patterndesingns.behavioralpatterns.memento.history;

import es.patterndesingns.behavioralpatterns.memento.commands.Command;

import java.util.ArrayList;
import java.util.List;

public class History {
    private  List<Pair> pairsHistory = new ArrayList<>();
    private int virtualSize = 0;

    private static class Pair {
        Command command;
        Memento memento;
        Pair(Command c, Memento m) {
            command = c;
            memento = m;
        }

        private Command getCommand() {
            return command;
        }

        private Memento getMemento() {
            return memento;
        }
    }

    public void push(Command c, Memento m) {
        if (virtualSize != pairsHistory.size() && virtualSize > 0) {
            pairsHistory = pairsHistory.subList(0, virtualSize - 1);
        }
        pairsHistory.add(new Pair(c, m));
        virtualSize = pairsHistory.size();
    }

    public boolean undo() {
        Pair pair = getUndo();
        if (pair == null) {
            return false;
        }
        System.out.println("Undoing: " + pair.getCommand().getName());
        pair.getMemento().restore();
        return true;
    }

    public boolean redo() {
        Pair pair = getRedo();
        if (pair == null) {
            return false;
        }
        System.out.println("Redoing: " + pair.getCommand().getName());
        pair.getMemento().restore();
        pair.getCommand().execute();
        return true;
    }

    private Pair getUndo() {
        if (virtualSize == 0) {
            return null;
        }
        virtualSize = Math.max(0, virtualSize - 1);
        return pairsHistory.get(virtualSize);
    }

    private Pair getRedo() {
        if (virtualSize == pairsHistory.size()) {
            return null;
        }
        virtualSize = Math.min(pairsHistory.size(), virtualSize + 1);
        return pairsHistory.get(virtualSize - 1);
    }
}
