package canvas.view.palette.paletteButton;

public abstract class PaletteShapeButton extends PaletteButton {
    public PaletteShapeButton() {
        super();
    }

    protected abstract void setState();
    public abstract void activate();
    public abstract void deactivate();

}
