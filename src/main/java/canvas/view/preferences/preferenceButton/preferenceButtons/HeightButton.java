package canvas.view.preferences.preferenceButton.preferenceButtons;

import canvas.model.shape.composite.ShapeComposite;
import canvas.view.preferences.preferenceButton.PreferenceButton;


public class HeightButton  extends PreferenceButton {
    public HeightButton(ShapeComposite shapeComposite) {
        super(shapeComposite);
        initializeButton("Height");
    }

    @Override
    public void changePreference() {

    }
    @Override
    public void createUpdateDto() {
        // update dto create 로직 구현
    }
}
