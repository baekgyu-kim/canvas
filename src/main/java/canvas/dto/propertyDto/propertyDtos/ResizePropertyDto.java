package canvas.dto.propertyDto.propertyDtos;

import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.model.shape.ShapeAbstractClass;

import java.util.List;

public class ResizePropertyDto extends PropertyDtoAbstractClass {
    public ResizePropertyDto(List<ShapeAbstractClass> clickedShapes, Integer newWidth, Integer newHeight) {
        super(clickedShapes, newWidth, newHeight);
    }

    @Override
    public void applyPropertyUpdate(ShapeAbstractClass shapeAbstractClass) {
        shapeAbstractClass.changeSize(this.value1, this.value2);
    }
}
