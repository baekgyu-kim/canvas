package canvas.state;

import canvas.controller.Controller;
import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.composite.ShapeComposite;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class StateAbstractClass implements StateInterface{
    protected Controller controller;
    protected List<ShapeAbstractClass> allShapes;
    protected ShapeComposite shapeComposite;
    protected int seq;

    public StateAbstractClass(Controller controller){
        this.controller = controller;
    }
    public StateAbstractClass(Controller controller, int seq){
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
