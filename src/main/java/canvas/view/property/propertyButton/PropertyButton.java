package canvas.view.property.propertyButton;

import canvas.controller.Controller;
import canvas.factory.dto.PropertyDtoCreatorInterface;
import canvas.model.shape.ShapeAbstractClass;
import canvas.observer.Observer;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;

public abstract class PropertyButton extends JButton implements Observer {
    protected List<ShapeAbstractClass> clickedShapes;
    protected Controller controller;
    protected PropertyDtoCreatorInterface propertyDtoCreatorInterface;

    public PropertyButton() {
        this.controller = Controller.getInstance();
        this.clickedShapes = controller.getClickedShapes();
        controller.registerObserver(this);
    }

    public void initializeButton(String text) {
        setText(text);
        setVisible(true);
    }

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
    @Override
    public void onUpdateAllShapes() {}
    @Override
    public void onUpdateClickedShapes() {}
}
