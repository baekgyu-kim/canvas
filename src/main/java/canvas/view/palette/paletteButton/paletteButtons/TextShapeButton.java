package canvas.view.palette.paletteButton.paletteButtons;

import canvas.state.shapeCreateStates.TextShapeCreateState;
import canvas.view.palette.paletteButton.PaletteShapeButton;

import javax.swing.*;
import java.awt.*;


public class TextShapeButton extends PaletteShapeButton {
    public TextShapeButton() {
        super();
        initializeButton("Text Box");
        setState();
    }
    @Override
    protected void setState() {
        addActionListener(e -> {
            if (controller.getActiveButton() == this) {
                controller.setClickState();
            } else {
                controller.setState(new TextShapeCreateState());
                controller.setActiveButton(this);
            }
        });
    }
    @Override
    public void activate() {
        setBackground(new Color(100, 150, 200));
        setBorder(BorderFactory.createLineBorder(Color.RED, 3));
    }

    @Override
    public void deactivate() {
        setBackground(new Color(75, 110, 175));
        setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
    }
}