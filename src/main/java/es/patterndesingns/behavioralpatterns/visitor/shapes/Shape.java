package es.patterndesingns.behavioralpatterns.visitor.shapes;

import es.patterndesingns.behavioralpatterns.visitor.visitor.Visitor;

public interface Shape {
    void move(int x, int y);
    void draw();
    String accept(Visitor visitor);
}
