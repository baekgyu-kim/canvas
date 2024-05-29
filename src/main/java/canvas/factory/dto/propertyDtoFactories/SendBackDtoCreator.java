package canvas.factory.dto.propertyDtoFactories;

import canvas.dto.propertyDto.propertyDtos.ZOrderPropertyDto;
import canvas.factory.dto.PropertyDtoCreatorAbstractClass;

public class SendBackDtoCreator extends PropertyDtoCreatorAbstractClass {
    public SendBackDtoCreator() {
        super();
    }
    @Override
    public void createPropertyDto() {
        ZOrderPropertyDto zOrderPropertyDto = new ZOrderPropertyDto(clickedShapes);
        controller.sendBack(zOrderPropertyDto);
    }
}
