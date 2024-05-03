package canvas.view.palette.paletteButton;

import canvas.factory.ShapeCreatorInterface;

import javax.swing.*;


public abstract class PaletteButton extends JButton implements ShapeCreatorInterface {

    public abstract void initializeButton(String text);
}
