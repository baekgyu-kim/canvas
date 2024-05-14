package canvas.controller.dto.propertyDto.propertyDtos;

import canvas.controller.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.composite.ShapeComposite;

public class ShadowPropertyDto extends  PropertyDtoAbstractClass {
    public ShadowPropertyDto(ShapeComposite shapeComposite, Boolean hasShadow) {
        super(shapeComposite, hasShadow);
    }
    @Override
    public void applyPropertyUpdate(ShapeAbstractClass shapeAbstractClass) {
        shapeAbstractClass.changeShade(this.boolValue);
    }
}


