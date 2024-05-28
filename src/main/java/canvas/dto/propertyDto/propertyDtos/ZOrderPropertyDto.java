package canvas.dto.propertyDto.propertyDtos;

import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.composite.ShapeComposite;

public class ZOrderPropertyDto extends PropertyDtoAbstractClass {
    ShapeAbstractClass shape;
    public ZOrderPropertyDto(ShapeComposite shapeComposite) {
        super(shapeComposite);
        if(shapeComposite.shapesCount() == 1){
            this.shape = shapeComposite.getChildren().get(0);
        }
    }
    public ShapeAbstractClass getShape(){
        return shape;
    }
}
