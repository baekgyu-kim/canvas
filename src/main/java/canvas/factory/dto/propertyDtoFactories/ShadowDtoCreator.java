package canvas.factory.dto.propertyDtoFactories;

import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.dto.propertyDto.propertyDtos.ShadowPropertyDto;
import canvas.factory.dto.PropertyDtoCreatorAbstractClass;

public class ShadowDtoCreator extends PropertyDtoCreatorAbstractClass {
    public ShadowDtoCreator() {
        super();
    }
    @Override
    public void createPropertyDto(Boolean newShadow) {
        PropertyDtoAbstractClass shadowPropertyDto = new ShadowPropertyDto(clickedShapes, newShadow);
        controller.updateShape(shadowPropertyDto);
    }
}
