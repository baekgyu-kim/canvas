package canvas.factory.dto.propertyDtoFactories;

import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.dto.propertyDto.propertyDtos.ColorPropertyDto;
import canvas.factory.dto.PropertyDtoCreatorAbstractClass;

import java.awt.*;

public class ColorDtoCreator extends PropertyDtoCreatorAbstractClass {
    public ColorDtoCreator() {
        super();
    }
    @Override
    public void createPropertyDto(Color newColor) {
        PropertyDtoAbstractClass colorPropertyDto = new ColorPropertyDto(newColor);
        controller.updateShape(colorPropertyDto);
    }
}
