package canvas.view.palette.paletteButton;

import canvas.controller.Controller;

import javax.swing.*;


public abstract class PaletteButton extends JButton {
    protected Controller controller;
    public PaletteButton(Controller controller) {
        this.controller = controller;
    }
    public void initializeButton(String text){
        setText(text);
        setVisible(true);
    };
}
