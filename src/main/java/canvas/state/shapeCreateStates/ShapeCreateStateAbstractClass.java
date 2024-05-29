package canvas.state.shapeCreateStates;

import canvas.factory.shape.ShapeCreatorInterface;
import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.composite.ShapeComposite;
import canvas.state.StateInterface;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class ShapeCreateStateAbstractClass implements StateInterface {
    protected ShapeCreatorInterface shapeCreatorInterface;
    protected List<ShapeAbstractClass> allShapes;
    protected ShapeComposite shapeComposite;

    public ShapeCreateStateAbstractClass(){
    }
    @Override
    public void handleMouseClick(MouseEvent e, ArrayList<ShapeAbstractClass> allShapes) {}
    @Override
    public void activateState() {}
    @Override
    public void deactivateState() {}
}
