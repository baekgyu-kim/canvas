package canvas.dto.propertyDto;

import canvas.dto.DtoInterface;
import canvas.model.shape.ShapeAbstractClass;

import java.awt.*;


public abstract class PropertyDtoAbstractClass implements DtoInterface {
    protected int xPos;
    protected int yPos;
    protected int width;
    protected int height;
    protected Color color;
    protected int zOrder;
    public PropertyDtoAbstractClass(ShapeAbstractClass shapeAbstractClass) {
        this.xPos = shapeAbstractClass.getXPos();
        this.yPos = shapeAbstractClass.getYPos();
        this.width = shapeAbstractClass.getWidth();
        this.height = shapeAbstractClass.getHeight();
        this.color = shapeAbstractClass.getColor();
        this.zOrder = shapeAbstractClass.getZOrder();
    }
    public int getXPos() {return this.xPos;}
    public int getYPos() {return this.yPos;}
    public int getWidth() {return this.width;}
    public int getHeight() {return this.height;}
    public Color getColor() {return this.color;}
    public int getZOrder() {return this.zOrder;}
}
