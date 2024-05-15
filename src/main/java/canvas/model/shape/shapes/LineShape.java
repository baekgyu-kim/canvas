package canvas.model.shape.shapes;

import canvas.model.shape.ShapeAbstractClass;

import java.awt.*;

public class LineShape extends ShapeAbstractClass {

    public LineShape(int id, int xPos, int yPos, int width, int height, Color color, int opacity, boolean shadow, boolean frame) {
        super(id, xPos, yPos, width, height, color, opacity, shadow, frame);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if (shadow) {
            int shadowOffset = 5;
            g2.setColor(new Color(0, 0, 0, 100));
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.9f));
            g2.drawLine(xPos + shadowOffset, yPos + shadowOffset, xPos + width + shadowOffset, yPos + height + shadowOffset);
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
        }

        g2.setColor(color);

        g2.setStroke(new BasicStroke(5));

        float alpha = opacity / 100.0f;
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));

        g2.drawLine(xPos, yPos, xPos + width, yPos + height);


        if (frame) {
            g2.setColor(Color.BLACK);
            g2.setStroke(new BasicStroke(2));
            g2.drawRect(xPos, yPos, width, height);
        }
    }

}
