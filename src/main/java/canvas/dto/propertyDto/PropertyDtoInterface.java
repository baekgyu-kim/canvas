package canvas.dto.propertyDto;

import canvas.model.shape.ShapeAbstractClass;

import java.awt.*;

public interface PropertyDtoInterface {
    public  void applyPropertyUpdate(ShapeAbstractClass shapeAbstractClass);
    public  void applyPropertyUpdate(ShapeAbstractClass shapeAbstractClass, Color color);
    public  void applyPropertyUpdate(ShapeAbstractClass shapeAbstractClass, Integer int1);
    public  void applyPropertyUpdate(ShapeAbstractClass shapeAbstractClass, Integer int1, Integer int2);
}
