package es.patterndesingns.patterns;


import es.patterndesingns.behavioralpatterns.memento.editor.Editor;
import es.patterndesingns.behavioralpatterns.memento.shapes.Circle;
import es.patterndesingns.behavioralpatterns.memento.shapes.CompoundShape;
import es.patterndesingns.behavioralpatterns.memento.shapes.Dot;
import es.patterndesingns.behavioralpatterns.memento.shapes.Rectangle;

import java.awt.*;


public class MementoPattern {

    private MementoPattern() {
        super();
    }

    public static void execute(boolean execute) {
        int dotSize =3;
        if(execute) {
            Editor editor = new Editor();
            editor.loadShapes(
                    new Circle(10, 10, 10, Color.BLUE),

                    new CompoundShape(
                            new Circle(110, 110, 50, Color.RED),
                            new Dot(160, 160, Color.RED,dotSize)
                    ),

                    new CompoundShape(
                            new Rectangle(250, 250, 100, 100, Color.GREEN),
                            new Dot(240, 240, Color.GREEN,dotSize),
                            new Dot(240, 360, Color.GREEN,dotSize),
                            new Dot(360, 360, Color.GREEN,dotSize),
                            new Dot(360, 240, Color.GREEN,dotSize)
                    )
            );
        } else {
            System.out.println("Memento pattern is not executed.");
        }
    }
}
