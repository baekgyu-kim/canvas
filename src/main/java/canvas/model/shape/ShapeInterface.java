package canvas.model.shape;

import canvas.dto.propertyDto.PropertyDtoAbstractClass;

import java.awt.*;

public interface ShapeInterface {
    void draw(Graphics g);
    void changeColor(Color color);
    void changeMove(int newX, int newY);
    void changeSize(int newWidth, int newHeight);
    void changeOpacity(int opacity);
    void bringFront();
    void sendBack();

}
