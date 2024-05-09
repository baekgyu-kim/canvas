package canvas.dto.propertyDto.propertyDtos;

import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.composite.ShapeComposite;

import java.awt.*;

public class BringFrontPropertyDto extends PropertyDtoAbstractClass {
    public BringFrontPropertyDto(ShapeComposite shapeComposite) {
        super(shapeComposite);
    }

    @Override
    public void applyPropertyUpdate(ShapeAbstractClass shapeAbstractClass) {
        shapeAbstractClass.bringFront();
    }
}
