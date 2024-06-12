package canvas.dto.propertyDto.propertyDtos;

import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.model.Model;
import canvas.model.shape.ShapeAbstractClass;

import java.util.List;

public class BringFrontPropertyDto extends PropertyDtoAbstractClass {
    Model model;
    public BringFrontPropertyDto() {
        super();
        this.model = Model.getInstance();
    }
    @Override
    public void applyPropertyUpdate(ShapeAbstractClass shapeAbstractClass) {
        List<ShapeAbstractClass> allShapes= model.getAllShapes();
        if (allShapes.remove(shapeAbstractClass)) {
            allShapes.add(shapeAbstractClass);
        }
    }
}
