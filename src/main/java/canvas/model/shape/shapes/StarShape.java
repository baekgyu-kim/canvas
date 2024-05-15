package canvas.model.shape.shapes;

import canvas.model.shape.ShapeAbstractClass;

import java.awt.*;
import java.awt.geom.Path2D;

public class StarShape extends ShapeAbstractClass {

    public StarShape(int id, int xPos, int yPos, int width, int height, Color color, int opacity, boolean shadow, boolean frame) {
        super(id, xPos, yPos, width, height, color, opacity, shadow, frame);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        if (shadow) {
            int shadowOffset = 5;
            g2.setColor(new Color(0, 0, 0, 100));
            float shadowAlpha = 0.9f;
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, shadowAlpha));
            Path2D shadowStar = createStarPath(xPos + shadowOffset, yPos + shadowOffset, width, height);
            g2.fill(shadowStar);
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
        }

        g2.setColor(color);

        float alpha = opacity / 100.0f;
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));

        Path2D star = createStarPath(xPos, yPos, width, height);
        g2.fill(star);

        if (frame) {
            g2.setColor(Color.BLACK);
            g2.setStroke(new BasicStroke(2));
            g2.draw(star);
        }
    }

    private Path2D createStarPath(int xPos, int yPos, int width, int height) {
        Path2D star = new Path2D.Double();

        double[] xPoints = {0.5, 0.613, 1, 0.687, 0.793, 0.5, 0.207, 0.313, 0, 0.387};
        double[] yPoints = {0, 0.38, 0.38, 0.617, 1, 0.762, 1, 0.617, 0.38, 0.38};

        for (int i = 0; i < xPoints.length; i++) {
            double px = xPos + width * xPoints[i];
            double py = yPos + height * yPoints[i];
            if (i == 0) {
                star.moveTo(px, py);
            } else {
                star.lineTo(px, py);
            }
        }
        star.closePath();
        return star;
    }
}
