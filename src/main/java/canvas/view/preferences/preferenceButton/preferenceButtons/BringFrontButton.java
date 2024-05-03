package canvas.view.preferences.preferenceButton.preferenceButtons;

import canvas.factory.shape.composite.ShapeComposite;
import canvas.view.preferences.preferenceButton.PreferenceButton;

public class BringFrontButton extends PreferenceButton {
    public BringFrontButton(ShapeComposite shapeComposite) {
        super(shapeComposite);
        initializeButton("Bring To Front");
    }

    @Override
    public void changePreference() {

    }
}
