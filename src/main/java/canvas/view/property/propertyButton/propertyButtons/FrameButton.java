package canvas.view.property.propertyButton.propertyButtons;

import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.dto.propertyDto.propertyDtos.FramePropertyDto;
import canvas.view.property.propertyButton.PropertyButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameButton extends PropertyButton {
    private Boolean hasFrame = null;
    private JRadioButton activateFrameButton;
    private JRadioButton deactivateFrameButton;

    public FrameButton() {
        super();
        initializeButton("Frame Effect");

        activateFrameButton = new JRadioButton("Activate frame effect");
        deactivateFrameButton = new JRadioButton("Deactivate frame effect");

        ButtonGroup group = new ButtonGroup();
        group.add(activateFrameButton);
        group.add(deactivateFrameButton);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                panel.add(activateFrameButton);
                panel.add(deactivateFrameButton);

                setRadioButtonState();

                int result = JOptionPane.showConfirmDialog(null, panel, "Frame", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                if (result == JOptionPane.OK_OPTION) {
                    if (activateFrameButton.isSelected()) {
                        hasFrame = true;
                    } else if (deactivateFrameButton.isSelected()) {
                        hasFrame = false;
                    }
                    createPropertyDto(hasFrame);
                }
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
    public void onUpdateClickedShapes() {
        this.shapeComposite = controller.getClickedShapesComposite();
        if (shapeComposite == null) {
            throw new NullPointerException("shapeComposite is null");
        }
        if (shapeComposite.shapesCount() == 1) {
            this.hasFrame = shapeComposite.getChildren().get(0).getFrame();
        } else {
            this.hasFrame = null;
        }
        setRadioButtonState();
    }

    private void setRadioButtonState() {
        if (hasFrame == null) {
            activateFrameButton.setSelected(false);
            deactivateFrameButton.setSelected(false);
        } else if (hasFrame) {
            activateFrameButton.setSelected(true);
        } else {
            deactivateFrameButton.setSelected(true);
        }
    }
}
