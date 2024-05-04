package canvas.view.preferences.preferenceButton.preferenceButtons;

import canvas.model.shape.composite.ShapeComposite;
import canvas.view.preferences.preferenceButton.PreferenceButton;


public class SendBackButton  extends PreferenceButton {
    public SendBackButton(ShapeComposite shapeComposite) {
        super(shapeComposite);
        initializeButton("Send Back");
    }
    @Override
    public void changePreference() {

    }
    @Override
    public void createUpdateDto() {
        // update dto create 로직 구현
    }
}
