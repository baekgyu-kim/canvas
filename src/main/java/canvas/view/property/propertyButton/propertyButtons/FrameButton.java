package canvas.view.property.propertyButton.propertyButtons;

import canvas.factory.dto.propertyDtoFactories.FrameDtoCreator;
import canvas.view.property.propertyButton.PropertyButton;

import javax.swing.*;

public class FrameButton extends PropertyButton {
    private Boolean hasFrame = null;
    private final JRadioButton activateFrameButton;
    private final JRadioButton deactivateFrameButton;

    public FrameButton() {
        super();
        this.propertyDtoCreatorInterface = new FrameDtoCreator();
        initializeButton("Frame Effect");

        activateFrameButton = new JRadioButton("Activate frame effect");
        deactivateFrameButton = new JRadioButton("Deactivate frame effect");

        ButtonGroup group = new ButtonGroup();
        group.add(activateFrameButton);
        group.add(deactivateFrameButton);

        addActionListener(e -> {
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
        });
    }

    private void createPropertyDto(Boolean newFrame) {
        if (clickedShapes == null) {
            JOptionPane.showMessageDialog(null, "속성값을 바꿀 도형이 선택되어있지 않습니다.");
            return;
        }
        propertyDtoCreatorInterface.createPropertyDto(newFrame);
    }

    @Override
    public void onUpdateAllShapes(){
        onUpdate();
    }

    @Override
    public void onUpdateClickedShapes() {
        onUpdate();
    }

    private void onUpdate() {
        this.clickedShapes = controller.getClickedShapes();
        if (clickedShapes == null) {
            throw new NullPointerException("shapeComposite is null");
        }
        if (clickedShapes.size() == 1) {
            this.hasFrame = clickedShapes.get(0).getFrame();
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
