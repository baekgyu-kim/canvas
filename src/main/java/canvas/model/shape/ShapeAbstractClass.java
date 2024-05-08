package canvas.model.shape;

import canvas.dto.propertyDto.PropertyDtoAbstractClass;

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
    public void draw(Graphics g) {
    }

    @Override
    public void update(PropertyDtoAbstractClass propertyDtoAbstractClass) {
        if (propertyDtoAbstractClass == null) {
            throw new IllegalArgumentException("PropertyDtoAbstractClass cannot be null");
        }
        if (propertyDtoAbstractClass.getXPos() != null) {
            this.xPos = propertyDtoAbstractClass.getXPos();
        }
        if (propertyDtoAbstractClass.getYPos() != null) {
            this.yPos = propertyDtoAbstractClass.getYPos();
        }
        if (propertyDtoAbstractClass.getWidth() != null) {
            this.width = propertyDtoAbstractClass.getWidth();
        }
        if (propertyDtoAbstractClass.getHeight() != null) {
            this.height = propertyDtoAbstractClass.getHeight();
        }
        if (propertyDtoAbstractClass.getColor() != null) {
            this.color = propertyDtoAbstractClass.getColor();
        }
        if (propertyDtoAbstractClass.getOpacity() != null) {
            this.opacity = propertyDtoAbstractClass.getOpacity();
        }
        if (propertyDtoAbstractClass.getZOrder() != null) {
            this.zOrder = propertyDtoAbstractClass.getZOrder();
        }
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

    public int getZOrder() {return zOrder;}

    public boolean getShadow() {return shadow;}

    public boolean getFrame() {
        return frame;
    }
}
