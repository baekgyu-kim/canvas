package canvas.view.palette.paletteButton.paletteButtons;

import canvas.controller.Controller;
import canvas.model.shape.shapes.RectangleShape;
import canvas.state.shapeCreateStates.EllipseState;
import canvas.state.shapeCreateStates.RectangleState;
import canvas.view.palette.paletteButton.PaletteButton;


import javax.swing.*;
import java.awt.*;

public class RectangleButton extends PaletteButton {
    public RectangleButton(Controller controller, int seq) {
        super(controller, seq);
        initializeButton("Rectangle");
        setState();
    }
    @Override
    protected void setState() {
        addActionListener(e -> {
            if (controller.getActiveButton() == this) {
                controller.setDefaultState();
            } else {
                controller.setState(new RectangleState(controller, seq));
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
