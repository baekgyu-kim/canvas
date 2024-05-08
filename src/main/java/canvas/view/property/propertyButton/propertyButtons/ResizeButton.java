package canvas.view.property.propertyButton.propertyButtons;

import canvas.controller.Controller;
import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.dto.propertyDto.propertyDtos.ResizePropertyDto;
import canvas.model.shape.composite.ShapeComposite;
import canvas.view.property.propertyButton.PropertyButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResizeButton extends PropertyButton {
    private final int canvasWidth = 800;
    private final int canvasHeight= 600;

    public ResizeButton(ShapeComposite shapeComposite, Controller controller) {
        super(shapeComposite, controller);
        initializeButton("Resize Shape");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panel = new JPanel(new GridLayout(2, 2));
                panel.add(new JLabel("Enter new width:"));
                JTextField widthField = new JTextField(5);
                panel.add(widthField);
                panel.add(new JLabel("Enter new height:"));
                JTextField heightField = new JTextField(5);
                panel.add(heightField);

                int result = JOptionPane.showConfirmDialog(null, panel,
                        "Resize Shape", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    try {
                        int newWidth = Integer.parseInt(widthField.getText());
                        int newHeight = Integer.parseInt(heightField.getText());
                        if (isValidSize(newWidth, newHeight)) {
                            createPropertyDto(newWidth, newHeight);
                        } else {
                            JOptionPane.showMessageDialog(null, "New size exceeds canvas bounds.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter valid numbers for both width and height.");
                    }
                }
            }
        });
    }

    private boolean isValidSize(int width, int height) {
        return width > 0 && width <= canvasWidth && height > 0 && height <= canvasHeight;
    }

    public void createPropertyDto(int newWidth, int newHeight) {
        PropertyDtoAbstractClass resizeDto = new ResizePropertyDto(newWidth, newHeight);
        controller.updateShape(shapeComposite, resizeDto);
    }
}