package canvas.view.palette.paletteButton.paletteButtons;

import canvas.controller.Controller;
import canvas.model.shape.shapes.StarShape;
import canvas.state.shapeCreateStates.StarState;
import canvas.view.palette.paletteButton.PaletteButton;


import java.awt.*;

public class StarButton extends PaletteButton {
    public StarButton(Controller controller, int seq) {
        super(controller, seq);
        initializeButton("Star");
        setState();
    }

    @Override
    protected void setState() {
        addActionListener(e -> controller.setState(new StarState(controller, seq)));
    }
}
