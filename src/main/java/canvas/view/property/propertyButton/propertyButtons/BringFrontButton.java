package canvas.view.property.propertyButton.propertyButtons;

import canvas.factory.dto.propertyDtoFactories.BringFrontDtoCreator;
import canvas.view.property.propertyButton.PropertyButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BringFrontButton extends PropertyButton {
    public BringFrontButton() {
        super();
        this.propertyDtoCreatorInterface = new BringFrontDtoCreator();
        initializeButton("Bring Front");

        addActionListener(e -> createPropertyDto());
    }

    private void createPropertyDto() {
        if (shapeComposite == null) {
            JOptionPane.showMessageDialog(null, "속성값을 바꿀 도형이 선택되어있지 않습니다.");
            return;
        } else if (shapeComposite.shapesCount() != 1) {
            JOptionPane.showMessageDialog(null, "Bring Front 동작은 1개의 도형에 대해서만 동작할 수 있습니다.");
            return;
        }
        propertyDtoCreatorInterface.createPropertyDto();
    }

    @Override
    public void onUpdateClickedShapes() {
        this.shapeComposite = controller.getClickedShapesComposite();
    }

}
