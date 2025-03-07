package es.patterndesingns.behavioralpatterns.memento.commands;

import es.patterndesingns.behavioralpatterns.memento.editor.Editor;
import es.patterndesingns.behavioralpatterns.memento.shapes.Shape;

import java.awt.*;


public class ColorCommand implements Command{
    private final Editor editor;
    private final Color color;

    public ColorCommand(Editor editor, Color color) {
        this.editor = editor;
        this.color = color;
    }

    @Override
    public String getName() {
        return "Colorize: " + color.toString();
    }

    @Override
    public void execute() {
        for (Shape child : editor.getShapes().getSelected()) {
            child.setColor(color);
        }
    }
}
