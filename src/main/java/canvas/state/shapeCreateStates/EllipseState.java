package canvas.state.shapeCreateStates;

import canvas.controller.Controller;
import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.shapes.EllipseShape;
import canvas.state.StateAbstractClass;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class EllipseState extends StateAbstractClass {
    public EllipseState(Controller controller, int seq) {
        super(controller, seq);
    }

    @Override
    public void handleMouseClick(MouseEvent e, ArrayList<ShapeAbstractClass> allShapes) {
        int id = allShapes.size();
        int xPos = e.getX();
        int yPos = e.getY();
        int width = 100;
        int height = 100;
        Color color = Color.green;
        int opacity = 100;
        boolean shadow = false;
        boolean frame = false;
        EllipseShape ellipseShape = new EllipseShape(id, xPos, yPos, width, height, color, opacity, shadow, frame);
        controller.createShape(ellipseShape);
    }

    @Override
    public void activateState() {
        System.out.println("Ellipse State activated: Click to create an ellipse.");
    }

    @Override
    public void deactivateState() {
        System.out.println("Ellipse State deactivated.");
    }
}