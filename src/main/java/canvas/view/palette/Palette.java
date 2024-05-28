package canvas.view.palette;

import canvas.controller.Controller;
import canvas.observer.Observer;
import canvas.view.palette.paletteButton.*;
import canvas.view.palette.paletteButton.clearButton.ClearButton;
import canvas.view.palette.paletteButton.paletteButtons.*;

import javax.swing.*;
import java.awt.*;

public class Palette extends JPanel {
    private final Controller controller;
    private PaletteButton lineButton;
    private PaletteButton rectangleButton;
    private PaletteButton ellipseButton;
    private PaletteButton starButton;
    private PaletteButton textButton;
    private PaletteButton clearButton;

    public Palette() {
        this.controller = Controller.getInstance();
        initComponents();
        registerButtonsAsObserver();
        setBackground(new Color(60, 63, 65));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        addComponents();
        setVisible(true);
    }

    private void initComponents() {
        this.lineButton = createStyledButton(new LineShapeButton());
        this.rectangleButton = createStyledButton(new RectangleShapeButton());
        this.ellipseButton = createStyledButton(new EllipseShapeButton());
        this.starButton = createStyledButton(new StarShapeButton());
        this.textButton = createStyledButton(new TextShapeButton());
        this.clearButton = createStyledButton(new ClearButton());
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
        controller.registerObserver((Observer) this.lineButton);
        controller.registerObserver((Observer) this.rectangleButton);
        controller.registerObserver((Observer) this.ellipseButton);
        controller.registerObserver((Observer) this.starButton);
        controller.registerObserver((Observer) this.textButton);
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
        add(Box.createVerticalStrut(30));
        add((Component) this.clearButton);
        add(Box.createVerticalStrut(10));
    }
}
