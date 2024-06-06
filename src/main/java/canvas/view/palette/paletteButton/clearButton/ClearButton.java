package canvas.view.palette.paletteButton.clearButton;

import canvas.view.palette.paletteButton.PaletteButton;


public class ClearButton extends PaletteButton {
    public ClearButton() {
        super();
        initializeButton("Clear All");
        addActionListener(e -> controller.clearAllShapes());
    }
}
