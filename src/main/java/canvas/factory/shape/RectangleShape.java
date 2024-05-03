package canvas.factory.shape;

import java.awt.*;

public class RectangleShape extends ShapeAbstractClass {

    public RectangleShape(int id, int xPos, int yPos, int width, int height, Color color, int opacity, int zOrder, boolean shadow, boolean frame) {
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

        // 사각형 그리기
        g2.fillRect(xPos, yPos, width, height);

        // 테두리 설정
        if (frame) {
            g2.setColor(Color.BLACK);
            g2.drawRect(xPos, yPos, width, height);
        }
    }

}
