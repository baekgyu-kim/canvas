package canvas.view.property.propertyButton.propertyButtons;

import canvas.factory.dto.propertyDtoFactories.MoveDtoCreator;
import canvas.view.property.propertyButton.PropertyButton;

import javax.swing.*;
import java.awt.*;

public class MoveButton extends PropertyButton {
    private Integer currentXPos = 0;
    private Integer currentYPos = 0;

    public MoveButton() {
        super();
        this.propertyDtoCreatorInterface = new MoveDtoCreator();
        initializeButton("Move Shape");
        addActionListener(e -> {
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
        });
    }

    private boolean isValidCoordinate(int x, int y) {
        int canvasWidth = 800;
        int canvasHeight = 600;
        return x >= 0 && x <= canvasWidth && y >= 0 && y <= canvasHeight;
    }

    private void createPropertyDto(int newX, int newY) {
        if (clickedShapes == null) {
            JOptionPane.showMessageDialog(null, "속성값을 바꿀 도형이 선택되어있지 않습니다.");
            return;
        }
        propertyDtoCreatorInterface.createPropertyDto(newX, newY);
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
            throw new NullPointerException("shapeComposite is null");
        }
        if(clickedShapes.size() == 1){
            this.currentXPos = clickedShapes.get(0).getXPos();
            this.currentYPos = clickedShapes.get(0).getYPos();
        }
    }

    private void addPlaceholderFocusListener(JTextField textField, String placeholder) {
        ResizeButton.setPlaceholder(textField, placeholder);
    }

}
