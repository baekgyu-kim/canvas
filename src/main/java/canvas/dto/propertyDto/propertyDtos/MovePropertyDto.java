package canvas.dto.propertyDto.propertyDtos;

import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.model.shape.ShapeAbstractClass;

public class MovePropertyDto extends PropertyDtoAbstractClass {
    public MovePropertyDto(Integer newX, Integer newY) {
        super(newX, newY);
    }

    @Override
    public void applyPropertyUpdate(ShapeAbstractClass shapeAbstractClass) {
        shapeAbstractClass.changeMove(this.value1, this.value2);
    }
}
