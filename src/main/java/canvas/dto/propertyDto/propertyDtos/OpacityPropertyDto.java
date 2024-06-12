package canvas.dto.propertyDto.propertyDtos;

import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.model.shape.ShapeAbstractClass;

public class OpacityPropertyDto extends PropertyDtoAbstractClass {
    public OpacityPropertyDto(Integer newOpacity) {
        super(newOpacity);
    }

    @Override
    public void applyPropertyUpdate(ShapeAbstractClass shapeAbstractClass) {
        shapeAbstractClass.changeOpacity(this.value1);
    }
}
