package canvas.factory.shape.composite;

import canvas.factory.shape.ShapeAbstractClass;
import canvas.factory.shape.ShapeInterface;

import java.util.ArrayList;
import java.util.List;

public class ShapeComposite implements ShapeInterface {
    private List<ShapeAbstractClass> children = new ArrayList<>();

    public void add(ShapeAbstractClass component) {
        children.add(component);
    }
    public void clear() {
        children.clear();
    }
    @Override
    public void move(int deltaX, int deltaY) {
        for (ShapeAbstractClass child : children) {
            child.move(deltaX, deltaY);
        }
    }

    @Override
    public void resize(int newWidth, int newHeight) {
        for (ShapeAbstractClass child : children) {
            child.resize(newWidth, newHeight);
        }
    }
    @Override
    public void draw() {
        for (ShapeAbstractClass child : children) {
            child.draw();
        }
    }
}