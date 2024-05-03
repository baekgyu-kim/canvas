package canvas.view.preferences.preferenceButton.preferenceButtons;

import canvas.factory.shape.composite.ShapeComposite;
import canvas.view.preferences.preferenceButton.PreferenceButton;


public class HeightButton  extends PreferenceButton {
    public HeightButton(ShapeComposite shapeComposite) {
        super(shapeComposite);
        initializeButton("Height");
    }

    @Override
    public void changePreference() {

    }
}
