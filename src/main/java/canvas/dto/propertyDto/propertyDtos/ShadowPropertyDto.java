package canvas.dto.propertyDto.propertyDtos;

import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.model.shape.ShapeAbstractClass;

public class ShadowPropertyDto extends  PropertyDtoAbstractClass {
    public ShadowPropertyDto(Boolean hasShadow) {
        super(hasShadow);
    }
    @Override
    public void applyPropertyUpdate(ShapeAbstractClass shapeAbstractClass) {
        shapeAbstractClass.changeShade(this.boolValue);
    }
}


