package canvas.dto.propertyDto.propertyDtos;

import canvas.dto.propertyDto.PropertyDtoAbstractClass;

import java.awt.*;

public class ResizePropertyDto extends PropertyDtoAbstractClass {
    public ResizePropertyDto(Integer width, Integer height) {
        this.width = width;
        this.height = height;
    }
}
