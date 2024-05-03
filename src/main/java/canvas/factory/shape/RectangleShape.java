package canvas.factory.shape;

import java.awt.*;

public class RectangleShape extends ShapeAbstractClass {

    public RectangleShape(int id, int xPos, int yPos, int width, int height, Color color, int opacity, int zOrder, boolean shadow, boolean frame) {
        this.id = id;
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        this.color = color;
        this.opacity = opacity;
        this.zOrder = zOrder;
        this.shadow = shadow;
        this.frame = frame;
    }

    @Override
    public void draw() {
        System.out.println("Drawing an rectangle");
    }
}
