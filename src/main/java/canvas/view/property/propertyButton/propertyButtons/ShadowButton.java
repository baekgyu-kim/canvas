package canvas.view.property.propertyButton.propertyButtons;

import canvas.factory.dto.propertyDtoFactories.ShadowDtoCreator;
import canvas.view.property.propertyButton.PropertyButton;

import javax.swing.*;

public class ShadowButton extends PropertyButton {
    private Boolean hasShadow = null;
    private final JRadioButton activateShadowButton;
    private final JRadioButton deactivateShadowButton;

    public ShadowButton() {
        super();
        this.propertyDtoCreatorInterface = new ShadowDtoCreator();
        initializeButton("Shadow Effect");

        activateShadowButton = new JRadioButton("Activate shadow effect");
        deactivateShadowButton = new JRadioButton("Deactivate shadow effect");

        ButtonGroup group = new ButtonGroup();
        group.add(activateShadowButton);
        group.add(deactivateShadowButton);

        addActionListener(e -> {
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
        });
    }

    private void createPropertyDto(Boolean newShadow) {
        if (clickedShapes == null) {
            JOptionPane.showMessageDialog(null, "속성값을 바꿀 도형이 선택되어있지 않습니다.");
            return;
        }
        propertyDtoCreatorInterface.createPropertyDto(newShadow);
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
            throw new NullPointerException("clickedShapes is null");
        }
        if (clickedShapes.size() == 1) {
            this.hasShadow = clickedShapes.get(0).getShadow();
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
