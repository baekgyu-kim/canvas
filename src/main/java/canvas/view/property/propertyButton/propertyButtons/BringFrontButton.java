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
        if (shapeComposite.shapesCount() != 1) {
            throw new IllegalStateException("Bring to Front 버튼은 반드시 하나의 도형에 대해서만 동작할 수 있습니다.");
        }
    }
}
