package canvas.view.palette.paletteButton.redoUndoButtons;

import canvas.view.palette.paletteButton.PaletteButton;


public class UndoButton extends PaletteButton {
    public UndoButton() {
        initializeButton("Undo");
        addActionListener(e -> controller.undo());
    }
}
