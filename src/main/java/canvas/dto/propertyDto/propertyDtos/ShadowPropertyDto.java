package canvas.dto.propertyDto.propertyDtos;

import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.model.shape.ShapeAbstractClass;

import java.util.List;

public class ShadowPropertyDto extends  PropertyDtoAbstractClass {
    public ShadowPropertyDto(List<ShapeAbstractClass> clickedShapes, Boolean hasShadow) {
        super(clickedShapes, hasShadow);
    }
    @Override
    public void applyPropertyUpdate(ShapeAbstractClass shapeAbstractClass) {
        shapeAbstractClass.changeShade(this.boolValue);
    }
}


