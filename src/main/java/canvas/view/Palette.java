package canvas.view;

import canvas.controller.Controller;
import canvas.factory.shape.ShapeAbstractClass;
import canvas.observer.Observer;
import canvas.view.paletteButton.PaletteButton;
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
    private PaletteButton lineButton;
    private PaletteButton rectangleButton;
    private PaletteButton ellipseButton;
    private PaletteButton starButton;

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
        this.lineButton = new LineButton(this.controller, this.seq);
        this.rectangleButton = new RectangleButton(this.controller, this.seq);
        this.ellipseButton = new EllipseButton(this.controller, this.seq);
        this.starButton = new StarButton(this.controller, this.seq);
    }

    private void addComponents() {
        add((Component) this.lineButton);
        add((Component) this.rectangleButton);
        add((Component) this.ellipseButton);
        add((Component) this.starButton);
    }

    @Override
    public void update(List<ShapeAbstractClass> shapes) {
        this.seq = shapes.size();
        initComponents();
        removeAll();
        addComponents();
        revalidate();
        repaint();
    }
}
