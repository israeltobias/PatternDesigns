package es.patterndesingns.patterns;

import es.patterndesingns.creationalpatterns.prototype.shapes.PrototypeCircle;
import es.patterndesingns.creationalpatterns.prototype.shapes.PrototypeRectangle;
import es.patterndesingns.creationalpatterns.prototype.shapes.PrototypeShape;

import java.util.ArrayList;
import java.util.List;

public class PrototypePattern {

    public static void execute() {
        List<PrototypeShape> shapes = new ArrayList<>();
        List<PrototypeShape> shapesCopy = new ArrayList<>();


        PrototypeCircle circle = new PrototypeCircle(15,10,20,"red");
        shapes.add(circle);

        PrototypeCircle anotherCircle = (PrototypeCircle) circle.copy();
        shapes.add(anotherCircle);

        PrototypeRectangle rectangle = new PrototypeRectangle(10,20,15,25, "blue");
        shapes.add(rectangle);

        for (PrototypeShape shape : shapes) {
            shapesCopy.add(shape.copy());
        }

        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i) != shapesCopy.get(i)) {
                System.out.println(i + ": Shapes are different objects (yay!)");
                if (shapes.get(i).equals(shapesCopy.get(i))) {
                    System.out.println(i + ": And they are identical (yay!)");
                } else {
                    System.out.println(i + ": But they are not identical (booo!)");
                }
            } else {
                System.out.println(i + ": Shape objects are the same (booo!)");
            }
        }
    }
}
