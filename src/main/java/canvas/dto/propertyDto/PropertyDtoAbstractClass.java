package canvas.dto.propertyDto;

import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.composite.ShapeComposite;

import java.awt.*;


public abstract class PropertyDtoAbstractClass implements PropertyDtoInterface {
    ShapeComposite shapeComposite;
    Color color;
    Integer int1;
    Integer int2;
    public PropertyDtoAbstractClass(ShapeComposite shapeComposite) {
        this.shapeComposite = shapeComposite;
    }
    public PropertyDtoAbstractClass(ShapeComposite shapeComposite, Color color) {
        this.shapeComposite = shapeComposite;
        this.color = color;
    }
    public PropertyDtoAbstractClass(ShapeComposite shapeComposite, Integer int1) {
        this.shapeComposite = shapeComposite;
        this.int1 = int1;
    }
    public PropertyDtoAbstractClass(ShapeComposite shapeComposite, Integer int1, Integer int2) {
        this.shapeComposite = shapeComposite;
        this.int1 = int1;
        this.int2 = int2;
    }

    @Override
    public void applyPropertyUpdate(ShapeAbstractClass shapeAbstractClass) {
    }

    @Override
    public void applyPropertyUpdate(ShapeAbstractClass shapeAbstractClass, Color color) {
    }

    @Override
    public void applyPropertyUpdate(ShapeAbstractClass shapeAbstractClass, Integer int1) {
    }

    @Override
    public void applyPropertyUpdate(ShapeAbstractClass shapeAbstractClass, Integer int1, Integer int2) {
    }

}
