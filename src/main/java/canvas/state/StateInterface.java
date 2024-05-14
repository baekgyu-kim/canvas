package canvas.state;

import canvas.model.shape.ShapeAbstractClass;
import canvas.observer.Observer;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public interface StateInterface {
    void handleMouseClick(MouseEvent e, ArrayList<ShapeAbstractClass> allShapes);
    void activateState();
    void deactivateState();
}
