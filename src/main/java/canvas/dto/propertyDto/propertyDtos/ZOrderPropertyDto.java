package canvas.dto.propertyDto.propertyDtos;

import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.composite.ShapeComposite;

public class ZOrderPropertyDto  extends PropertyDtoAbstractClass {
    public ZOrderPropertyDto(ShapeComposite shapeComposite) {
        super(shapeComposite);
    }

    @Override
    public void applyPropertyUpdate(ShapeAbstractClass shapeAbstractClass) {

    }
}
