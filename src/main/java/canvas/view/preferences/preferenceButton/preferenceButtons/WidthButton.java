package canvas.view.preferences.preferenceButton.preferenceButtons;

import canvas.shape.composite.ShapeComposite;
import canvas.view.preferences.preferenceButton.PreferenceButton;

public class WidthButton  extends PreferenceButton {
    public WidthButton(ShapeComposite shapeComposite) {
        super(shapeComposite);
        initializeButton("Width");
    }

    @Override
    public void changePreference() {

    }

    @Override
    public void createUpdateDto() {
        // update dto create 로직 구현
    }
}
