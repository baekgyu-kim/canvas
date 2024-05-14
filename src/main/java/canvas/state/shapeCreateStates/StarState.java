package canvas.state.shapeCreateStates;

import canvas.controller.Controller;
import canvas.model.shape.shapes.StarShape;
import canvas.state.StateAbstractClass;

import java.awt.*;
import java.awt.event.MouseEvent;

public class StarState extends StateAbstractClass {

    public StarState(Controller controller, int seq) {
        super(controller, seq);
    }

    @Override
    public void handleMouseClick(MouseEvent e) {
        int id = seq;
        int xPos = e.getX();
        int yPos = e.getY();
        int width = 100;
        int height = 100;
        Color color = Color.yellow;
        int opacity = 100;
        boolean shadow = false;
        boolean frame = false;
        StarShape starShape = new StarShape(id, xPos, yPos, width, height, color, opacity, shadow, frame);
        controller.createShape(starShape);
    }

    @Override
    public void activateState() {
        System.out.println("Star State activated: Click to create a star.");
    }

    @Override
    public void deactivateState() {
        System.out.println("Star State deactivated.");
    }
}