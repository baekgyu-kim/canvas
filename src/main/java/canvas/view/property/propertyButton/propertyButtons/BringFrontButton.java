package canvas.view.property.propertyButton.propertyButtons;

import canvas.dto.propertyDto.propertyDtos.ZOrderPropertyDto;
import canvas.view.property.propertyButton.PropertyButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BringFrontButton extends PropertyButton {
    public BringFrontButton() {
        super();
        initializeButton("Bring Front");

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createPropertyDto();
            }
        });
    }

    public void createPropertyDto() {
        if (shapeComposite == null) {
            JOptionPane.showMessageDialog(null, "속성값을 바꿀 도형이 선택되어있지 않습니다.");
            return;
        } else if (shapeComposite.shapesCount() != 1) {
            JOptionPane.showMessageDialog(null, "Bring Front 동작은 1개의 도형에 대해서만 동작할 수 있습니다.");
            return;
        }

        ZOrderPropertyDto dto = new ZOrderPropertyDto(shapeComposite);
        controller.bringFront(dto);
    }

    @Override
    public void onUpdateClickedShapes() {
        this.shapeComposite = controller.getClickedShapesComposite();
    }

}
