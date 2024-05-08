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
        if (shapeComposite.shapesCount() != 1) {
            throw new IllegalStateException("Send Back 버튼은 반드시 하나의 도형에 대해서만 동작할 수 있습니다.");
        // update dto create 로직 구현
    }
}}
