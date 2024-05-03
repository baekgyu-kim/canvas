package canvas.view.preferences.preferenceButton.preferenceButtons;

import canvas.factory.shape.composite.ShapeComposite;
import canvas.view.preferences.preferenceButton.PreferenceButton;


public class ColorButton  extends PreferenceButton {
    private ShapeComposite shapeComposite;
    public ColorButton(ShapeComposite shapeComposite) {
        this.shapeComposite = shapeComposite;
        initializeButton("Color");
    }

    @Override
    public void changePreference() {

    }
}
