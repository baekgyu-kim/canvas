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

    public ShapeAbstractClass(ShapeAbstractClass shapeAbstractClass) {
        this.id = shapeAbstractClass.getId();
        this.xPos = shapeAbstractClass.getXPos();
        this.yPos = shapeAbstractClass.getYPos();
        this.width = shapeAbstractClass.getWidth();
        this.height = shapeAbstractClass.getHeight();
        this.color = shapeAbstractClass.getColor();
        this.opacity = shapeAbstractClass.getOpacity();
        this.shadow = shapeAbstractClass.getShadow();
        this.frame = shapeAbstractClass.getFrame();
        this.text = shapeAbstractClass.getText();
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


    public int getId() {
        return id;
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
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

    public boolean getShadow() {return shadow;}

    public boolean getFrame() {
        return frame;
    }

    public String getText() {
        return text;
    }
}
