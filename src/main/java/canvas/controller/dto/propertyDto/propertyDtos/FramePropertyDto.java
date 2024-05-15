package canvas.controller.dto.propertyDto.propertyDtos;

import canvas.controller.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.composite.ShapeComposite;


public class FramePropertyDto extends PropertyDtoAbstractClass {
    public FramePropertyDto(ShapeComposite shapeComposite, Boolean hasFrame) {
        super(shapeComposite, hasFrame);
    }
    @Override
    public void applyPropertyUpdate(ShapeAbstractClass shapeAbstractClass) {
        shapeAbstractClass.changeFrame(this.boolValue);
    }
}


