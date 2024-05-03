package canvas.factory.shape;

import java.awt.*;

public class StarShape extends ShapeAbstractClass {

    public StarShape(int id, int xPos, int yPos, int width, int height, Color color, int opacity, int zOrder, boolean shadow, boolean frame) {
        super(id, xPos, yPos, width, height, color, opacity, zOrder, shadow, frame);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        // 색상 설정
        g2.setColor(color);

        // 투명도 설정
        float alpha = opacity / 255.0f;
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));

        // 별 모양 생성
        int[] xPoints = new int[10];
        int[] yPoints = new int[10];
        double angle = Math.PI / 5; // 별의 한 코너의 각도

        for (int i = 0; i < 10; i++) {
            int radius = (i % 2 == 0) ? width / 2 : width / 4; // 별의 외부 반지름과 내부 반지름
            xPoints[i] = xPos + width / 2 + (int) (radius * Math.sin(i * angle));
            yPoints[i] = yPos + height / 2 - (int) (radius * Math.cos(i * angle));
        }

        // 별 그리기
        g2.fillPolygon(xPoints, yPoints, 10);

        // 테두리 설정
        if (frame) {
            g2.setColor(Color.BLACK);
            g2.drawPolygon(xPoints, yPoints, 10);
        }
    }
}
