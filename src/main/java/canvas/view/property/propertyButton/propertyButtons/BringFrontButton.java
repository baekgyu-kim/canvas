package canvas.view.property.propertyButton.propertyButtons;

import canvas.controller.Controller;
import canvas.model.shape.composite.ShapeComposite;
import canvas.view.property.propertyButton.PropertyButton;

public class BringFrontButton extends PropertyButton {
    public BringFrontButton(ShapeComposite shapeComposite, Controller controller) {
        super(shapeComposite, controller);
        initializeButton("Bring To Front");
    }

    public void createPropertyDto() {
        // updateDto create 로직
        // 만들어진 updateDto를 controller를 통해서 model로 보냄
    }
}
