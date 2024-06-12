package canvas.dto.propertyDto.propertyDtos;

import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.model.shape.ShapeAbstractClass;

public class FramePropertyDto extends PropertyDtoAbstractClass {
    public FramePropertyDto(Boolean hasFrame) {
        super(hasFrame);
    }
    @Override
    public void applyPropertyUpdate(ShapeAbstractClass shapeAbstractClass) {
        shapeAbstractClass.changeFrame(this.boolValue);
    }
}


