package canvas.view.palette.paletteButton;

import canvas.controller.Controller;
import canvas.model.shape.composite.ShapeComposite;
import canvas.observer.Observer;



public abstract class PaletteShapeButton extends PaletteButton implements Observer {
    protected int seq = 0;
    public PaletteShapeButton(Controller controller) {super(controller);}

    @Override
    public void onUpdateAllShapes() {
        this.seq = controller.getAllShapes().size();
    }
    @Override
    public void onUpdateClickedShapes() {}

    protected abstract void setState();
    public abstract void activate();
    public abstract void deactivate();

}
