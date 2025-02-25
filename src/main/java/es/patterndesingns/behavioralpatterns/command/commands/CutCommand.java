package es.patterndesingns.behavioralpatterns.command.commands;

import es.patterndesingns.behavioralpatterns.command.editor.Editor;
import org.apache.commons.lang3.StringUtils;

public class CutCommand extends Command{
    public CutCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        if(StringUtils.isBlank(editor.getTextField().getSelectedText())) return false;


        backup();
        String source = editor.getTextField().getText();
        editor.setClipboard(editor.getTextField().getSelectedText());
        editor.getTextField().setText(cutString(source));
        return true;
    }

    private String cutString(String source) {
        String start = source.substring(0, editor.getTextField().getSelectionStart());
        String end = source.substring(editor.getTextField().getSelectionEnd());
        return start + end;
    }
}
