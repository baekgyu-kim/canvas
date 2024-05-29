package canvas.state.shapeCreateStates;

import canvas.factory.shape.shapeFactories.EllipseCreator;
import canvas.model.shape.ShapeAbstractClass;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class EllipseShapeCreateState extends ShapeCreateStateAbstractClass {
    public EllipseShapeCreateState() {
        super();
        this.shapeCreatorInterface = new EllipseCreator();
    }

    @Override
    public void handleMouseClick(MouseEvent e, ArrayList<ShapeAbstractClass> allShapes) {
        int id = allShapes.size();
        shapeCreatorInterface.createShape(e, id);
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