package canvas.factory.shape;

import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.shapes.LineShape;
import canvas.model.shape.shapes.StarShape;

import java.awt.*;
import java.awt.event.MouseEvent;

public class StarCreator extends ShapeCreatorAbstractClass{
    @Override
    public ShapeAbstractClass createShape(MouseEvent e, int id) {
        int xPos = e.getX();
        int yPos = e.getY();
        int width = 100;
        int height = 100;
        Color color = Color.red;
        int opacity = 100;
        boolean shadow = false;
        boolean frame = false;
        return new StarShape(id, xPos, yPos, width, height, color, opacity, shadow, frame);
    }
}
