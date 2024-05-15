package canvas.observer;

import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.composite.ShapeComposite;

import java.util.List;

public interface Observer {
    void updateAllShapes(List<ShapeAbstractClass> shapes);
    void updateClickedShapes(ShapeComposite shapeComposite);
}

