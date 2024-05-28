package canvas.state.shapeCreateStates;

import canvas.controller.Controller;
import canvas.factory.shape.ShapeCreatorInterface;
import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.composite.ShapeComposite;
import canvas.state.StateInterface;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class ShapeCreateStateAbstractClass implements StateInterface {
    protected Controller controller;
    protected ShapeCreatorInterface shapeCreatorInterface;
    protected List<ShapeAbstractClass> allShapes;
    protected ShapeComposite shapeComposite;
    protected int seq;

    public ShapeCreateStateAbstractClass(Controller controller, int seq){
        this.controller = controller;
        this.seq = seq;
    }
    @Override
    public void handleMouseClick(MouseEvent e, ArrayList<ShapeAbstractClass> allShapes) {}
    @Override
    public void activateState() {}
    @Override
    public void deactivateState() {}
}
