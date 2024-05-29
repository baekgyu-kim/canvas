package canvas.view.palette.paletteButton.clearButton;

import canvas.view.palette.paletteButton.PaletteButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearButton extends PaletteButton {
    public ClearButton() {
        super();
        initializeButton("Clear All");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.clearAllShapes();
            }
        });
    }
}
