package es.patterndesingns.creationalpatterns.prototype.shapes;

import java.util.Objects;

public class PrototypeRectangle extends PrototypeShape{
    private int width;
    private int height;

    public PrototypeRectangle(int width, int height, int x, int y, String color) {
        super(x,y, color);
        this.width = width;
        this.height = height;
    }

    public PrototypeRectangle(PrototypeRectangle target) {
        super(target);
        if (target != null) {
            this.width = target.width;
            this.height = target.height;
        }
    }

    @Override
    public PrototypeShape copy() {
        return new PrototypeRectangle(this);
    }

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof PrototypeRectangle) || !super.equals(object2)) return false;
        PrototypeRectangle shape2 = (PrototypeRectangle) object2;
        return shape2.width == width && shape2.height == height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), width, height);
    }

}
