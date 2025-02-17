package es.patterndesingns.creationalpatterns.prototype.shapes;

import java.util.Objects;

public abstract class PrototypeShape {


    private int x;
    private int y;
    private String color;

    protected PrototypeShape(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    protected PrototypeShape(PrototypeShape target) {
        if (target != null) {
            this.x = target.x;
            this.y = target.y;
            this.color = target.color;
        }
    }

    public abstract PrototypeShape copy();

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof PrototypeShape)) return false;
        PrototypeShape shape2 = (PrototypeShape) object2;
        return shape2.x == x && shape2.y == y && Objects.equals(shape2.color, color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, color);
    }

}
