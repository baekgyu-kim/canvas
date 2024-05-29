package canvas.state.shapeCreateStates;

import canvas.factory.shape.shapeFactories.RectangleCreator;
import canvas.model.shape.ShapeAbstractClass;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class RectangleShapeCreateState extends ShapeCreateStateAbstractClass {
    public RectangleShapeCreateState() {
        super();
        this.shapeCreatorInterface = new RectangleCreator();
    }

    @Override
    public void handleMouseClick(MouseEvent e, ArrayList<ShapeAbstractClass> allShapes) {
        int id = allShapes.size();
        shapeCreatorInterface.createShape(e, id);
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