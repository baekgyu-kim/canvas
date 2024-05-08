package canvas.view.property.propertyButton.propertyButtons;

import canvas.controller.Controller;
import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.dto.propertyDto.propertyDtos.MovePropertyDto;
import canvas.model.shape.composite.ShapeComposite;
import canvas.view.property.propertyButton.PropertyButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoveButton extends PropertyButton {
    private final int canvasWidth = 800;
    private final int canvasHeight = 600;

    public MoveButton(ShapeComposite shapeComposite, Controller controller) {
        super(shapeComposite, controller);
        initializeButton("Move Shape");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panel = new JPanel(new GridLayout(2, 2));
                panel.add(new JLabel("Enter new x coordinate:"));
                JTextField xField = new JTextField(5);
                panel.add(xField);
                panel.add(new JLabel("Enter new y coordinate:"));
                JTextField yField = new JTextField(5);
                panel.add(yField);

                int result = JOptionPane.showConfirmDialog(null, panel,
                        "Move Shape", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    try {
                        int newX = Integer.parseInt(xField.getText());
                        int newY = Integer.parseInt(yField.getText());
                        if (isValidCoordinate(newX, newY)) {
                            createPropertyDtos(newX, newY);
                        } else {
                            JOptionPane.showMessageDialog(null, "Coordinates are out of canvas bounds.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter valid numbers for both x and y coordinates.");
                    }
                }
            }
        });
    }

    private boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x <= canvasWidth && y >= 0 && y <= canvasHeight;
    }

    public void createPropertyDtos(int newX, int newY) {
        PropertyDtoAbstractClass moveDto = new MovePropertyDto(newX, newY);
        controller.updateShape(shapeComposite, moveDto);
    }
}
