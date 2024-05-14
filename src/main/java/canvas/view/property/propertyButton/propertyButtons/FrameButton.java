package canvas.view.property.propertyButton.propertyButtons;

import canvas.controller.Controller;
import canvas.controller.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.controller.dto.propertyDto.propertyDtos.FramePropertyDto;
import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.composite.ShapeComposite;
import canvas.view.property.propertyButton.PropertyButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FrameButton extends PropertyButton {
    private Boolean hasFrame = null;

    public FrameButton(ShapeComposite shapeComposite, Controller controller) {
        super(shapeComposite, controller);
        initializeButton("Change Frame");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(null, "Would you like to add a frame?", "Frame", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    hasFrame = true;
                } else if (response == JOptionPane.NO_OPTION) {
                    hasFrame = false;
                }
                createPropertyDto(hasFrame);
            }
        });
    }

    public void createPropertyDto(Boolean newFrame) {
        if (shapeComposite == null) {
            JOptionPane.showMessageDialog(null, "속성값을 바꿀 도형이 선택되어있지 않습니다.");
            return;
        }
        PropertyDtoAbstractClass frameDto = new FramePropertyDto(shapeComposite, newFrame);
        controller.updateShape(shapeComposite, frameDto);
    }

    @Override
    public void updateClickedShapes(ShapeComposite shapeComposite) {
        this.shapeComposite = shapeComposite;
        if (shapeComposite == null) {
            throw new NullPointerException("shapeComposite is null");
        }
        if (shapeComposite.shapesCount() == 1) {
            this.hasFrame = shapeComposite.getChildren().get(0).getFrame();
        }
    }

    @Override
    public void updateAllShapes(List<ShapeAbstractClass> shapes) {
        if (shapeComposite != null && shapeComposite.shapesCount() == 1) {
            this.hasFrame = shapeComposite.getChildren().get(0).getFrame();
        }
    }
}
