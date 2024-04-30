package canvas.view.paletteButton;

import canvas.controller.Controller;

import javax.swing.*;

public class CursorButton extends JButton implements PaletteButtonInterface{
    Controller controller;
    int seq;
    public CursorButton(Controller controller) {
        this.controller = controller;
        this.seq = -1;
        initializeButton("Cursor");
        addAction(controller, -1);
    }
    @Override
    public void addAction(Controller controller, int seq) {
    }

    @Override
    public void initializeButton(String text) {
        setText(text);
        setVisible(true);
    }
}
