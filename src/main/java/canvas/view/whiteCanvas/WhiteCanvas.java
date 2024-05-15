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
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;

public class WhiteCanvas extends JPanel implements Observer {
    private Controller controller;
    private ArrayList<ShapeAbstractClass> allShapes = new ArrayList<>();
    private List<ShapeAbstractClass> clickedShapes = new ArrayList<>();
    private Point hoverPoint = null;

    public WhiteCanvas(Controller controller) {
        this.controller = controller;
        setBackground(new Color(245, 245, 245));
        setPreferredSize(new Dimension(800, 600));
        setVisible(true);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                controller.handleMouseClick(e, allShapes);
                repaint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                hoverPoint = e.getPoint();
                repaint();
            }
        });
    }

    @Override
    public void updateAllShapes(List<ShapeAbstractClass> shapes) {
        this.allShapes = (ArrayList<ShapeAbstractClass>) shapes;
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
        drawGrid(g);
        for (ShapeAbstractClass shape : this.allShapes) {
            if (this.clickedShapes.contains(shape)) {
                ClickedShapeDecorator decorator = new ClickedShapeDecorator(shape);
                decorator.draw(g);
            } else {
                shape.draw(g);
            }
        }
        drawHoverFeedback(g);
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

    private void drawHoverFeedback(Graphics g) {
        if (hoverPoint != null) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(new Color(0, 0, 0));
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
            g2d.fillOval(hoverPoint.x - 5, hoverPoint.y - 5, 20, 20);
        }
    }
}
