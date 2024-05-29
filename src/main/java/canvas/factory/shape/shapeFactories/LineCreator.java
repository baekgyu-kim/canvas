package canvas.factory.shape.shapeFactories;

import canvas.factory.shape.ShapeCreatorAbstractClass;
import canvas.model.shape.shapes.LineShape;

import java.awt.*;
import java.awt.event.MouseEvent;

public class LineCreator extends ShapeCreatorAbstractClass {
    public LineCreator(){
        super();
    }
    @Override
    public void createShape(MouseEvent e, int id) {
        int xPos = e.getX();
        int yPos = e.getY();
        int width = 100;
        int height = 2;
        Color color = Color.black;
        int opacity = 100;
        boolean shadow = false;
        boolean frame = false;
        controller.createShape(new LineShape(id, xPos, yPos, width, height, color, opacity, shadow, frame));
    }
}
