package canvas.controller.dto.propertyDto;

import canvas.model.Model;
import canvas.model.shape.ShapeAbstractClass;

public interface PropertyDtoInterface {
    public  void applyPropertyUpdate(ShapeAbstractClass shapeAbstractClass);
    public  void applyPropertyUpdate(Model model);
}
