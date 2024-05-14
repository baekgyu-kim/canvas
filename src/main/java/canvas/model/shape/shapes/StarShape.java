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

        // 색상 설정
        g2.setColor(color);

        // 투명도 설정
        float alpha = opacity / 255.0f;
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));

        Path2D star = new Path2D.Double();

        // 각 꼭짓점의 좌표 계산
        double[] xPoints = {0.5, 0.613, 1, 0.687, 0.793, 0.5, 0.207, 0.313, 0, 0.387};
        double[] yPoints = {0, 0.38, 0.38, 0.617, 1, 0.762, 1, 0.617, 0.38, 0.38};

        // 실제 좌표로 변환하여 Path2D에 추가
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
        g2.fill(star);

        // 테두리 설정
        if (frame) {
            g2.setColor(Color.BLACK);
            g2.draw(star);
        }
    }
}
