package canvas.view.property.propertyButton.propertyButtons;

import canvas.controller.Controller;
import canvas.controller.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.controller.dto.propertyDto.propertyDtos.MovePropertyDto;
import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.composite.ShapeComposite;
import canvas.view.property.propertyButton.PropertyButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;

public class MoveButton extends PropertyButton {
    private Integer currentXPos = 0;
    private Integer currentYPos = 0;

    public MoveButton(ShapeComposite shapeComposite, Controller controller) {
        super(shapeComposite, controller);
        initializeButton("Move Shape");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String xPlaceholder = currentXPos.toString();
                String yPlaceholder = currentYPos.toString();

                JPanel panel = new JPanel(new GridLayout(2, 2));
                panel.add(new JLabel("Enter new x coordinate:"));
                JTextField xField = new JTextField(xPlaceholder, 5);
                panel.add(xField);
                panel.add(new JLabel("Enter new y coordinate:"));
                JTextField yField = new JTextField(yPlaceholder, 5);
                panel.add(yField);

                addPlaceholderFocusListener(xField, xPlaceholder);
                addPlaceholderFocusListener(yField, yPlaceholder);

                int result = JOptionPane.showConfirmDialog(null, panel,
                        "Move Shape", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    try {
                        int newX = Integer.parseInt(xField.getText());
                        int newY = Integer.parseInt(yField.getText());
                        if (isValidCoordinate(newX, newY)) {
                            createPropertyDto(newX, newY);
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
        int canvasWidth = 800;
        int canvasHeight = 600;
        return x >= 0 && x <= canvasWidth && y >= 0 && y <= canvasHeight;
    }

    public void createPropertyDto(int newX, int newY) {
        if (shapeComposite == null) {
            JOptionPane.showMessageDialog(null, "속성값을 바꿀 도형이 선택되어있지 않습니다.");
            return;
        }
        PropertyDtoAbstractClass moveDto = new MovePropertyDto(shapeComposite, newX, newY);
        controller.updateShape(shapeComposite, moveDto);
    }

    @Override
    public void onUpdateClickedShapes() {
        this.shapeComposite = controller.getClickedShapesComposite();
        if(shapeComposite == null){
            throw new NullPointerException("shapeComposite is null");
        }
        if(shapeComposite.shapesCount() == 1){
            this.currentXPos = shapeComposite.getChildren().get(0).getXPos();
            this.currentYPos = shapeComposite.getChildren().get(0).getYPos();
        }
    }

    @Override
    public void onUpdateAllShapes() {
        if(shapeComposite != null && shapeComposite.shapesCount() == 1){
                this.currentXPos = shapeComposite.getChildren().get(0).getXPos();
                this.currentYPos = shapeComposite.getChildren().get(0).getYPos();

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
