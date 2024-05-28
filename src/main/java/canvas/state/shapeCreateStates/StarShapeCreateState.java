package canvas.state.shapeCreateStates;

import canvas.controller.Controller;
import canvas.factory.shape.StarCreator;
import canvas.model.shape.ShapeAbstractClass;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class StarShapeCreateState extends ShapeCreateStateAbstractClass {

    public StarShapeCreateState(Controller controller, int seq) {
        super(controller, seq);
        this.shapeCreatorInterface = new StarCreator();
    }

    @Override
    public void handleMouseClick(MouseEvent e, ArrayList<ShapeAbstractClass> allShapes) {
        int id = allShapes.size();
        ShapeAbstractClass starShape = shapeCreatorInterface.createShape(e, id);
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