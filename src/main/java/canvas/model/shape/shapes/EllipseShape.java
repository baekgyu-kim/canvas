package canvas.model.shape.shapes;

import canvas.model.shape.ShapeAbstractClass;

import java.awt.*;

public class EllipseShape extends ShapeAbstractClass {

    public EllipseShape(int id, int xPos, int yPos, int width, int height, Color color, int opacity, boolean shadow, boolean frame) {
        super(id, xPos, yPos, width, height, color, opacity, shadow, frame);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        // 색상 설정
        g2.setColor(color);

        // 투명도 설정
        float alpha = opacity / 100.0f;
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));

        // 타원 그리기
        g2.fillOval(xPos, yPos, width, height);

        // 테두리 설정
        if (frame) {
            g2.setColor(Color.BLACK);
            g2.drawOval(xPos, yPos, width, height);
        }
    }
}
