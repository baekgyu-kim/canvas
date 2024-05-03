package canvas.view.preferences.preferenceButton.preferenceButtons;

import canvas.factory.shape.ShapeAbstractClass;
import canvas.factory.shape.composite.ShapeComposite;
import canvas.view.preferences.preferenceButton.PreferenceButton;

import javax.swing.*;
import java.util.List;

public class WidthButton  extends PreferenceButton {
    private ShapeComposite shapeComposite;
    public WidthButton(ShapeComposite shapeComposite) {
        this.shapeComposite = shapeComposite;
        initializeButton("Width");
    }

    @Override
    public void changePreference() {

    }

}
