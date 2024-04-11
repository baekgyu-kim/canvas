package canvas.dto;

public class ShapeDto {
    private final int id;
    private final int xPos;
    private final int yPos;
    private final int width;
    private final int height;
    private final String color;
    private final int opacity;
    private final int zOrder;
    private final boolean shadow;
    private final boolean frame;


    public ShapeDto(int id, int xPos, int yPos, int width, int height, String color, int opacity, int zOrder, boolean shadow, boolean frame) {
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

    public String getColor() {
        return color;
    }

    public int getOpacity() {return opacity;}

    public int getZOrder() {return zOrder;}

    public boolean getShadow() {return shadow;}
    public boolean getFrame() {return frame;}
}

