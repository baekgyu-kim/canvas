package canvas.model.shape;

import canvas.dto.updateDto.UpdateDtoAbstractClass;

import java.awt.*;

public interface ShapeInterface {
    void draw(Graphics g);
    void update(UpdateDtoAbstractClass updateDtoAbstractClass);
}
