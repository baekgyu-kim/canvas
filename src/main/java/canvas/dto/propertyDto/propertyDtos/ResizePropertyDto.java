package canvas.dto.propertyDto.propertyDtos;

import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.model.shape.composite.ShapeComposite;

import java.awt.*;

public class ResizePropertyDto extends PropertyDtoAbstractClass {
    public ResizePropertyDto(ShapeComposite shapeComposite, Integer newWidth, Integer newHeight) {
        super(shapeComposite, newWidth, newHeight);
    }

    @Override
    public void applyPropertyUpdate(ShapeComposite shapeComposite, Integer newWidth, Integer newHeight) {

    }
}
