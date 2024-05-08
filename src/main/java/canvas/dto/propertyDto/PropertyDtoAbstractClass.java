package canvas.dto.propertyDto;

import canvas.dto.DtoInterface;
import canvas.model.shape.ShapeAbstractClass;

import java.awt.*;


public abstract class PropertyDtoAbstractClass implements DtoInterface {
    protected Integer xPos;
    protected Integer yPos;
    protected Integer width;
    protected Integer height;
    protected Color color;
    protected Integer opacity;
    protected Integer zOrder;
    public PropertyDtoAbstractClass() {
        this.xPos = null;
        this.yPos = null;
        this.width = null;
        this.height = null;
        this.color = null;
        this.opacity = null;
        this.zOrder = null;
    }

    public Integer getXPos() {return this.xPos;}
    public Integer getYPos() {return this.yPos;}
    public Integer getWidth() {return this.width;}
    public Integer getHeight() {return this.height;}
    public Color getColor() {return this.color;}
    public Integer getOpacity() {return this.opacity;}
    public Integer getZOrder() {return this.zOrder;}
}
