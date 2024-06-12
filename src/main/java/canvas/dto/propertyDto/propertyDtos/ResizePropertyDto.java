package canvas.dto.propertyDto.propertyDtos;

import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.model.shape.ShapeAbstractClass;

public class ResizePropertyDto extends PropertyDtoAbstractClass {
    public ResizePropertyDto(Integer newWidth, Integer newHeight) {
        super(newWidth, newHeight);
    }

    @Override
    public void applyPropertyUpdate(ShapeAbstractClass shapeAbstractClass) {
        shapeAbstractClass.changeSize(this.value1, this.value2);
    }
}
