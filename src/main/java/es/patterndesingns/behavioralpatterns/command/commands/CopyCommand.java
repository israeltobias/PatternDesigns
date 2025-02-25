package es.patterndesingns.behavioralpatterns.command.commands;

import es.patterndesingns.behavioralpatterns.command.editor.Editor;

public class CopyCommand extends Command{

    public CopyCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        editor.setClipboard(editor.getTextField().getSelectedText());
        return false;
    }
}
