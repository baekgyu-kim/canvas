package canvas.view.property.propertyTextField;

import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.composite.ShapeComposite;
import canvas.observer.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public abstract class PropertyTextField extends JTextField implements Observer {
    ShapeComposite shapeComposite;
    public PropertyTextField(ShapeComposite shapeComposite, Integer columns) {
        super(columns);
        this.shapeComposite = shapeComposite;
        setupTextField();
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onTextFieldAction();
            }
        });

    }
    private void setupTextField() {
        Font currentFont = getFont();
        setFont(currentFont.deriveFont(currentFont.getSize2D() - 2.0f));
        setMargin(new Insets(0, 2, 0, 2));
    }

    protected void onTextFieldAction() {
        String text = getText();
        System.out.println(text);
    }

    @Override
    public void updateAllShapes(List<ShapeAbstractClass> shapes) {
    }

    @Override
    public void updateClickedShapes(ShapeComposite shapeComposite) {

    }
}
