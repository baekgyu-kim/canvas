package canvas.view.property.propertyButton.propertyButtons;

import canvas.factory.dto.propertyDtoFactories.ResizeDtoCreator;
import canvas.view.property.propertyButton.PropertyButton;

import javax.swing.*;
import java.awt.*;

public class ResizeButton extends PropertyButton {
    private Integer currentWidth = 0;
    private Integer currentHeight = 0;

    public ResizeButton() {
        super();
        this.propertyDtoCreatorInterface = new ResizeDtoCreator();
        initializeButton("Resize Shape");
        addActionListener(e -> {
            String widthPlaceholder = currentWidth.toString();
            String heightPlaceholder = currentHeight.toString();

            JPanel panel = new JPanel(new GridLayout(2, 2));
            panel.add(new JLabel("Enter new width:"));
            JTextField widthField = new JTextField(widthPlaceholder, 5);
            panel.add(widthField);
            panel.add(new JLabel("Enter new height:"));
            JTextField heightField = new JTextField(heightPlaceholder, 5);
            panel.add(heightField);

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
        });
    }

    private boolean isValidSize(int width, int height) {
        int canvasWidth = 800;
        int canvasHeight = 600;
        return width > 0 && width <= canvasWidth && height > 0 && height <= canvasHeight;
    }

    private void createPropertyDto(int newWidth, int newHeight) {
        if (clickedShapes == null) {
            JOptionPane.showMessageDialog(null, "속성값을 바꿀 도형이 선택되어있지 않습니다.");
            return;
        }
        propertyDtoCreatorInterface.createPropertyDto(newWidth, newHeight);
    }


    private void addPlaceholderFocusListener(JTextField textField, String placeholder) {
        setPlaceholder(textField, placeholder);
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
        if(clickedShapes == null){
            throw new NullPointerException("clickedShapes is null");
        }
        if(clickedShapes.size() == 1){
            this.currentWidth = clickedShapes.get(0).getWidth();
            this.currentHeight = clickedShapes.get(0).getHeight();
        }
    }
}
