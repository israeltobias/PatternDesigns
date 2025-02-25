package es.patterndesingns.behavioralpatterns.command.commands;

import es.patterndesingns.behavioralpatterns.command.editor.Editor;

public abstract class Command {
    public final Editor editor;
    private String backup;

    Command(Editor editor) {
        this.editor = editor;
    }

    void backup() {
        backup = editor.getTextField().getText();
    }

    public void undo() {
        editor.getTextField().setText(backup);
    }

    public abstract boolean execute();
}
