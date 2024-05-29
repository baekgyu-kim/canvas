package canvas.dto.propertyDto.propertyDtos;

import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.model.shape.ShapeAbstractClass;

import java.util.List;


public class FramePropertyDto extends PropertyDtoAbstractClass {
    public FramePropertyDto(List<ShapeAbstractClass> clickedShapes, Boolean hasFrame) {
        super(clickedShapes, hasFrame);
    }
    @Override
    public void applyPropertyUpdate(ShapeAbstractClass shapeAbstractClass) {
        shapeAbstractClass.changeFrame(this.boolValue);
    }
}


