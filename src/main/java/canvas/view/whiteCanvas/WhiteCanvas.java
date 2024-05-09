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
    List<ShapeAbstractClass> clickedShapes = new ArrayList<>();


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
            controller.toggleShapeClick(clickedShape.getId());
        } else {
            controller.clearClicks();
        }
    }

    private int findShapeByPoint(int x, int y) {
        for (int i = allShapes.size() - 1; i >= 0; i--) {
            ShapeAbstractClass shape = allShapes.get(i);
            if (isPointInsideShape(x, y, shape)) {
                return i;
            }
        }
        return -1;
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
        this.clickedShapes = shapeComposite.getChildren();
        System.out.println("Clicked shapes IDs:");
        for (ShapeAbstractClass shape : this.clickedShapes) {
            System.out.println("Shape ID: " + shape.getId());
            //주석
        }
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
