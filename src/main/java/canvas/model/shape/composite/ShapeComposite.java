package canvas.model.shape.composite;

import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.ShapeInterface;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ShapeComposite implements ShapeInterface {
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

    @Override
    public void draw(Graphics g) {
        for (ShapeAbstractClass child : children) {
            child.draw(g);
        }
    }

    public void updateShapesInComposite(PropertyDtoAbstractClass dto){
        for (ShapeAbstractClass child : children) {
            dto.applyPropertyUpdate(child);
        }
    }

    @Override
    public void changeColor(Color color) {

    }

    @Override
    public void changeMove(int newX, int newY) {

    }

    @Override
    public void changeSize(int newWidth, int newHeight) {

    }

    @Override
    public void changeOpacity(int opacity) {

    }

    @Override
    public void bringFront() {

    }

    @Override
    public void sendBack() {

    }


    public Integer shapesCount(){
        return this.children.size();
    }
}