package canvas.state.shapeCreateStates;

import canvas.controller.Controller;
import canvas.factory.shape.LineCreator;
import canvas.model.shape.ShapeAbstractClass;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class LineShapeCreateState extends ShapeCreateStateAbstractClass {

    public LineShapeCreateState(Controller controller, int seq) {
        super(controller, seq);
        this.shapeCreatorInterface = new LineCreator();
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