package canvas.factory.dto.propertyDtoFactories;

import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.dto.propertyDto.propertyDtos.ResizePropertyDto;
import canvas.factory.dto.PropertyDtoCreatorAbstractClass;

public class ResizeDtoCreator extends PropertyDtoCreatorAbstractClass {
    public ResizeDtoCreator() {
        super();
    }
    @Override
    public void createPropertyDto(int newWidth, int newHeight) {
        PropertyDtoAbstractClass resizePropertyDto = new ResizePropertyDto(newWidth, newHeight);
        controller.updateShape(resizePropertyDto);
    }
}
