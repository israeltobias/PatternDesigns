package es.patterndesingns.structuralpatterns.flyweight.trees;

import java.awt.*;

public class TreeType {
    private String name;
    private final Color color;
    private String otherTreeData;

    public String getOtherTreeData() {
        return otherTreeData;
    }

    public void setOtherTreeData(String otherTreeData) {
        this.otherTreeData = otherTreeData;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeType(String name, Color color, String otherTreeData) {
        this.name = name;
        this.color = color;
        this.otherTreeData = otherTreeData;
    }

    public void draw(Graphics g, int x, int y) {
        g.setColor(Color.BLACK);
        g.fillRect(x - 1, y, 3, 5);
        g.setColor(color);
        g.fillOval(x - 5, y - 10, 10, 10);
    }
}
