package canvas.state.shapeCreateStates;

import canvas.factory.shape.StarCreator;
import canvas.model.shape.ShapeAbstractClass;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class StarShapeCreateState extends ShapeCreateStateAbstractClass {
    public StarShapeCreateState() {
        super();
        this.shapeCreatorInterface = new StarCreator();
    }

    @Override
    public void handleMouseClick(MouseEvent e, ArrayList<ShapeAbstractClass> allShapes) {
        int id = allShapes.size();
        shapeCreatorInterface.createShape(e, id);
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