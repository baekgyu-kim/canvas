package canvas.view.property.propertyButton.propertyButtons;

import canvas.controller.Controller;
import canvas.controller.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.controller.dto.propertyDto.propertyDtos.ShadePropertyDto;
import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.composite.ShapeComposite;
import canvas.view.property.propertyButton.PropertyButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ShadowButton extends PropertyButton {
    private Boolean hasShadow = null;

    public ShadowButton(ShapeComposite shapeComposite, Controller controller) {
        super(shapeComposite, controller);
        initializeButton("Change Shadow");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(null, "Would you like to add a shadow?", "Shadow", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    hasShadow = true;
                } else if (response == JOptionPane.NO_OPTION) {
                    hasShadow = false;
                }
                createPropertyDto(hasShadow);
            }
        });
    }

    public void createPropertyDto(Boolean newShadow) {
        if (shapeComposite == null) {
            JOptionPane.showMessageDialog(null, "속성값을 바꿀 도형이 선택되어있지 않습니다.");
            return;
        }
        PropertyDtoAbstractClass shadeDto = new ShadePropertyDto(shapeComposite, newShadow);
        controller.updateShape(shapeComposite, shadeDto);
    }

    @Override
    public void updateClickedShapes(ShapeComposite shapeComposite) {
        this.shapeComposite = shapeComposite;
        if (shapeComposite == null) {
            throw new NullPointerException("shapeComposite is null");
        }
        if (shapeComposite.shapesCount() == 1) {
            this.hasShadow = shapeComposite.getChildren().get(0).getShadow();
        }
    }

    @Override
    public void updateAllShapes(List<ShapeAbstractClass> shapes) {
        if (shapeComposite != null && shapeComposite.shapesCount() == 1) {
            this.hasShadow = shapeComposite.getChildren().get(0).getShadow();
        }
    }
}
