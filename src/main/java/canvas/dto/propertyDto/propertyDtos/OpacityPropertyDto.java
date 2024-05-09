package canvas.dto.propertyDto.propertyDtos;

import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.composite.ShapeComposite;

import java.awt.*;

public class OpacityPropertyDto extends PropertyDtoAbstractClass {
    public OpacityPropertyDto(ShapeComposite shapeComposite, Integer newOpacity) {
        super(shapeComposite, newOpacity);
    }

    @Override
    public void applyPropertyUpdate(ShapeComposite shapeComposite, Integer newOpacity) {

    }
}
