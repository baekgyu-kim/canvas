package canvas.view.preferences.preferenceButton.preferenceButtons;

import canvas.factory.shape.composite.ShapeComposite;
import canvas.view.preferences.preferenceButton.PreferenceButton;

public class BringFrontButton extends PreferenceButton {
    private ShapeComposite shapeComposite;

    public BringFrontButton(ShapeComposite shapeComposite) {
        this.shapeComposite = shapeComposite;
        initializeButton("Bring To Front");
    }

    @Override
    public void changePreference() {

    }
}
