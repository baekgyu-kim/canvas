package canvas.view.palette.paletteButton;

import canvas.controller.Controller;
import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.composite.ShapeComposite;
import canvas.observer.Observer;

import javax.swing.*;
import java.util.List;


public abstract class PaletteShapeButton extends PaletteButton implements Observer {
    protected int seq = 0;
    public PaletteShapeButton(Controller controller) {
        super(controller);
    }
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
