package canvas.view.palette.paletteButton;

import canvas.controller.Controller;
import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.composite.ShapeComposite;
import canvas.observer.Observer;

import javax.swing.*;
import java.util.List;


public abstract class PaletteButton extends JButton implements Observer {
    protected Controller controller;
    protected int seq = 0;
    public PaletteButton(Controller controller) {
        this.controller = controller;
    }

    public void initializeButton(String text){
        setText(text);
        setVisible(true);
    };

    @Override
    public void updateAllShapes(List<ShapeAbstractClass> shapes) {
        this.seq = shapes.size();
    }

    @Override
    public void updateClickedShapes(ShapeComposite shapeComposite) {}

    protected abstract void setState();

    public abstract void activate();

    public abstract void deactivate();
}
