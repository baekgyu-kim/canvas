package canvas.view.preferences.preferenceButton.preferenceButtons;

import canvas.shape.composite.ShapeComposite;
import canvas.view.preferences.preferenceButton.PreferenceButton;

public class BringFrontButton extends PreferenceButton {
    public BringFrontButton(ShapeComposite shapeComposite) {
        super(shapeComposite);
        initializeButton("Bring To Front");
    }

    @Override
    public void changePreference() {

    }
    @Override
    public void createUpdateDto() {
        // updateDto create 로직
        // 만들어진 updateDto를 controller를 통해서 model로 보냄
    }
}
