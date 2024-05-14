package canvas.view.whiteCanvas.decorator;

import canvas.model.shape.ShapeAbstractClass;

import java.awt.*;

public class ClickedShapeDecorator extends ShapeAbstractClass {
    private ShapeAbstractClass decoratedShape;

    public ClickedShapeDecorator(ShapeAbstractClass decoratedShape) {
        super(decoratedShape);
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw(Graphics g) {
        decoratedShape.draw(g);
        // 테두리만 있는 직사각형 그리기
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(5));
        g2d.drawRect(decoratedShape.getXPos() - 2, decoratedShape.getYPos() - 2,
                decoratedShape.getWidth() + 4, decoratedShape.getHeight() + 4);
        g2d.dispose();
    }

}
