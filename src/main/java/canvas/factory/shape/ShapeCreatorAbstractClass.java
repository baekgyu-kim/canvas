package canvas.factory.shape;

import canvas.model.shape.ShapeAbstractClass;

import java.awt.event.MouseEvent;

public abstract class ShapeCreatorAbstractClass implements ShapeCreatorInterface{
    @Override
    public ShapeAbstractClass createShape(MouseEvent e, int id) {
        return null;
    }

    @Override
    public ShapeAbstractClass createShape(MouseEvent e, int id, String text) {
        return null;
    }
}
