package canvas.view.whiteCanvas.decorator;

import canvas.model.shape.ShapeInterface;

import java.awt.*;

public class ClickedShapeDecorator implements ShapeInterface {
    private final ShapeInterface decoratedShape;

    public ClickedShapeDecorator(ShapeInterface decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw(Graphics g) {
        decoratedShape.draw(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.RED);
        g2d.setStroke(new BasicStroke(3));
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
        g2d.drawRect(decoratedShape.getXPos() - 2, decoratedShape.getYPos() - 2,
                decoratedShape.getWidth() + 4, decoratedShape.getHeight() + 4);
        g2d.dispose();
    }

    @Override
    public void changeColor(Color color) {
        throw new UnsupportedOperationException("This operation is not supported by the decorator.");
    }

    @Override
    public void changeMove(int newX, int newY) {
        throw new UnsupportedOperationException("This operation is not supported by the decorator.");
    }

    @Override
    public void changeSize(int newWidth, int newHeight) {
        throw new UnsupportedOperationException("This operation is not supported by the decorator.");
    }

    @Override
    public void changeOpacity(int opacity) {
        throw new UnsupportedOperationException("This operation is not supported by the decorator.");
    }

    @Override
    public void changeShade(boolean hasShade) {
        throw new UnsupportedOperationException("This operation is not supported by the decorator.");
    }

    @Override
    public void changeFrame(boolean hasFrame) {
        throw new UnsupportedOperationException("This operation is not supported by the decorator.");
    }

    @Override
    public int getId() {
        return decoratedShape.getId();
    }

    @Override
    public int getXPos() {
        return decoratedShape.getXPos();
    }

    @Override
    public int getYPos() {
        return decoratedShape.getYPos();
    }

    @Override
    public int getWidth() {
        return decoratedShape.getWidth();
    }

    @Override
    public int getHeight() {
        return decoratedShape.getHeight();
    }

    @Override
    public Color getColor() {
        return decoratedShape.getColor();
    }

    @Override
    public int getOpacity() {
        return decoratedShape.getOpacity();
    }

    @Override
    public boolean getShadow() {
        return decoratedShape.getShadow();
    }

    @Override
    public boolean getFrame() {
        return decoratedShape.getShadow();
    }

    @Override
    public String getText() {
        return decoratedShape.getText();
    }

}
