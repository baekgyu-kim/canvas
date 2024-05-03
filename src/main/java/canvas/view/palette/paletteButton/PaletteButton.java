package canvas.view.palette.paletteButton;

import canvas.factory.ShapeCreatorInterface;

import javax.swing.*;


public abstract class PaletteButton extends JButton implements ShapeCreatorInterface {
    void initializeButton(String text){};
}
