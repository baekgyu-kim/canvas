package canvas.observer;

import canvas.shape.ShapeAbstractClass;
import canvas.shape.composite.ShapeComposite;

import java.util.List;

// MVC에서 View가 Observer
public interface Observer {
    void updateAllShapes(List<ShapeAbstractClass> shapes);
    void updateClickedShapes(ShapeComposite shapeComposite);
}

