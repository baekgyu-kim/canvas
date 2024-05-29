package canvas.dto.propertyDto.propertyDtos;

import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.model.shape.ShapeAbstractClass;

import java.util.List;

public class MovePropertyDto extends PropertyDtoAbstractClass {
    public MovePropertyDto(List<ShapeAbstractClass> clickedShapes, Integer newX, Integer newY) {
        super(clickedShapes, newX, newY);
    }

    @Override
    public void applyPropertyUpdate(ShapeAbstractClass shapeAbstractClass) {
        shapeAbstractClass.changeMove(this.value1, this.value2);
    }
}
