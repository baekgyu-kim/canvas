package canvas.model.shape;

import canvas.dto.propertyDto.PropertyDtoAbstractClass;

import java.awt.*;

public interface ShapeInterface {
    void draw(Graphics g);
    void update(PropertyDtoAbstractClass propertyDtoAbstractClass);
}
