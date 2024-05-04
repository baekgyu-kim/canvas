package canvas.shape;

import java.awt.*;

public interface ShapeInterface {
    void draw(Graphics g);
    void move(int newX, int newY);
    void resize(int newWidth, int newHeight);
}
