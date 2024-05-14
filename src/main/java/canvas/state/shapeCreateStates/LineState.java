package canvas.state.shapeCreateStates;

import canvas.controller.Controller;
import canvas.model.shape.shapes.LineShape;
import canvas.state.StateAbstractClass;

import java.awt.*;
import java.awt.event.MouseEvent;

public class LineState extends StateAbstractClass {

    public LineState(Controller controller, int seq) {
        super(controller, seq);
    }

    @Override
    public void handleMouseClick(MouseEvent e) {
        int id = seq;
        int xPos = e.getX();
        int yPos = e.getY();
        int width = 100;
        int height = 2;
        Color color = Color.black;
        int opacity = 100;
        boolean shadow = false;
        boolean frame = false;
        LineShape lineShape = new LineShape(id, xPos, yPos, width, height, color, opacity, shadow, frame);
        controller.createShape(lineShape);
    }

    @Override
    public void activateState() {
        System.out.println("Line State activated: Click to create a line.");
    }

    @Override
    public void deactivateState() {
        System.out.println("Line State deactivated.");
    }
}