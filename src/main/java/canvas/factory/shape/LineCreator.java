package canvas.factory.shape;

import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.shapes.EllipseShape;
import canvas.model.shape.shapes.LineShape;

import java.awt.*;
import java.awt.event.MouseEvent;

public class LineCreator extends ShapeCreatorAbstractClass{
    @Override
    public ShapeAbstractClass createShape(MouseEvent e, int id) {
        int xPos = e.getX();
        int yPos = e.getY();
        int width = 100;
        int height = 2;
        Color color = Color.black;
        int opacity = 100;
        boolean shadow = false;
        boolean frame = false;
        return new LineShape(id, xPos, yPos, width, height, color, opacity, shadow, frame);
    }
}
