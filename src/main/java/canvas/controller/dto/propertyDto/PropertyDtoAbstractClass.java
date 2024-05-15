package canvas.controller.dto.propertyDto;

import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.composite.ShapeComposite;

import java.awt.*;


public abstract class PropertyDtoAbstractClass implements PropertyDtoInterface {
    protected ShapeComposite shapeComposite;
    protected Color color;
    protected Integer value1;
    protected Integer value2;
    protected Boolean boolValue;
    public PropertyDtoAbstractClass(ShapeComposite shapeComposite) {
        this.shapeComposite = shapeComposite;
    }
    public PropertyDtoAbstractClass(ShapeComposite shapeComposite, Color color) {
        this.shapeComposite = shapeComposite;
        this.color = color;
    }
    public PropertyDtoAbstractClass(ShapeComposite shapeComposite, Integer value1) {
        this.shapeComposite = shapeComposite;
        this.value1 = value1;
    }
    public PropertyDtoAbstractClass(ShapeComposite shapeComposite, Integer value1, Integer value2) {
        this.shapeComposite = shapeComposite;
        this.value1 = value1;
        this.value2 = value2;
    }
    public PropertyDtoAbstractClass(ShapeComposite shapeComposite, Boolean boolValue) {
        this.shapeComposite = shapeComposite;
        this.boolValue = boolValue;
    }

    @Override
    public void applyPropertyUpdate(ShapeAbstractClass shapeAbstractClass) {}

}
