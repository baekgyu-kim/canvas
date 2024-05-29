package canvas.factory.dto.propertyDtoFactories;

import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.dto.propertyDto.propertyDtos.FramePropertyDto;
import canvas.factory.dto.PropertyDtoCreatorAbstractClass;


public class FrameDtoCreator extends PropertyDtoCreatorAbstractClass {
    public FrameDtoCreator() {
        super();
    }
    @Override
    public void createPropertyDto(Boolean newFrame) {
        PropertyDtoAbstractClass framePropertyDto = new FramePropertyDto(shapeComposite, newFrame);
        controller.updateShape(framePropertyDto);
    }
}
