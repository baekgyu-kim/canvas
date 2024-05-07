package canvas.dto.updateDto;

import canvas.dto.DtoInterface;

import java.awt.*;

public abstract class UpdateDtoAbstractClass implements DtoInterface {
    protected int xPos;
    protected int yPos;
    protected int width;
    protected int height;
    protected Color color;
    protected int opacity;
    protected int zOrder;
    protected boolean shadow;
    protected boolean frame;

    public UpdateDtoAbstractClass(int xPos, int yPos, int width, int height, Color color, int opacity, int zOrder, boolean shadow, boolean frame) {
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

    public int getZOrder() {
        return zOrder;
    }

    public boolean getShadow() {
        return frame;
    }

    public boolean getFrame() {
        return shadow;
    }
}
