package canvas.factory.shape.shapeFactories;

import canvas.factory.shape.ShapeCreatorAbstractClass;
import canvas.model.shape.shapes.TextShape;

import java.awt.*;
import java.awt.event.MouseEvent;

public class TextCreator extends ShapeCreatorAbstractClass {
    public TextCreator() {
        super();
    }
    @Override
    public void createShape(MouseEvent e, int id, String text) {
        int xPos = e.getX();
        int yPos = e.getY();
        int width = 100;
        int height = 100;
        Color color = Color.black;
        int opacity = 100;
        boolean shadow = false;
        boolean frame = false;
        controller.createShape(new TextShape(id, xPos, yPos, width, height, color, opacity, shadow, frame, text));
    }
}
