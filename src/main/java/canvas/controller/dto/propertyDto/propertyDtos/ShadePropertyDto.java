package canvas.controller.dto.propertyDto.propertyDtos;

import canvas.controller.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.composite.ShapeComposite;

import java.awt.*;

public class ShadePropertyDto extends  PropertyDtoAbstractClass {
    public ShadePropertyDto(ShapeComposite shapeComposite, Boolean hasShade) {
        super(shapeComposite, hasShade);
    }
    @Override
    public void applyPropertyUpdate(ShapeAbstractClass shapeAbstractClass) {
        shapeAbstractClass.changeShade(this.boolValue);
    }
}


