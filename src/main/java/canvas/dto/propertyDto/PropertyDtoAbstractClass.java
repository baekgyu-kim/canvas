package canvas.dto.propertyDto;

import java.awt.*;

public abstract class PropertyDtoAbstractClass implements PropertyDtoInterface {
    protected Color color;
    protected Integer value1;
    protected Integer value2;
    protected Boolean boolValue;
    public PropertyDtoAbstractClass() {}
    public PropertyDtoAbstractClass(Color color) {
        this.color = color;
    }
    public PropertyDtoAbstractClass(Integer value1) {
        this.value1 = value1;
    }
    public PropertyDtoAbstractClass(Integer value1, Integer value2) {
        this.value1 = value1;
        this.value2 = value2;
    }
    public PropertyDtoAbstractClass(Boolean boolValue) {
        this.boolValue = boolValue;
    }
}
