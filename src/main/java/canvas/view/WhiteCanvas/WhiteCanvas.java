package canvas.view.WhiteCanvas;

import canvas.controller.Controller;
import canvas.factory.shape.ShapeAbstractClass;
import canvas.factory.shape.composite.ShapeComposite;
import canvas.observer.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class WhiteCanvas extends JPanel implements Observer {
    Controller controller;
    List<ShapeAbstractClass> allShapes;

    public WhiteCanvas(Controller controller) {
        this.controller = controller;
        setBackground(Color.white);
        setPreferredSize(new Dimension(800, 600));
        setVisible(true);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleMouseClick(e.getX(), e.getY());
            }
        });
    }

    private void handleMouseClick(int x, int y) {
        if (allShapes == null || allShapes.isEmpty()) {
            System.out.println("No shapes to interact with.");
            return;
        }
        int clickedShapeIndex = findShapeByPoint(x, y);
        if (clickedShapeIndex != -1) {
            ShapeAbstractClass clickedShape = allShapes.get(clickedShapeIndex);
            System.out.println("Clicked on Shape with ID: " + clickedShape.getId() + " at Z-Order: " + clickedShape.getzOrder());
        } else {
            System.out.println("Clicked on empty space.");
        }
    }

    private int findShapeByPoint(int x, int y) {
        int selectedIndex = -1;
        int maxZOrder = Integer.MIN_VALUE;

        for (int i = 0; i < allShapes.size(); i++) {
            ShapeAbstractClass shape = allShapes.get(i);
            if (isPointInsideShape(x, y, shape)) {
                if (shape.getzOrder() > maxZOrder) {
                    maxZOrder = shape.getzOrder();
                    selectedIndex = i;
                }
            }
        }

        return selectedIndex;
    }

    private boolean isPointInsideShape(int x, int y, ShapeAbstractClass shape) {
        return x >= shape.getxPos() && x <= (shape.getxPos() + shape.getWidth()) &&
                y >= shape.getyPos() && y <= (shape.getyPos() + shape.getHeight());
    }

    @Override
    public void updateAllShapes(List<ShapeAbstractClass> shapes) {
        this.allShapes = shapes;
        for (ShapeAbstractClass shape : shapes) {
            System.out.printf("id: %s, Z_Order: %s%n", shape.getId(), shape.getzOrder());
            shape.draw();
        }
        repaint();  // 도형 목록이 업데이트 될 때마다 캔버스를 다시 그립니다.
    }

    @Override
    public void updateClickedShapes(ShapeComposite shapeComposite) {
        // 특정 도형이 클릭되었을 때 업데이트하는 로직을 여기에 추가할 수 있습니다.
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (allShapes != null) {
            for (ShapeAbstractClass shape : allShapes) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(shape.getColor());
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, shape.getOpacity() / 255.0f));
                g2.fillRect(shape.getxPos(), shape.getyPos(), shape.getWidth(), shape.getHeight());
                if (shape.isFrame()) {
                    g2.setColor(Color.BLACK);
                    g2.drawRect(shape.getxPos(), shape.getyPos(), shape.getWidth(), shape.getHeight());
                }
            }
        }
    }
}
