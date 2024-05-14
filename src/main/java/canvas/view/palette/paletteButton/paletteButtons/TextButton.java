package canvas.view.palette.paletteButton.paletteButtons;

import canvas.controller.Controller;
import canvas.state.shapeCreateStates.LineState;
import canvas.state.shapeCreateStates.TextState;
import canvas.view.palette.paletteButton.PaletteButton;


public class TextButton extends PaletteButton{

    public TextButton(Controller controller, int seq) {
        super(controller, seq);
        initializeButton("Text Box");
        setState();
    }

    @Override
    protected void setState() {
        addActionListener(e -> controller.setState(new TextState(controller, seq)));
    }
}