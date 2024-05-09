package canvas.dto.propertyDto;

import canvas.model.Model;
import canvas.model.shape.ShapeAbstractClass;

import java.awt.*;

public interface PropertyDtoInterface {
    public  void applyPropertyUpdate(ShapeAbstractClass shapeAbstractClass);
    public  void applyPropertyUpdate(Model model);
}
