package canvas.view.palette.paletteButton;

import canvas.controller.Controller;
import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.composite.ShapeComposite;
import canvas.observer.Observer;

import javax.swing.*;
import java.util.List;


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
