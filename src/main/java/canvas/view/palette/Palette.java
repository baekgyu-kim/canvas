package canvas.view.palette;

import canvas.controller.Controller;
import canvas.view.palette.paletteButton.*;
import canvas.view.palette.paletteButton.paletteButtons.*;

import javax.swing.*;
import java.awt.*;

public class Palette extends JPanel {
    private int seq;
    private final Controller controller;
    private PaletteButton lineButton;
    private PaletteButton rectangleButton;
    private PaletteButton ellipseButton;
    private PaletteButton starButton;
    private PaletteButton textButton;
    private PaletteButton activeButton;

    public Palette(Controller controller, int seq) {
        this.controller = controller;
        this.seq = seq;
        this.activeButton = null;
        initComponents();
        registerButtonsAsObserver();
        setBackground(new Color(60, 63, 65));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        addComponents();
        setVisible(true);
    }

    private void initComponents() {
        this.lineButton = createStyledButton(new LineButton(this.controller, this.seq));
        this.rectangleButton = createStyledButton(new RectangleButton(this.controller, this.seq));
        this.ellipseButton = createStyledButton(new EllipseButton(this.controller, this.seq));
        this.starButton = createStyledButton(new StarButton(this.controller, this.seq));
        this.textButton = createStyledButton(new TextButton(this.controller, this.seq));
    }

    private PaletteButton createStyledButton(PaletteButton button) {
        ((JButton) button).setBackground(new Color(75, 110, 175));
        ((JButton) button).setForeground(Color.WHITE);
        ((JButton) button).setFont(new Font("Arial", Font.BOLD, 14));
        ((JButton) button).setFocusPainted(false);
        ((JButton) button).setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        ((JButton) button).setAlignmentX(Component.CENTER_ALIGNMENT);
        ((JButton) button).setPreferredSize(new Dimension(150, 40));
        ((JButton) button).setMaximumSize(new Dimension(150, 40));
        return button;
    }

    private void registerButtonsAsObserver() {
        controller.registerObserver(this.lineButton);
        controller.registerObserver(this.rectangleButton);
        controller.registerObserver(this.ellipseButton);
        controller.registerObserver(this.starButton);
        controller.registerObserver(this.textButton);
    }

    private void addComponents() {
        add(Box.createVerticalStrut(10));
        add((Component) this.lineButton);
        add(Box.createVerticalStrut(5));
        add((Component) this.rectangleButton);
        add(Box.createVerticalStrut(5));
        add((Component) this.ellipseButton);
        add(Box.createVerticalStrut(5));
        add((Component) this.starButton);
        add(Box.createVerticalStrut(5));
        add((Component) this.textButton);
        add(Box.createVerticalStrut(10));
    }
}
