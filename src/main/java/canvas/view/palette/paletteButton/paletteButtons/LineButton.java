package canvas.view.palette.paletteButton.paletteButtons;

import canvas.controller.Controller;
import canvas.model.shape.shapes.LineShape;
import canvas.state.shapeCreateStates.LineState;
import canvas.view.palette.paletteButton.PaletteButton;


import java.awt.*;

public class LineButton extends PaletteButton {
    public LineButton(Controller controller, int seq) {
        super(controller, seq);
        initializeButton("Line");
        setState();
    }

    @Override
    protected void setState() {
        addActionListener(e -> controller.setState(new LineState(controller, seq)));
    }
}
