package canvas.dto.propertyDto.propertyDtos;

import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.model.shape.ShapeAbstractClass;

import java.awt.*;

public class ColorPropertyDto extends PropertyDtoAbstractClass {
    public ColorPropertyDto(Color color) {
        super(shapeAbstractClass);
        this.color = color;
    }
}
