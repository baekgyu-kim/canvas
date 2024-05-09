package canvas.dto.propertyDto.propertyDtos;

import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.composite.ShapeComposite;

import java.awt.*;

public class SendBackPropertyDto extends PropertyDtoAbstractClass {
    public SendBackPropertyDto(ShapeComposite shapeComposite) {
        super(shapeComposite);
    }

    @Override
    public void applyPropertyUpdate(ShapeAbstractClass shapeAbstractClass) {
        shapeAbstractClass.sendBack();
    }
}
