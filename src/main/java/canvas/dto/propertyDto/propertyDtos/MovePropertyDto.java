package canvas.dto.propertyDto.propertyDtos;

import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.model.shape.composite.ShapeComposite;

public class MovePropertyDto extends PropertyDtoAbstractClass {
    public MovePropertyDto(ShapeComposite shapeComposite, Integer newX, Integer newY) {
        super(shapeComposite, newX, newY);
    }

    @Override
    public void applyPropertyUpdate(ShapeComposite shapeComposite, Integer newX, Integer newY) {

    }
}
