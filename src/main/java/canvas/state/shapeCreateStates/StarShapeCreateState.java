package canvas.state.shapeCreateStates;

import canvas.controller.Controller;
import canvas.factory.shape.StarCreator;
import canvas.model.shape.ShapeAbstractClass;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class StarShapeCreateState extends ShapeCreateStateAbstractClass {
    private Controller controller;
    public StarShapeCreateState() {
        super();
        this.shapeCreatorInterface = new StarCreator();
        this.controller = Controller.getInstance();
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