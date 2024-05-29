package canvas.dto.propertyDto.propertyDtos;

import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.model.shape.ShapeAbstractClass;

import java.awt.*;
import java.util.List;

public class ColorPropertyDto extends PropertyDtoAbstractClass {
    public ColorPropertyDto(List<ShapeAbstractClass> clickedShapes, Color color) {
        super(clickedShapes, color);
    }

    @Override
    public void applyPropertyUpdate(ShapeAbstractClass shapeAbstractClass) {
        shapeAbstractClass.changeColor(this.color);
    }
}
