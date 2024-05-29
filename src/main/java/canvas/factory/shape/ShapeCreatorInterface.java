package canvas.factory.shape;

import canvas.model.shape.ShapeAbstractClass;

import java.awt.event.MouseEvent;

public interface ShapeCreatorInterface {
    void createShape(MouseEvent e, int id);
    void createShape(MouseEvent e, int id, String text);
}
