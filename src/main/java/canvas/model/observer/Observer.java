package canvas.model.observer;

import canvas.model.shape.ShapeState;

// MVC에서 View가 Observer
public interface Observer {
    void update(ShapeState state);
}