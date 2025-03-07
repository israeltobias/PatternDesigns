package es.patterndesingns.behavioralpatterns.memento.shapes;

import java.awt.*;

public class Dot extends BaseShape{
    private final int dotSize;

    public Dot(int x, int y, Color color, int dotSize) {
        super(x, y, color);
        this.dotSize = dotSize;
    }

    @Override
    public int getWidth() {
        return dotSize;
    }

    @Override
    public int getHeight() {
        return getWidth();
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.fillRect(x - 1, y - 1, getWidth(), getHeight());
    }
}
