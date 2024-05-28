package canvas.view.property.propertyButton.propertyButtons;

import canvas.controller.Controller;
import canvas.controller.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.controller.dto.propertyDto.propertyDtos.ColorPropertyDto;
import canvas.model.shape.ShapeAbstractClass;
import canvas.view.property.propertyButton.PropertyButton;
import canvas.model.shape.composite.ShapeComposite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ColorButton extends PropertyButton {
    private Color currentColor = Color.BLACK;
    public ColorButton() {
        super();
        initializeButton("Change Color");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    Color newColor = JColorChooser.showDialog(null, "Choose a color", currentColor);
                    if (newColor != null) {
                        createPropertyDto(newColor);
                    }

            }
        });
    }

    public void createPropertyDto(Color newColor) {
        if (shapeComposite == null) {
            JOptionPane.showMessageDialog(null, "속성값을 바꿀 도형이 선택되어있지 않습니다.");
            return;
        }
        PropertyDtoAbstractClass colorDto = new ColorPropertyDto(shapeComposite, newColor);
        controller.updateShape(shapeComposite, colorDto);
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

    @Override
    public void onUpdateAllShapes() {
        if(shapeComposite != null && shapeComposite.shapesCount() == 1){
            this.currentColor = shapeComposite.getChildren().get(0).getColor();
        }
    }
}
