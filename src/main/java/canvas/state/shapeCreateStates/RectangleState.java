package canvas.state.shapeCreateStates;

import canvas.controller.Controller;
import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.shapes.RectangleShape;
import canvas.state.StateAbstractClass;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class RectangleState extends StateAbstractClass {

    public RectangleState(Controller controller, int seq) {
        super(controller, seq);
    }

    @Override
    public void handleMouseClick(MouseEvent e, ArrayList<ShapeAbstractClass> allShapes) {
        int id = allShapes.size();
        int xPos = e.getX();
        int yPos = e.getY();
        int width = 100;
        int height = 100;
        Color color = Color.blue;
        int opacity = 100;
        boolean shadow = false;
        boolean frame = false;
        RectangleShape rectangleShape = new RectangleShape(id, xPos, yPos, width, height, color, opacity, shadow, frame);
        controller.createShape(rectangleShape);
    }

    @Override
    public void activateState() {
        System.out.println("Rectangle State activated: Click to create a rectangle.");
    }

    @Override
    public void deactivateState() {
        System.out.println("Rectangle State deactivated.");
    }
}