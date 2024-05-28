package canvas.factory.shape;

import canvas.model.shape.ShapeAbstractClass;

import java.awt.event.MouseEvent;

public interface ShapeCreatorInterface {
    ShapeAbstractClass createShape(MouseEvent e, int id);
    ShapeAbstractClass createShape(MouseEvent e, int id, String text);
}
