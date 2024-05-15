package canvas.state;

import canvas.model.shape.ShapeAbstractClass;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

public interface StateInterface {
    void handleMouseClick(MouseEvent e, ArrayList<ShapeAbstractClass> allShapes);
    void activateState();
    void deactivateState();
}
