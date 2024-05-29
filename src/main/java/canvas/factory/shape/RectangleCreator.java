package canvas.factory.shape;

import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.shapes.RectangleShape;

import java.awt.*;
import java.awt.event.MouseEvent;

public class RectangleCreator extends ShapeCreatorAbstractClass{
    public RectangleCreator() {
        super();
    }
    @Override
    public void createShape(MouseEvent e, int id) {
        int xPos = e.getX();
        int yPos = e.getY();
        int width = 100;
        int height = 100;
        Color color = Color.blue;
        int opacity = 100;
        boolean shadow = false;
        boolean frame = false;
        controller.createShape(new RectangleShape(id, xPos, yPos, width, height, color, opacity, shadow, frame));
    }
}
