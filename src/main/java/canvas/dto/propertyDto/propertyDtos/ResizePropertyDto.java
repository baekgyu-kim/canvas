package canvas.dto.propertyDto.propertyDtos;

import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.composite.ShapeComposite;

public class ResizePropertyDto extends PropertyDtoAbstractClass {
    public ResizePropertyDto(ShapeComposite shapeComposite, Integer newWidth, Integer newHeight) {
        super(shapeComposite, newWidth, newHeight);
    }

    @Override
    public void applyPropertyUpdate(ShapeAbstractClass shapeAbstractClass) {
        shapeAbstractClass.changeSize(this.value1, this.value2);
    }
}
