package canvas.state.clickState;

import canvas.controller.Controller;
import canvas.model.shape.ShapeAbstractClass;
import canvas.state.StateInterface;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class ClickState implements StateInterface {
    protected Controller controller;
    protected List<ShapeAbstractClass> allShapes;

    public ClickState(Controller controller){
        this.controller = controller;
    }

    @Override
    public void handleMouseClick(MouseEvent e, ArrayList<ShapeAbstractClass> allShapes) {
        int x = e.getX();
        int y = e.getY();
        if (allShapes.isEmpty()) {
            System.out.println("No shapes to interact with.");
            return;
        }
        int clickedShapeIndex = findShapeByPoint(x, y, allShapes);
        if (clickedShapeIndex != -1) {
            controller.toggleShapeClick(allShapes.get(clickedShapeIndex).getId());
        } else {
            controller.clearClicks();
        }
    }

    private int findShapeByPoint(int x, int y, ArrayList<ShapeAbstractClass> allShapes) {
        for (int i = allShapes.size() - 1; i >= 0; i--) {
            ShapeAbstractClass shape = allShapes.get(i);
            if (isPointInsideShape(x, y, shape)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isPointInsideShape(int x, int y, ShapeAbstractClass shape) {
        return x >= shape.getXPos() && x <= (shape.getXPos() + shape.getWidth()) &&
                y >= shape.getYPos() && y <= (shape.getYPos() + shape.getHeight());
    }

    @Override
    public void activateState() {
        System.out.println("Click State activated: Click to select shapes.");
    }

    @Override
    public void deactivateState() {
        System.out.println("Click State deactivated.");
    }
}
