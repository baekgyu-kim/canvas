package canvas.view.property.propertyButton.propertyButtons;

import canvas.controller.Controller;
import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.dto.propertyDto.propertyDtos.OpacityPropertyDto;
import canvas.model.shape.composite.ShapeComposite;
import canvas.view.property.propertyButton.PropertyButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpacityButton extends PropertyButton {
    public OpacityButton(ShapeComposite shapeComposite, Controller controller) {
        super(shapeComposite, controller);
        initializeButton("Change Opacity");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panel = new JPanel(new GridLayout(2, 2));
                panel.add(new JLabel("Enter new opacity (0-100):"));
                JTextField opacityField = new JTextField(5);
                panel.add(opacityField);

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

    public void createPropertyDto(int newOpacity) {
        PropertyDtoAbstractClass opacityDto = new OpacityPropertyDto(newOpacity);
        controller.updateShape(shapeComposite, opacityDto);
    }
}
