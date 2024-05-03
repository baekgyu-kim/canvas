package canvas.view.paletteButton;

import canvas.controller.Controller;
import canvas.factory.ShapeCreatorInterface;

import javax.swing.*;


public abstract class PaletteButton extends JButton implements ShapeCreatorInterface {
    void initializeButton(String text){};
}
