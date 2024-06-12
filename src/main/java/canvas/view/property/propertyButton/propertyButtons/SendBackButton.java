package canvas.view.property.propertyButton.propertyButtons;

import canvas.factory.dto.propertyDtoFactories.SendBackDtoCreator;
import canvas.view.property.propertyButton.PropertyButton;

import javax.swing.*;

public class SendBackButton extends PropertyButton {
    public SendBackButton() {
        super();
        this.propertyDtoCreatorInterface = new SendBackDtoCreator();
        initializeButton("Send Back");

        addActionListener(e -> createPropertyDto());
    }

    private void createPropertyDto() {
        if (clickedShapes == null) {
            JOptionPane.showMessageDialog(null, "속성값을 바꿀 도형이 선택되어있지 않습니다.");
            return;
        } else if (clickedShapes.size() != 1) {
            JOptionPane.showMessageDialog(null, "Send Back 동작은 1개의 도형에 대해서만 동작할 수 있습니다.");
            return;
        }
        propertyDtoCreatorInterface.createPropertyDto();
    }

}
