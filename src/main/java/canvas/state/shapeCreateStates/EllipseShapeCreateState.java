package canvas.state.shapeCreateStates;

import canvas.controller.Controller;
import canvas.creator.EllipseCreator;
import canvas.model.shape.ShapeAbstractClass;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class EllipseShapeCreateState extends ShapeCreateStateAbstractClass {
    private Controller controller;
    public EllipseShapeCreateState() {
        super();
        this.shapeCreatorInterface = new EllipseCreator();
        this.controller = Controller.getInstance();
    }

    @Override
    public void handleMouseClick(MouseEvent e, ArrayList<ShapeAbstractClass> allShapes) {
        int id = allShapes.size();
        ShapeAbstractClass ellipseShape = shapeCreatorInterface.createShape(e, id);
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