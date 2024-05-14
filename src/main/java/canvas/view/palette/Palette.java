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
        JButton btn = (JButton) button;
        btn.setBackground(new Color(75, 110, 175));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Arial", Font.BOLD, 14));
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.setPreferredSize(new Dimension(150, 40));
        btn.setMaximumSize(new Dimension(150, 40));
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

    public void setActiveButton(PaletteButton button) {
        if (this.activeButton != null) {
            this.activeButton.deactivate();
        }
        this.activeButton = button;
        this.activeButton.activate();
    }

    public PaletteButton getActiveButton() {
        return this.activeButton;
    }
}
