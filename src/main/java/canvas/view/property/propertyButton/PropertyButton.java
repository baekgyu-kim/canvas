package canvas.view.property.propertyButton;

import canvas.controller.Controller;
import canvas.factory.dto.PropertyDtoCreatorInterface;
import canvas.model.shape.composite.ShapeComposite;
import canvas.observer.Observer;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public abstract class PropertyButton extends JButton implements Observer {
    protected ShapeComposite shapeComposite;
    protected Controller controller;
    protected PropertyDtoCreatorInterface propertyDtoCreatorInterface;

    public PropertyButton() {
        this.controller = Controller.getInstance();
        this.shapeComposite = controller.getClickedShapesComposite();
        controller.registerObserver(this);
    }

    public void initializeButton(String text) {
        setText(text);
        setVisible(true);
    }

    @Override
    public void onUpdateAllShapes() {}
    @Override
    public void onUpdateClickedShapes() {}

    protected static void setPlaceholder(JTextField textField, String placeholder) {
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
