package es.patterndesingns.patterns;

import es.patterndesingns.structuralpatterns.composite.editor.ImageEditor;
import es.patterndesingns.structuralpatterns.composite.shapes.Circle;
import es.patterndesingns.structuralpatterns.composite.shapes.CompoundShape;
import es.patterndesingns.structuralpatterns.composite.shapes.Dot;
import es.patterndesingns.structuralpatterns.composite.shapes.Rectangle;

import java.awt.*;

public class CompositePattern {

    public static void execute(boolean isActive) {
        if(isActive) {
            ImageEditor editor = new ImageEditor();

            editor.loadShapes(
                    new Circle(10, 10, 10, Color.BLUE),

                    new CompoundShape(
                            new Circle(110, 110, 50, Color.RED),
                            new Dot(160, 160, Color.RED)
                    ),

                    new CompoundShape(
                            new Rectangle(250, 250, 100, 100, Color.GREEN),
                            new Dot(240, 240, Color.GREEN),
                            new Dot(240, 360, Color.GREEN),
                            new Dot(360, 360, Color.GREEN),
                            new Dot(360, 240, Color.GREEN)
                    ),

                    new Circle(80, 190, 25, Color.ORANGE)
            );
        } else {
            System.out.println("Composite: no executed.");
        }
    }
}
