package canvas.view.property.propertyButton.propertyButtons;

import canvas.factory.dto.propertyDtoFactories.OpacityDtoCreator;
import canvas.view.property.propertyButton.PropertyButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class OpacityButton extends PropertyButton {
    private Integer currentOpacity = 100;

    public OpacityButton() {
        super();
        this.propertyDtoCreatorInterface = new OpacityDtoCreator();
        initializeButton("Change Opacity");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String opacityPlaceholder = currentOpacity.toString();

                JPanel panel = new JPanel(new GridLayout(2, 2));
                panel.add(new JLabel("Enter new opacity (0-100):"));
                JTextField opacityField = new JTextField(opacityPlaceholder, 5);
                panel.add(opacityField);

                addPlaceholderFocusListener(opacityField, opacityPlaceholder);

                int result = JOptionPane.showConfirmDialog(null, panel,
                        "Change Opacity", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    try {
                        int newOpacity = Integer.parseInt(opacityField.getText());
                        if (isValidOpacity(newOpacity)) {
                            createPropertyDto(newOpacity);
                        } else {
                            JOptionPane.showMessageDialog(null, "Please enter a valid opacity value between 0 and 100.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid number for opacity.");
                    }
                }
            }
        });
    }

    private boolean isValidOpacity(int opacity) {
        return opacity >= 0 && opacity <= 100;
    }

    private void createPropertyDto(int newOpacity) {
        if (shapeComposite == null) {
            JOptionPane.showMessageDialog(null, "속성값을 바꿀 도형이 선택되어있지 않습니다.");
            return;
        }
        propertyDtoCreatorInterface.createPropertyDto(newOpacity);
    }

    @Override
    public void onUpdateClickedShapes() {
        this.shapeComposite = controller.getClickedShapesComposite();
        if(shapeComposite == null){
            throw new NullPointerException("shapeComposite is null");
        }
        if(shapeComposite.shapesCount() == 1){
            this.currentOpacity = shapeComposite.getChildren().get(0).getOpacity();
        }
    }


    private void addPlaceholderFocusListener(JTextField textField, String placeholder) {
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                }
            }
        });
    }
}
