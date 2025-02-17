package es.patterndesingns.creationalpatterns.prototype.shapes;

import java.util.Objects;

public class PrototypeCircle extends PrototypeShape{
    private int radius;

    public PrototypeCircle(int radius, int x, int y, String color) {
        super(x,y,color);
        this.radius = radius;
    }

    public PrototypeCircle(PrototypeCircle target) {
        super(target);
        if (target != null) {
            this.radius = target.radius;
        }
    }

    @Override
    public PrototypeShape copy() {
        return new PrototypeCircle(this);
    }

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof PrototypeCircle) || !super.equals(object2)) return false;
        PrototypeCircle shape2 = (PrototypeCircle) object2;
        return shape2.radius == radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), radius);
    }
}
