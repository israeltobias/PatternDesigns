package es.patterndesingns.patterns;

import es.patterndesingns.behavioralpatterns.command.editor.Editor;

public  class CommandPattern {

    private CommandPattern() {
    }

    public static void execute(boolean execute) {
        if(execute) {
            Editor editor = new Editor();
            editor.init();
        } else {
            System.out.println("Command: no executed.");
        }
    }
}
