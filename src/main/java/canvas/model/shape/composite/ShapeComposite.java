package canvas.model.shape.composite;

import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.ShapeInterface;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ShapeComposite implements ShapeInterface {
    private List<ShapeAbstractClass> children = new ArrayList<>();

    public void add(ShapeAbstractClass component) {
        children.add(component);
    }
    public void remove(ShapeAbstractClass component) { children.remove(component);}
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
    public void draw(Graphics g) {
        for (ShapeAbstractClass child : children) {
            child.draw(g);
        }
    }
}