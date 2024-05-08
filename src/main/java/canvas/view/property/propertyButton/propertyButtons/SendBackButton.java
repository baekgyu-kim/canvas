package canvas.view.property.propertyButton.propertyButtons;

import canvas.model.shape.composite.ShapeComposite;
import canvas.view.property.propertyButton.PropertyButton;


public class SendBackButton  extends PropertyButton {
    public SendBackButton(ShapeComposite shapeComposite) {
        super(shapeComposite);
        initializeButton("Send Back");
    }
    @Override
    public void changeProperty() {

    }
    @Override
    public void createPropertyDto() {
        // update dto create 로직 구현
    }
}
