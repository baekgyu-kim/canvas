package canvas.view.property.propertyButton.propertyButtons;

import canvas.model.shape.composite.ShapeComposite;
import canvas.view.property.propertyButton.PropertyButton;


public class MoveButton  extends PropertyButton {
    public MoveButton(ShapeComposite shapeComposite) {
        super(shapeComposite);
        initializeButton("Move");
    }

    @Override
    public void changeProperty() {

    }
    @Override
    public void createUpdateDto() {
        // update dto create 로직 구현
    }
}
