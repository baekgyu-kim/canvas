package canvas.shape.shapes;

import canvas.shape.ShapeAbstractClass;

import java.awt.*;

public class CircleShape extends ShapeAbstractClass {

    public CircleShape(int id, int xPos, int yPos, int width, int height, Color color, int opacity, int zOrder, boolean shadow, boolean frame) {
        super(id, xPos, yPos, width, height, color, opacity, zOrder, shadow, frame);
    }

    public void draw(Graphics g) {
        // Graphics 객체를 Graphics2D 객체로 캐스팅
        Graphics2D g2d = (Graphics2D) g;

        // 도형의 색상 설정
        g2d.setColor(color);
        // 투명도 설정
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity / 255.0f));

        // 원을 그림, xPos와 yPos는 원을 둘러싸는 직사각형의 좌상단 좌표
        g2d.fillOval(xPos, yPos, width, height);

        if (frame) {
            // 테두리가 있다면 테두리 색상을 검은색으로 설정
            g2d.setColor(Color.BLACK);
            // 원의 테두리 그리기
            g2d.drawOval(xPos, yPos, width, height);
        }
    }
}
