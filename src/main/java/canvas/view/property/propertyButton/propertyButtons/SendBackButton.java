package canvas.view.property.propertyButton.propertyButtons;

import canvas.controller.Controller;
import canvas.model.shape.composite.ShapeComposite;
import canvas.view.property.propertyButton.PropertyButton;


public class SendBackButton  extends PropertyButton {
    public SendBackButton(ShapeComposite shapeComposite, Controller controller) {
        super(shapeComposite, controller);
        initializeButton("Send Back");
    }
    public void createPropertyDto() {
        // update dto create 로직 구현
    }
}
