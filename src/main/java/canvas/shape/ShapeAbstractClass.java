package canvas.shape;

import java.awt.*;

public class ShapeAbstractClass implements ShapeInterface {
    protected int id;
    protected int xPos;
    protected int yPos;
    protected int width;
    protected int height;
    protected Color color;
    protected int opacity;
    protected int zOrder;
    protected boolean shadow;
    protected boolean frame;

    public ShapeAbstractClass(int id, int xPos, int yPos, int width, int height, Color color, int opacity, int zOrder, boolean shadow, boolean frame) {
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
    public void draw(Graphics g) { };

    @Override
    public void move(int newX, int newY) {
        this.xPos = newX;
        this.yPos = newY;
    }

    @Override
    public void resize(int newWidth, int newHeight) {
        this.width = newWidth;
        this.height = newHeight;
    }
    public int getId() {
        return id;
    }


    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }

    public int getOpacity() {
        return opacity;
    }

    public int getzOrder() {
        return zOrder;
    }

    public boolean isShadow() {
        return shadow;
    }

    public boolean isFrame() {
        return frame;
    }
}
