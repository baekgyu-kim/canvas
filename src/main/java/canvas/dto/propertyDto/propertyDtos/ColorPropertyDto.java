package canvas.dto.propertyDto.propertyDtos;

import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.composite.ShapeComposite;

import java.awt.*;

public class ColorPropertyDto extends PropertyDtoAbstractClass {
    public ColorPropertyDto(ShapeComposite shapeComposite, Color color) {
        super(shapeComposite, color);
    }

    @Override
    public void applyPropertyUpdate(ShapeAbstractClass shapeAbstractClass) {
        shapeAbstractClass.changeColor(this.color);
    }
}
