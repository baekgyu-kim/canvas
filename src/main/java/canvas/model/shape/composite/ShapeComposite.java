package canvas.model.shape.composite;

import canvas.dto.updateDto.UpdateDtoAbstractClass;
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
    public void clear() {
        children.clear();
    }


    @Override
    public void draw(Graphics g) {
        for (ShapeAbstractClass child : children) {
            child.draw(g);
        }
    }

    @Override
    public void update(UpdateDtoAbstractClass dto) {
        for (ShapeAbstractClass child : children) {
            child.update(dto);
        }
    }
}