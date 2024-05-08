package canvas.view.property.propertyButton.propertyButtons;

import canvas.controller.Controller;
import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.dto.propertyDto.propertyDtos.ColorPropertyDto;
import canvas.model.shape.ShapeAbstractClass;
import canvas.view.property.propertyButton.PropertyButton;
import canvas.model.shape.composite.ShapeComposite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorButton extends PropertyButton {
    public ColorButton(ShapeComposite shapeComposite, Controller controller) {
        super(shapeComposite, controller);
        initializeButton("Change Color");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color newColor = JColorChooser.showDialog(null, "Choose a color", Color.white);
                if (newColor != null) {
                    createPropertyDto(newColor);
                }
            }
        });
    }

    public void createPropertyDto(Color newColor) {
        PropertyDtoAbstractClass colorDto = new ColorPropertyDto(newColor);
        controller.updateShape(shapeComposite, colorDto);
    }

}
