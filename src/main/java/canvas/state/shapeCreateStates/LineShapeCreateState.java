package canvas.state.shapeCreateStates;

import canvas.factory.shape.shapeFactories.LineCreator;
import canvas.model.shape.ShapeAbstractClass;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class LineShapeCreateState extends ShapeCreateStateAbstractClass {

    public LineShapeCreateState() {
        super();
        this.shapeCreatorInterface = new LineCreator();
    }

    @Override
    public void handleMouseClick(MouseEvent e, ArrayList<ShapeAbstractClass> allShapes) {
        int id = allShapes.size();
        shapeCreatorInterface.createShape(e, id);
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