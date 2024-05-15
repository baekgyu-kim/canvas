package canvas.view.palette.paletteButton.paletteButtons;

import canvas.controller.Controller;
import canvas.state.shapeCreateStates.StarState;
import canvas.view.palette.paletteButton.PaletteButton;


import javax.swing.*;
import java.awt.*;

public class StarButton extends PaletteButton {
    public StarButton(Controller controller) {
        super(controller);
        initializeButton("Star");
        setState();
    }
    @Override
    protected void setState() {
        addActionListener(e -> {
            if (controller.getActiveButton() == this) {
                controller.setDefaultState();
            } else {
                controller.setState(new StarState(controller, seq));
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
