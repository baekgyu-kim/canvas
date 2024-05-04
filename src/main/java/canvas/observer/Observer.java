package canvas.observer;

import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.composite.ShapeComposite;

import java.util.List;

// MVC에서 View가 Observer
public interface Observer {
    void updateAllShapes(List<ShapeAbstractClass> shapes);
    void updateClickedShapes(ShapeComposite shapeComposite);
}

