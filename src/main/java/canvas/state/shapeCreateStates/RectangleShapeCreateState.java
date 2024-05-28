package canvas.state.shapeCreateStates;

import canvas.controller.Controller;
import canvas.factory.shape.RectangleCreator;
import canvas.model.shape.ShapeAbstractClass;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class RectangleShapeCreateState extends ShapeCreateStateAbstractClass {

    public RectangleShapeCreateState(Controller controller, int seq) {
        super(controller, seq);
        this.shapeCreatorInterface = new RectangleCreator();
    }

    @Override
    public void handleMouseClick(MouseEvent e, ArrayList<ShapeAbstractClass> allShapes) {
        int id = allShapes.size();
        ShapeAbstractClass rectangleShape = shapeCreatorInterface.createShape(e, id);
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