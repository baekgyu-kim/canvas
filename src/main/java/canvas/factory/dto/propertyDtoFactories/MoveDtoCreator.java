package canvas.factory.dto.propertyDtoFactories;

import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.dto.propertyDto.propertyDtos.MovePropertyDto;
import canvas.factory.dto.PropertyDtoCreatorAbstractClass;

public class MoveDtoCreator extends PropertyDtoCreatorAbstractClass {

    public MoveDtoCreator() {
        super();
    }
    @Override
    public void createPropertyDto(int newX, int newY) {
        PropertyDtoAbstractClass movePropertyDto = new MovePropertyDto(newX, newY);
        controller.updateShape(movePropertyDto);
    }
}
