package canvas.view.palette.paletteButton.paletteButtons;

import canvas.state.shapeCreateStates.EllipseShapeCreateState;
import canvas.view.palette.paletteButton.PaletteShapeButton;

import javax.swing.*;
import java.awt.*;

public class EllipseShapeButton extends PaletteShapeButton {

    public EllipseShapeButton() {
        super();
        initializeButton("Ellipse");
        setState();
    }

    @Override
    protected void setState() {
        addActionListener(e -> {
            if (controller.getActiveButton() == this) {
                controller.setClickState();
            } else {
                controller.setState(new EllipseShapeCreateState());
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
