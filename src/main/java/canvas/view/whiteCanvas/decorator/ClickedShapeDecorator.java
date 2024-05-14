package canvas.view.whiteCanvas.decorator;
import canvas.model.shape.ShapeAbstractClass;

import javax.swing.*;
import java.awt.*;

public class ClickedShapeDecorator extends JPanel {

    ShapeAbstractClass shape;

    public ClickedShapeDecorator(ShapeAbstractClass shape) {
        this.shape = shape;
        setOpaque(false); // 배경을 투명하게 설정
        setLocation(shape.getXPos()-2, shape.getYPos()-2);
        setSize(shape.getWidth()+4, shape.getHeight()+4);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // 클릭된 도형의 그리기 로직 호출
        // 검은색 테두리 그리기
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(5)); // 테두리 두께 설정
        g2d.drawRect(0, 0, getWidth(), getHeight()); // 테두리 그리기
        g2d.dispose();
        shape.draw(g);
    }
}
