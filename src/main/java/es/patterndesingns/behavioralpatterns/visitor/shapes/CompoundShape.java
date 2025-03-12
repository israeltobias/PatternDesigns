package es.patterndesingns.behavioralpatterns.visitor.shapes;

import es.patterndesingns.behavioralpatterns.visitor.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class CompoundShape implements Shape{
    private final int id;
    private final List<Shape> children = new ArrayList<>();


    public List<Shape> getChildren() {
        return children;
    }

    public CompoundShape(int id) {
        this.id = id;
    }

    @Override
    public void move(int x, int y) {
        // move shape
    }

    @Override
    public void draw() {
        // draw shape
    }

    public int getId() {
        return id;
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitCompoundGraphic(this);
    }

    public void add(Shape shape) {
        children.add(shape);
    }
}
