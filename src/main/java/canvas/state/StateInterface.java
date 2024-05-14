package canvas.state;

import canvas.observer.Observer;

import java.awt.event.MouseEvent;

public interface StateInterface {
    void handleMouseClick(MouseEvent e);
    void handleMouseDrag(MouseEvent e);
    void handleMouseRelease(MouseEvent e);
    void activateState();
    void deactivateState();
}
