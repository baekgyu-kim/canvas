package canvas.view.palette.paletteButton.paletteButtons;

import canvas.state.shapeCreateStates.RectangleShapeCreateState;
import canvas.view.palette.paletteButton.PaletteShapeButton;


import javax.swing.*;
import java.awt.*;

public class RectangleShapeButton extends PaletteShapeButton {
    public RectangleShapeButton() {
        super();
        initializeButton("Rectangle");
        setState();
    }
    @Override
    protected void setState() {
        addActionListener(e -> {
            if (controller.getActiveButton() == this) {
                controller.setClickState();
            } else {
                controller.setState(new RectangleShapeCreateState());
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
