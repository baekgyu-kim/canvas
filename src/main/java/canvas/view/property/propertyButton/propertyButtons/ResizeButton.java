package canvas.view.property.propertyButton.propertyButtons;

import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.dto.propertyDto.propertyDtos.ResizePropertyDto;
import canvas.view.property.propertyButton.PropertyButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class ResizeButton extends PropertyButton {
    private Integer currentWidth = 0;
    private Integer currentHeight = 0;

    public ResizeButton() {
        super();
        initializeButton("Resize Shape");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String widthPlaceholder = currentWidth.toString();
                String heightPlaceholder = currentHeight.toString();

                JPanel panel = new JPanel(new GridLayout(2, 2));
                panel.add(new JLabel("Enter new width:"));
                JTextField widthField = new JTextField(widthPlaceholder, 5);
                panel.add(widthField);
                panel.add(new JLabel("Enter new height:"));
                JTextField heightField = new JTextField(heightPlaceholder, 5);
                panel.add(heightField);

                // Add focus listeners to clear placeholders on focus
                addPlaceholderFocusListener(widthField, widthPlaceholder);
                addPlaceholderFocusListener(heightField, heightPlaceholder);

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
        int canvasWidth = 800;
        int canvasHeight = 600;
        return width > 0 && width <= canvasWidth && height > 0 && height <= canvasHeight;
    }

    public void createPropertyDto(int newWidth, int newHeight) {
        if (shapeComposite == null) {
            JOptionPane.showMessageDialog(null, "속성값을 바꿀 도형이 선택되어있지 않습니다.");
            return;
        }
        PropertyDtoAbstractClass resizeDto = new ResizePropertyDto(shapeComposite,newWidth, newHeight);
        controller.updateShape(shapeComposite, resizeDto);
    }

    @Override
    public void onUpdateClickedShapes() {
        this.shapeComposite = controller.getClickedShapesComposite();
        if(shapeComposite == null){
            throw new NullPointerException("shapeComposite is null");
        }
        if(shapeComposite.shapesCount() == 1){
            this.currentWidth = shapeComposite.getChildren().get(0).getWidth();
            this.currentHeight = shapeComposite.getChildren().get(0).getHeight();
        }
    }

    @Override
    public void onUpdateAllShapes() {
        if(shapeComposite != null && shapeComposite.shapesCount() == 1){
            this.currentWidth = shapeComposite.getChildren().get(0).getWidth();
            this.currentHeight = shapeComposite.getChildren().get(0).getHeight();
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
