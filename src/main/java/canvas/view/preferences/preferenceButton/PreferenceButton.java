package canvas.view.preferences.preferenceButton;

import canvas.factory.UpdateDtoCreatorInterface;
import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.composite.ShapeComposite;
import canvas.observer.Observer;

import javax.swing.*;
import java.util.List;

public abstract class PreferenceButton extends JButton implements Observer, UpdateDtoCreatorInterface {
    ShapeComposite shapeComposite;

    public PreferenceButton(ShapeComposite shapeComposite) {
        this.shapeComposite = shapeComposite;
    }

    public void initializeButton(String text){
        setText(text);
        setVisible(true);
    };

    public abstract void changePreference();

    @Override
    public void updateAllShapes(List<ShapeAbstractClass> shapes) {
        // 여기서는 아무것도 하지 않음.
    }

    @Override
    public void updateClickedShapes(ShapeComposite shapeComposite) {
        this.shapeComposite = shapeComposite;
    }

}
