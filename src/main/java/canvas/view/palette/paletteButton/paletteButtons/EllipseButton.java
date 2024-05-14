package canvas.view.palette.paletteButton.paletteButtons;

import canvas.controller.Controller;
import canvas.state.shapeCreateStates.EllipseState;
import canvas.view.palette.paletteButton.PaletteButton;

public class EllipseButton extends PaletteButton {

    public EllipseButton(Controller controller, int seq) {
        super(controller, seq);
        initializeButton("Ellipse");
        setState();
    }

    @Override
    protected void setState() {
        addActionListener(e -> controller.setState(new EllipseState(controller, seq)));
    }
}
