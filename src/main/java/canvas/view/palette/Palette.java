package canvas.view.palette;

import canvas.view.palette.paletteButton.*;
import canvas.view.palette.paletteButton.clearButton.ClearButton;
import canvas.view.palette.paletteButton.paletteButtons.*;
import canvas.view.palette.paletteButton.redoUndoButtons.RedoButton;
import canvas.view.palette.paletteButton.redoUndoButtons.UndoButton;

import javax.swing.*;
import java.awt.*;

import static canvas.util.ViewUtils.createCategoryPanel;

public class Palette extends JPanel {
    private PaletteButton undoButton;
    private PaletteButton redoButton;
    private PaletteButton rectangleButton;
    private PaletteButton ellipseButton;
    private PaletteButton starButton;
    private PaletteButton textButton;
    private PaletteButton lineButton;
    private PaletteButton clearButton;


    public Palette() {
        initComponents();
        setBackground(new Color(60, 63, 65));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        addComponents();
        setVisible(true);
    }

    private void initComponents() {
        this.undoButton = createStyledButton(new UndoButton(), new Color(237, 28, 36));
        this.redoButton = createStyledButton(new RedoButton(), new Color(237, 28, 36));
        this.rectangleButton = createStyledButton(new RectangleShapeButton());
        this.ellipseButton = createStyledButton(new EllipseShapeButton());
        this.starButton = createStyledButton(new StarShapeButton());
        this.textButton = createStyledButton(new TextShapeButton());
        this.lineButton = createStyledButton(new LineShapeButton());
        this.clearButton = createStyledButton(new ClearButton());
    }

    private PaletteButton createStyledButton(PaletteButton button) {
        return createStyledButton(button, new Color(75, 110, 175));
    }

    private PaletteButton createStyledButton(PaletteButton button, Color backgroundColor) {
        button.setBackground(backgroundColor);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setPreferredSize(new Dimension(150, 40));
        button.setMaximumSize(new Dimension(150, 40));
        return button;
    }

    private void addComponents() {
        add(createCategoryPanel("Undo / Redo", this.undoButton, this.redoButton));
        add(Box.createVerticalStrut(10));
        add(createCategoryPanel("Shape States", this.rectangleButton, this.ellipseButton, this.starButton, this.textButton, this.lineButton));
        add(Box.createVerticalStrut(10));
        add(createCategoryPanel("Clear All", this.clearButton));
        add(Box.createVerticalStrut(10));
    }
}
