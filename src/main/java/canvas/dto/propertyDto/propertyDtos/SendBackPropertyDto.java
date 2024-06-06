package canvas.dto.propertyDto.propertyDtos;

import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.model.Model;
import canvas.model.shape.ShapeAbstractClass;

import java.util.List;

public class SendBackPropertyDto extends PropertyDtoAbstractClass {
    Model model;
    public SendBackPropertyDto(List<ShapeAbstractClass> clickedShapes) {
        super(clickedShapes);
        this.model = Model.getInstance();
    }
    @Override
    public void applyPropertyUpdate(ShapeAbstractClass shapeAbstractClass) {
        List<ShapeAbstractClass> allShapes= model.getAllShapes();
        if (allShapes.remove(shapeAbstractClass)) {
            allShapes.add(0, shapeAbstractClass);
        }
    }
}