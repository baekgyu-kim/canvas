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

        // 색상 설정
        g2.setColor(color);

        // 두께 설정
        g2.setStroke(new BasicStroke(5));

        // 투명도 설정
        float alpha = opacity / 100.0f;
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));

        // 선 그리기
        g2.drawLine(xPos, yPos, xPos + width, yPos + height);
    }

}
