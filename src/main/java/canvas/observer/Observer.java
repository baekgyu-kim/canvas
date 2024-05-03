package canvas.observer;

import canvas.factory.shape.ShapeAbstractClass;

import java.util.List;

// MVC에서 View가 Observer
public interface Observer {
    void update(List<ShapeAbstractClass> shapes);
}

