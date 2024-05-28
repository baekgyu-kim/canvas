package canvas.dto.propertyDto.propertyDtos;

import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.composite.ShapeComposite;

public class OpacityPropertyDto extends PropertyDtoAbstractClass {
    public OpacityPropertyDto(ShapeComposite shapeComposite, Integer newOpacity) {
        super(shapeComposite, newOpacity);
    }

    @Override
    public void applyPropertyUpdate(ShapeAbstractClass shapeAbstractClass) {
        shapeAbstractClass.changeOpacity(this.value1);
    }
}
