package canvas.view.palette.paletteButton.redoUndoButtons;

import canvas.view.palette.paletteButton.PaletteButton;


public class RedoButton extends PaletteButton {
    public RedoButton() {
        initializeButton("Redo");
        addActionListener(e -> controller.redo());
    }
}
