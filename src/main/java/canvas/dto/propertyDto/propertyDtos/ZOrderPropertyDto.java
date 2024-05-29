package canvas.dto.propertyDto.propertyDtos;

import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.model.shape.ShapeAbstractClass;

import java.util.List;

public class ZOrderPropertyDto extends PropertyDtoAbstractClass {
    ShapeAbstractClass shape;
    public ZOrderPropertyDto(List<ShapeAbstractClass> clickedShapes) {
        super(clickedShapes);
        if(clickedShapes.size() == 1){
            this.shape = clickedShapes.get(0);
        }
    }
    public ShapeAbstractClass getShape(){
        return shape;
    }
}
