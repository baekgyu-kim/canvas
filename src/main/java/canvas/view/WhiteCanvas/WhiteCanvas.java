package canvas.view.WhiteCanvas;

import canvas.controller.Controller;
import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.composite.ShapeComposite;
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

        // 여기에 controller 메소드 호출해서 모델의 clickedShapes 수정하는 로직 처리
        // clickedShapes에 해당 도형 없으면 추가하고, 이미 있으면 삭제하고
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
        repaint();
    }

    @Override
    public void updateClickedShapes(ShapeComposite shapeComposite) {
        // Model의 clickedShapes가 수정된 경우 수정된 clickedShapes가 인자로 들어오는 메소드
        // 수정된 clickedShapes 사용해서 처리해야 하는 로직 있으면 여기에다 구현
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
