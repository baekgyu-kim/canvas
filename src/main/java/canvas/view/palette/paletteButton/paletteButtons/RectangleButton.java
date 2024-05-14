package canvas.view.palette.paletteButton.paletteButtons;

import canvas.controller.Controller;
import canvas.model.shape.shapes.RectangleShape;
import canvas.state.shapeCreateStates.RectangleState;
import canvas.view.palette.paletteButton.PaletteButton;


import java.awt.*;

public class RectangleButton extends PaletteButton {
    public RectangleButton(Controller controller, int seq) {
        super(controller, seq);
        initializeButton("Rectangle");
        setState();
    }

    @Override
    protected void setState() {
        addActionListener(e -> controller.setState(new RectangleState(controller, seq)));
    }
}
