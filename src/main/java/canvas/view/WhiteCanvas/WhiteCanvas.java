package canvas.view.whiteCanvas;

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
        // 클릭한 커서의 위치에 도형이 존재한다면
        if (clickedShapeIndex != -1) {
            ShapeAbstractClass clickedShape = allShapes.get(clickedShapeIndex);
            controller.toggleShapeClick(clickedShape.getId());
//            System.out.println("Clicked on Shape with ID: " + clickedShape.getId() + " at Z-Order: " + clickedShape.getzOrder());
        } else { // 아니라면
            controller.clearClicks();
//            System.out.println("Clicked on empty space.");
        }

        // 여기에 controller 메소드 호출해서 모델의 clickedShapes 수정하는 로직 처리
        // clickedShapes에 해당 도형 없으면 추가하고, 이미 있으면 삭제하고
    }

    private int findShapeByPoint(int x, int y) {
        int selectedIndex = -1;
        int maxZOrder = Integer.MIN_VALUE;

        for (ShapeAbstractClass shape : allShapes) {
            if (isPointInsideShape(x, y, shape) && shape.getZOrder() > maxZOrder) {
                maxZOrder = shape.getZOrder();
                selectedIndex = allShapes.indexOf(shape);
            }
        }

        return selectedIndex;
    }

    private boolean isPointInsideShape(int x, int y, ShapeAbstractClass shape) {
        return x >= shape.getXPos() && x <= (shape.getXPos() + shape.getWidth()) &&
                y >= shape.getYPos() && y <= (shape.getYPos() + shape.getHeight());
    }

    @Override
    public void updateAllShapes(List<ShapeAbstractClass> shapes) {
        this.allShapes = shapes;
        repaint();
    }

    @Override
    public void updateClickedShapes(ShapeComposite shapeComposite) {
//        List<ShapeAbstractClass> children = shapeComposite.getChildren();
//        System.out.println("Clicked shapes IDs:");
//        for (ShapeAbstractClass shape : children) {
//            System.out.println("Shape ID: " + shape.getId());
//        }
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
