package canvas.view.WhiteCanvas;

import canvas.controller.Controller;
import canvas.shape.ShapeAbstractClass;
import canvas.shape.composite.ShapeComposite;
import canvas.observer.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class WhiteCanvas extends JPanel implements Observer {
    Controller controller;
    List<ShapeAbstractClass> allShapes = new ArrayList<>();

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
        if (allShapes.isEmpty()) {
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

        for (ShapeAbstractClass shape : allShapes) {
            if (isPointInsideShape(x, y, shape) && shape.getzOrder() > maxZOrder) {
                maxZOrder = shape.getzOrder();
                selectedIndex = allShapes.indexOf(shape);
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
                shape.draw(g);
            }
        }
    }
}
