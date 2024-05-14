package canvas.view.whiteCanvas;

import canvas.controller.Controller;
import canvas.view.whiteCanvas.decorator.ClickedShapeDecorator;
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
    private Point lastClick = null;

    public WhiteCanvas(Controller controller) {
        this.controller = controller;
        setBackground(new Color(245, 245, 245)); // 배경색을 밝은 회색으로 설정
        setPreferredSize(new Dimension(800, 600));
        setVisible(true);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleMouseClick(e.getX(), e.getY());
                lastClick = e.getPoint();
                repaint();
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
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGrid(g); // 그리드 배경 그리기
        for (ShapeAbstractClass shape : this.allShapes) {
            if (this.clickedShapes.contains(shape)) {
                ClickedShapeDecorator decorator = new ClickedShapeDecorator(shape);
                decorator.draw(g);
            } else {
                shape.draw(g);
            }
        }
        drawClickFeedback(g);
    }

    private void drawGrid(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(220, 220, 220));
        g2d.setStroke(new BasicStroke(0.5f));

        int gridSize = 20;

        for (int i = 0; i < getWidth(); i += gridSize) {
            g2d.drawLine(i, 0, i, getHeight());
        }

        for (int j = 0; j < getHeight(); j += gridSize) {
            g2d.drawLine(0, j, getWidth(), j);
        }
    }

    private void drawClickFeedback(Graphics g) {
        if (lastClick != null) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(new Color(0, 150, 136));
            g2d.fillOval(lastClick.x - 5, lastClick.y - 5, 10, 10);
        }
    }
}
