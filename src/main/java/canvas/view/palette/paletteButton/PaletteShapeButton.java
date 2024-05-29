package canvas.view.palette.paletteButton;

import canvas.controller.Controller;
import canvas.model.shape.composite.ShapeComposite;
import canvas.observer.Observer;



public abstract class PaletteShapeButton extends PaletteButton {
    public PaletteShapeButton() {
        super();
    }

    protected abstract void setState();
    public abstract void activate();
    public abstract void deactivate();

}
