package canvas.model.shape.shapes;

import canvas.model.shape.ShapeAbstractClass;

import java.awt.*;

public class RectangleShape extends ShapeAbstractClass {

    public RectangleShape(int id, int xPos, int yPos, int width, int height, Color color, int opacity, boolean shadow, boolean frame) {
        super(id, xPos, yPos, width, height, color, opacity, shadow, frame);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if (shadow) {
            int shadowOffset = 5;
            g2.setColor(new Color(0, 0, 0, 100));
            float shadowAlpha = 0.9f; // 그림자 투명도 설정
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, shadowAlpha));
            g2.fillRect(xPos + shadowOffset, yPos + shadowOffset, width, height);
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
        }
        g2.setColor(color);

        float alpha = opacity / 100.0f;
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));

        g2.fillRect(xPos, yPos, width, height);


        if (frame) {
            g2.setColor(Color.BLACK);
            g2.setStroke(new BasicStroke(2));
            g2.drawRect(xPos, yPos, width, height);
        }
    }

}
