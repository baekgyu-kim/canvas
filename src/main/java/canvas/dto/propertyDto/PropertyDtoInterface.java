package canvas.dto.propertyDto;

import canvas.model.shape.composite.ShapeComposite;

import java.awt.*;

public interface PropertyDtoInterface {
    public  void applyPropertyUpdate(ShapeComposite shapeComposite);
    public  void applyPropertyUpdate(ShapeComposite shapeComposite, Color color);
    public  void applyPropertyUpdate(ShapeComposite shapeComposite, Integer int1);
    public  void applyPropertyUpdate(ShapeComposite shapeComposite, Integer int1, Integer int2);
}
