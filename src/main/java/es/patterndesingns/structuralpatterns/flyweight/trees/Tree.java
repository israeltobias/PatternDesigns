package es.patterndesingns.structuralpatterns.flyweight.trees;

import java.awt.*;

public class Tree {
    private int x;
    private int y;
    private final TreeType type;

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw(Graphics g) {
        type.draw(g, x, y);
    }
}
