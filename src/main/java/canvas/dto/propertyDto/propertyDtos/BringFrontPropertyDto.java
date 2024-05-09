package canvas.dto.propertyDto.propertyDtos;

import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.model.Model;
import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.composite.ShapeComposite;

import java.awt.*;

public class BringFrontPropertyDto extends PropertyDtoAbstractClass {
    ShapeAbstractClass shape;
    public BringFrontPropertyDto(ShapeComposite shapeComposite) {
        super(shapeComposite);
        if(shapeComposite.shapesCount() == 1){
            this.shape = shapeComposite.getChildren().get(0);
        }
    }
    public ShapeAbstractClass getShape(){
        return shape;
    }
}
