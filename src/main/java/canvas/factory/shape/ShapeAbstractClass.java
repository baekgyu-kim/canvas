package canvas.factory.shape;

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

    @Override
    public void draw() { };

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
