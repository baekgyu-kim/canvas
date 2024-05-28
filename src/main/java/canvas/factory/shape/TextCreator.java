package canvas.factory.shape;

import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.shapes.LineShape;
import canvas.model.shape.shapes.TextShape;

import java.awt.*;
import java.awt.event.MouseEvent;

public class TextCreator extends ShapeCreatorAbstractClass{
    @Override
    public ShapeAbstractClass createShape(MouseEvent e, int id, String text) {
        int xPos = e.getX();
        int yPos = e.getY();
        int width = 100;
        int height = 100;
        Color color = Color.black;
        int opacity = 100;
        boolean shadow = false;
        boolean frame = false;
        return new TextShape(id, xPos, yPos, width, height, color, opacity, shadow, frame, text);
    }
}
