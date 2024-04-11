package canvas.model.shape;

import java.awt.*;

public abstract class AbstractShape implements ShapeInterface {
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

    // ShapeInterface의 메서드 구현
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

}
