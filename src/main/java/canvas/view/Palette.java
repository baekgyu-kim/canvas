package canvas.view;

import canvas.controller.Controller;
import canvas.model.observer.Observer;
import canvas.model.shape.Shape;
import canvas.view.palette.Cursor;
import canvas.view.palette.Line;
import canvas.view.palette.Rectangle;
import canvas.view.palette.Ellipse;
import canvas.view.palette.Star;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Palette extends JPanel implements Observer {
    private Controller controller;
    private int seq;
    private Cursor cursor;
    private Line line;
    private Rectangle rectangle;
    private Ellipse ellipse;
    private Star star;

    public Palette(Controller controller, int seq) {
        this.controller = controller;
        this.seq = seq;
        initComponents();
        setBackground(Color.blue);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        addComponents();
        setVisible(true);
    }

    private void initComponents() {
        this.cursor = new Cursor(this.controller);
        this.line = new Line(this.controller, this.seq);
        this.rectangle = new Rectangle(this.controller, this.seq);
        this.ellipse = new Ellipse(this.controller, this.seq);
        this.star = new Star(this.controller, this.seq);
    }

    private void addComponents() {
        add(this.cursor);
        add(this.line);
        add(this.rectangle);
        add(this.ellipse);
        add(this.star);
    }

    @Override
    public void update(List<canvas.model.shape.Shape> shapes) {
        this.seq = shapes.size();
        initComponents();
        removeAll();
        addComponents();
        revalidate();
        repaint();
    }
}
