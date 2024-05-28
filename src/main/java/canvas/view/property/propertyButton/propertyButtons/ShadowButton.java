package canvas.view.property.propertyButton.propertyButtons;

import canvas.controller.Controller;
import canvas.controller.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.controller.dto.propertyDto.propertyDtos.ShadowPropertyDto;
import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.composite.ShapeComposite;
import canvas.view.property.propertyButton.PropertyButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ShadowButton extends PropertyButton {
    private Boolean hasShadow = null;
    private JRadioButton activateShadowButton;
    private JRadioButton deactivateShadowButton;

    public ShadowButton(ShapeComposite shapeComposite, Controller controller) {
        super(shapeComposite, controller);
        initializeButton("Shadow Effect");

        activateShadowButton = new JRadioButton("Activate shadow effect");
        deactivateShadowButton = new JRadioButton("Deactivate shadow effect");

        ButtonGroup group = new ButtonGroup();
        group.add(activateShadowButton);
        group.add(deactivateShadowButton);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                panel.add(activateShadowButton);
                panel.add(deactivateShadowButton);

                setRadioButtonState();

                int result = JOptionPane.showConfirmDialog(null, panel, "Shadow", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                if (result == JOptionPane.OK_OPTION) {
                    if (activateShadowButton.isSelected()) {
                        hasShadow = true;
                    } else if (deactivateShadowButton.isSelected()) {
                        hasShadow = false;
                    }
                    createPropertyDto(hasShadow);
                }
            }
        });
    }

    public void createPropertyDto(Boolean newShadow) {
        if (shapeComposite == null) {
            JOptionPane.showMessageDialog(null, "속성값을 바꿀 도형이 선택되어있지 않습니다.");
            return;
        }
        PropertyDtoAbstractClass shadowDto = new ShadowPropertyDto(shapeComposite, newShadow);
        controller.updateShape(shapeComposite, shadowDto);
    }

    @Override
    public void onUpdateClickedShapes() {
        this.shapeComposite = controller.getClickedShapesComposite();
        if (shapeComposite == null) {
            throw new NullPointerException("shapeComposite is null");
        }
        if (shapeComposite.shapesCount() == 1) {
            this.hasShadow = shapeComposite.getChildren().get(0).getShadow();
        } else {
            this.hasShadow = null;
        }
        setRadioButtonState();
    }

    @Override
    public void onUpdateAllShapes() {
        if (shapeComposite != null && shapeComposite.shapesCount() == 1) {
            this.hasShadow = shapeComposite.getChildren().get(0).getShadow();
        } else {
            this.hasShadow = null;
        }
        setRadioButtonState();
    }

    private void setRadioButtonState() {
        if (hasShadow == null) {
            activateShadowButton.setSelected(false);
            deactivateShadowButton.setSelected(false);
        } else if (hasShadow) {
            activateShadowButton.setSelected(true);
        } else {
            deactivateShadowButton.setSelected(true);
        }
    }
}
