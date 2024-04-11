package canvas.model.shape;

import canvas.enums.ShapeType;

import java.awt.*;

public class Shape extends AbstractShape {
    public Shape(int id, ShapeType shapeType, int xPos, int yPos, int width, int height, Color color, int opacity, int zOrder, boolean shadow, boolean frame) {
        this.id = id;
        this.shapeType = shapeType;
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

}