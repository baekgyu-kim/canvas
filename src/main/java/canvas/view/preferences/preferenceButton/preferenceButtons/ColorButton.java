package canvas.view.preferences.preferenceButton.preferenceButtons;

import canvas.shape.composite.ShapeComposite;
import canvas.view.preferences.preferenceButton.PreferenceButton;


public class ColorButton  extends PreferenceButton {
    public ColorButton(ShapeComposite shapeComposite) {
        super(shapeComposite);
        initializeButton("Color");
    }

    @Override
    public void changePreference() {

    }
}
