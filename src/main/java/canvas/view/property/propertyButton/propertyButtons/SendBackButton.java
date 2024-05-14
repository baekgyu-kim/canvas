package canvas.view.property.propertyButton.propertyButtons;

import canvas.controller.Controller;
import canvas.controller.dto.propertyDto.propertyDtos.ZOrderPropertyDto;
import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.composite.ShapeComposite;
import canvas.view.property.propertyButton.PropertyButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SendBackButton extends PropertyButton {
    public SendBackButton(ShapeComposite shapeComposite, Controller controller) {
        super(shapeComposite, controller);
        initializeButton("Send Back");

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
            JOptionPane.showMessageDialog(null, "Send Back 동작은 1개의 도형에 대해서만 동작할 수 있습니다.");
            return;
        }

        ZOrderPropertyDto dto = new ZOrderPropertyDto(shapeComposite);
        controller.sendBack(dto);
    }
    @Override
    public void updateClickedShapes(ShapeComposite shapeComposite) {
        this.shapeComposite = shapeComposite;
    }

    @Override
    public void updateAllShapes(List<ShapeAbstractClass> shapes) {

    }
}
