package canvas.factory.dto.propertyDtoFactories;

import canvas.dto.propertyDto.propertyDtos.BringFrontPropertyDto;
import canvas.dto.propertyDto.propertyDtos.SendBackPropertyDto;
import canvas.factory.dto.PropertyDtoCreatorAbstractClass;

public class SendBackDtoCreator extends PropertyDtoCreatorAbstractClass {
    public SendBackDtoCreator() {
        super();
    }
    @Override
    public void createPropertyDto() {
        SendBackPropertyDto sendBackPropertyDto = new SendBackPropertyDto(clickedShapes);
        controller.updateShape(sendBackPropertyDto);
    }
}