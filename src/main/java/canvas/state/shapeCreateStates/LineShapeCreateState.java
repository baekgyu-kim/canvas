package canvas.state.shapeCreateStates;

import canvas.controller.Controller;
import canvas.factory.shape.LineCreator;
import canvas.model.shape.ShapeAbstractClass;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class LineShapeCreateState extends ShapeCreateStateAbstractClass {
    private Controller controller;


    public LineShapeCreateState() {
        super();
        this.shapeCreatorInterface = new LineCreator();
        this.controller = Controller.getInstance();
    }

    @Override
    public void handleMouseClick(MouseEvent e, ArrayList<ShapeAbstractClass> allShapes) {
        int id = allShapes.size();
        ShapeAbstractClass lineShape = shapeCreatorInterface.createShape(e, id);
        controller.createShape(lineShape);
    }

    @Override
    public void activateState() {
        System.out.println("Line State activated: Click to create a line.");
    }

    @Override
    public void deactivateState() {
        System.out.println("Line State deactivated.");
    }
}