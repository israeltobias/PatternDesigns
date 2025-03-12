package es.patterndesingns.behavioralpatterns.visitor.visitor;

import es.patterndesingns.behavioralpatterns.visitor.shapes.Circle;
import es.patterndesingns.behavioralpatterns.visitor.shapes.CompoundShape;
import es.patterndesingns.behavioralpatterns.visitor.shapes.Dot;
import es.patterndesingns.behavioralpatterns.visitor.shapes.Rectangle;

public interface Visitor {
    String visitDot(Dot dot);

    String visitCircle(Circle circle);

    String visitRectangle(Rectangle rectangle);

    String visitCompoundGraphic(CompoundShape cg);
}
