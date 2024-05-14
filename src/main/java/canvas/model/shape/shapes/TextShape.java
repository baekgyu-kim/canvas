package canvas.model.shape.shapes;

import canvas.model.shape.ShapeAbstractClass;

import java.awt.*;

public class TextShape extends ShapeAbstractClass {
    private String text;

    public TextShape(int id, int xPos, int yPos, int width, int height, Color color, int opacity, boolean shadow, boolean frame, String text) {
        super(id, xPos, yPos, width, height, color, opacity, shadow, frame);
        this.text = text;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        // 텍스트 크기 동적 조정
        Font font = findOptimalFont(g2, text, width, height);
        g2.setFont(font);

        FontMetrics metrics = g2.getFontMetrics(font);
        int x = xPos + (width - metrics.stringWidth(text)) / 2;
        int y = yPos + ((height - metrics.getHeight()) / 2) + metrics.getAscent();

        // 프레임 그리기
        if (frame) {
            g2.setColor(Color.BLACK);
            g2.setStroke(new BasicStroke(2));
            g2.drawRect(xPos, yPos, width, height);
        }

        // 그림자 설정
        if (shadow) {
            int shadowOffset = 6;
            g2.setColor(new Color(0, 0, 0, 100)); // 반투명한 검정색으로 그림자 설정
            float shadowAlpha = 0.9f; // 그림자 투명도 설정
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, shadowAlpha));
            g2.drawString(text, x + shadowOffset, y + shadowOffset);
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f)); // 원래 투명도로 복원
        }
        float alpha = opacity / 100.0f;
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        g2.setColor(color);
        g2.drawString(text, x, y);

        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
    }

    private Font findOptimalFont(Graphics2D g2, String text, int maxWidth, int maxHeight) {
        int size = 1;
        Font font = g2.getFont().deriveFont((float) size);
        FontMetrics metrics = g2.getFontMetrics(font);

        while (metrics.stringWidth(text) < maxWidth && metrics.getHeight() < maxHeight) {
            size++;
            font = g2.getFont().deriveFont((float) size);
            metrics = g2.getFontMetrics(font);
        }

        return g2.getFont().deriveFont((float) (size - 1));
    }
}
