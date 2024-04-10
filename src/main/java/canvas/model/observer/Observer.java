package canvas.model.observer;

import canvas.dto.ShapeDto;
import canvas.model.shape.Shape;

import java.util.List;

// MVC에서 View가 Observer
public interface Observer {
    void update(List<Shape> shapes);
}