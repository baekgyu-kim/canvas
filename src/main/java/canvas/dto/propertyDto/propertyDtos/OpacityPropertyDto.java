package canvas.dto.propertyDto.propertyDtos;

import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.model.shape.ShapeAbstractClass;

import java.awt.*;

public class OpacityPropertyDto extends PropertyDtoAbstractClass {
    public OpacityPropertyDto(int opacity) {
        this.opacity = opacity;
    }
}
