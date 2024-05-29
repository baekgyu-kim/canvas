package canvas.view.property.propertyButton.propertyButtons;

import canvas.factory.dto.propertyDtoFactories.ColorDtoCreator;
import canvas.view.property.propertyButton.PropertyButton;

import javax.swing.*;
import java.awt.*;

public class ColorButton extends PropertyButton {
    private Color currentColor = Color.BLACK;
    public ColorButton() {
        super();
        this.propertyDtoCreatorInterface = new ColorDtoCreator();
        initializeButton("Change Color");
        addActionListener(e -> {
                Color newColor = JColorChooser.showDialog(null, "Choose a color", currentColor);
                if (newColor != null) {
                    createPropertyDto(newColor);
                }

        });
    }

    private void createPropertyDto(Color newColor) {
        if (shapeComposite == null) {
            JOptionPane.showMessageDialog(null, "속성값을 바꿀 도형이 선택되어있지 않습니다.");
            return;
        }
        propertyDtoCreatorInterface.createPropertyDto(newColor);
    }
    @Override
    public void onUpdateClickedShapes() {
        this.shapeComposite = controller.getClickedShapesComposite();
        if(shapeComposite == null){
            throw new NullPointerException("shapeComposite is null");
        }
        if(shapeComposite.shapesCount() == 1){
            this.currentColor = shapeComposite.getChildren().get(0).getColor();
        }
    }

}
