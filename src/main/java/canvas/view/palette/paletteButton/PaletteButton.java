package canvas.view.palette.paletteButton;

import canvas.controller.Controller;

import javax.swing.*;


public abstract class PaletteButton extends JButton {
    protected Controller controller;
    public PaletteButton() {
        this.controller = Controller.getInstance();
    }
    public void initializeButton(String text){
        setText(text);
        setVisible(true);
    };
}
