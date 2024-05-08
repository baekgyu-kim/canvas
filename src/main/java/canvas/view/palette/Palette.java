package canvas.view.palette;

import canvas.controller.Controller;
import canvas.view.palette.paletteButton.*;
import canvas.view.palette.paletteButton.paletteButtons.*;

import javax.swing.*;
import java.awt.*;

public class Palette extends JPanel {
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
        registerButtonsAsObserver();
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

    private void registerButtonsAsObserver(){
        controller.registerObserver(this.lineButton);
        controller.registerObserver(this.rectangleButton);
        controller.registerObserver(this.ellipseButton);
        controller.registerObserver(this.starButton);
    }

    private void addComponents() {
        add((Component) this.lineButton);
        add((Component) this.rectangleButton);
        add((Component) this.ellipseButton);
        add((Component) this.starButton);
    }
}
