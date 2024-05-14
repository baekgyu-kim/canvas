package canvas.model.shape.composite;

import canvas.model.shape.ShapeAbstractClass;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ShapeComposite  {
    private List<ShapeAbstractClass> children = new ArrayList<>();

    public void add(ShapeAbstractClass shape) {children.add(shape);}
    public void remove(ShapeAbstractClass shape) { children.remove(shape);}
    public void clear() {children.clear();}

    public boolean is_shape_in_composite(int id) {
        for (ShapeAbstractClass child : children) {
            if (child.getId() == id) {
                return true;

            }
        }
        return false;
    }

    public List<ShapeAbstractClass> getChildren(){
        return this.children;
    }

    public void draw(Graphics g) {
        for (ShapeAbstractClass child : children) {
            child.draw(g);
        }
    }

    public Integer shapesCount(){
        return this.children.size();
    }
}