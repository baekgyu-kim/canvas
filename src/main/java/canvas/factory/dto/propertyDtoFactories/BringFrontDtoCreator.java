package canvas.factory.dto.propertyDtoFactories;

import canvas.dto.propertyDto.propertyDtos.BringFrontPropertyDto;
import canvas.factory.dto.PropertyDtoCreatorAbstractClass;

public class BringFrontDtoCreator extends PropertyDtoCreatorAbstractClass {
    public BringFrontDtoCreator() {
        super();
    }
    @Override
    public void createPropertyDto() {
        BringFrontPropertyDto bringFrontPropertyDto = new BringFrontPropertyDto();
        controller.updateShape(bringFrontPropertyDto);
    }
}
