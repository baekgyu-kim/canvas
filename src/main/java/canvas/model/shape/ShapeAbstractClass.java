package canvas.model.shape;

import java.awt.*;

public class ShapeAbstractClass implements ShapeInterface {
    protected int id;
    protected int xPos;
    protected int yPos;
    protected int width;
    protected int height;
    protected Color color;
    protected int opacity;
    protected boolean shadow;
    protected boolean frame;
    protected String text;

    public ShapeAbstractClass(int id, int xPos, int yPos, int width, int height, Color color, int opacity, boolean shadow, boolean frame) {
        this.id = id;
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        this.color = color;
        this.opacity = opacity;
        this.shadow = shadow;
        this.frame = frame;
    }
    public ShapeAbstractClass(int id, int xPos, int yPos, int width, int height, Color color, int opacity, boolean shadow, boolean frame, String text) {
        this.id = id;
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        this.color = color;
        this.opacity = opacity;
        this.shadow = shadow;
        this.frame = frame;
        this.text = text;
    }

    @Override
    public void draw(Graphics g) {
    }

    @Override
    public void changeColor(Color color) {
        this.color = color;

    }

    @Override
    public void changeMove(int newX, int newY) {
        this.xPos = newX;
        this.yPos = newY;

    }

    @Override
    public void changeSize(int newWidth, int newHeight) {
        this.width = newWidth;
        this.height = newHeight;

    }

    @Override
    public void changeOpacity(int opacity) {
        this.opacity = opacity;
    }

    @Override
    public void changeShade(boolean hasShade) {
        this.shadow = hasShade;

    }

    @Override
    public void changeFrame(boolean hasFrame) {
        this.frame = hasFrame;
    }

    @Override
    public int getId() {
        return id;
    }
    @Override
    public int getXPos() {
        return xPos;
    }
    @Override
    public int getYPos() {
        return yPos;
    }
    @Override
    public int getWidth() {
        return width;
    }
    @Override
    public int getHeight() {
        return height;
    }
    @Override
    public Color getColor() {
        return color;
    }
    @Override
    public int getOpacity() {
        return opacity;
    }
    @Override
    public boolean getShadow() {return shadow;}
    @Override
    public boolean getFrame() {
        return frame;
    }
    @Override
    public String getText() {
        return text;
    }
}
