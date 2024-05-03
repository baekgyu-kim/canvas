package canvas.observer;

import canvas.factory.shape.ShapeAbstractClass;
import canvas.factory.shape.composite.ShapeComposite;

import java.awt.*;
import java.util.List;

// MVC에서 View가 Observer
public interface Observer {
    void updateAllShapes(List<ShapeAbstractClass> shapes);
    void updateClickedShapes(ShapeComposite shapeComposite);
}

