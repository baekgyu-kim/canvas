package canvas.factory.dto.propertyDtoFactories;

import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.dto.propertyDto.propertyDtos.OpacityPropertyDto;
import canvas.factory.dto.PropertyDtoCreatorAbstractClass;

public class OpacityDtoCreator extends PropertyDtoCreatorAbstractClass {
    public OpacityDtoCreator() {
        super();
    }
    @Override
    public void createPropertyDto(int newOpacity) {
        PropertyDtoAbstractClass opacityPropertyDto = new OpacityPropertyDto(shapeComposite, newOpacity);
        controller.updateShape(opacityPropertyDto);
    }
}
