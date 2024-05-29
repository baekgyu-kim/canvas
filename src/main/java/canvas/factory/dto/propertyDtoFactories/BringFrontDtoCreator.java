package canvas.factory.dto.propertyDtoFactories;

import canvas.dto.propertyDto.propertyDtos.ZOrderPropertyDto;
import canvas.factory.dto.PropertyDtoCreatorAbstractClass;

public class BringFrontDtoCreator extends PropertyDtoCreatorAbstractClass {
    public BringFrontDtoCreator() {
        super();
    }
    @Override
    public void createPropertyDto() {
        ZOrderPropertyDto zOrderPropertyDto = new ZOrderPropertyDto(shapeComposite);
        controller.bringFront(zOrderPropertyDto);
    }
}
