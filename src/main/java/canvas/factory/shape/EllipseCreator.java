package canvas.factory.shape;

import canvas.controller.Controller;
import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.shapes.EllipseShape;

import java.awt.*;
import java.awt.event.MouseEvent;

public class EllipseCreator extends ShapeCreatorAbstractClass {
    public EllipseCreator() {
        super();
    }
    @Override
    public void createShape(MouseEvent e, int id) {
        int xPos = e.getX();
        int yPos = e.getY();
        int width = 100;
        int height = 100;
        Color color = Color.green;
        int opacity = 100;
        boolean shadow = false;
        boolean frame = false;
        controller.createShape(new EllipseShape(id, xPos, yPos, width, height, color, opacity, shadow, frame));
    }
}
