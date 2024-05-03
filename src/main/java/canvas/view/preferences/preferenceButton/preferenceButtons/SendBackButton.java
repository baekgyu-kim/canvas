package canvas.view.preferences.preferenceButton.preferenceButtons;

import canvas.factory.shape.composite.ShapeComposite;
import canvas.view.preferences.preferenceButton.PreferenceButton;


public class SendBackButton  extends PreferenceButton {
    private ShapeComposite shapeComposite;

    public SendBackButton(ShapeComposite shapeComposite) {
        this.shapeComposite = shapeComposite;
        initializeButton("Send Back");
    }
    @Override
    public void changePreference() {

    }
}
