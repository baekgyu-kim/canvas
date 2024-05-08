package canvas.view.property.propertyButton.propertyButtons;

import canvas.model.shape.composite.ShapeComposite;
import canvas.view.property.propertyButton.PropertyButton;


public class ColorButton  extends PropertyButton {
    public ColorButton(ShapeComposite shapeComposite) {
        super(shapeComposite);
        initializeButton("Color");
    }

    @Override
    public void changeProperty() {

    }
    @Override
    public void createUpdateDto() {
        // update dto create 로직 구현
    }
}
