package canvas.controller.dto.propertyDto.propertyDtos;

import canvas.controller.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.composite.ShapeComposite;

public class MovePropertyDto extends PropertyDtoAbstractClass {
    public MovePropertyDto(ShapeComposite shapeComposite, Integer newX, Integer newY) {
        super(shapeComposite, newX, newY);
    }

    @Override
    public void applyPropertyUpdate(ShapeAbstractClass shapeAbstractClass) {
        shapeAbstractClass.changeMove(this.value1, this.value2);
    }
}
