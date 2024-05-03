package canvas.view.preferences.preferenceButton.preferenceButtons;

import canvas.factory.shape.composite.ShapeComposite;
import canvas.view.preferences.preferenceButton.PreferenceButton;


public class HeightButton  extends PreferenceButton {
    private ShapeComposite shapeComposite;
    public HeightButton(ShapeComposite shapeComposite) {
        this.shapeComposite = shapeComposite;
        initializeButton("Height");
    }

    @Override
    public void changePreference() {

    }
}
