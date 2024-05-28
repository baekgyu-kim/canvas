package canvas.creator;

import canvas.factory.shape.ShapeCreatorAbstractClass;
import canvas.factory.shape.ShapeCreatorInterface;
import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.shapes.EllipseShape;

import java.awt.*;
import java.awt.event.MouseEvent;

public class EllipseCreator extends ShapeCreatorAbstractClass {
    @Override
    public ShapeAbstractClass createShape(MouseEvent e, int id) {
        int xPos = e.getX();
        int yPos = e.getY();
        int width = 100;
        int height = 100;
        Color color = Color.green;
        int opacity = 100;
        boolean shadow = false;
        boolean frame = false;
        return new EllipseShape(id, xPos, yPos, width, height, color, opacity, shadow, frame);
    }
}
