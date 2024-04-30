package canvas.view;

import canvas.controller.Controller;
import canvas.model.observer.Observer;
import canvas.view.paletteButton.CursorButton;
import canvas.view.paletteButton.LineButton;
import canvas.view.paletteButton.RectangleButton;
import canvas.view.paletteButton.EllipseButton;
import canvas.view.paletteButton.StarButton;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Palette extends JPanel implements Observer {
    private Controller controller;
    private int seq;
    private CursorButton cursorButton;
    private LineButton lineButton;
    private RectangleButton rectangleButton;
    private EllipseButton ellipseButton;
    private StarButton starButton;

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
        this.cursorButton = new CursorButton(this.controller);
        this.lineButton = new LineButton(this.controller, this.seq);
        this.rectangleButton = new RectangleButton(this.controller, this.seq);
        this.ellipseButton = new EllipseButton(this.controller, this.seq);
        this.starButton = new StarButton(this.controller, this.seq);
    }

    private void addComponents() {
        add(this.cursorButton);
        add(this.lineButton);
        add(this.rectangleButton);
        add(this.ellipseButton);
        add(this.starButton);
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
