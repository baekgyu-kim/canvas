package canvas.view.property.propertyButton;

import canvas.controller.Controller;
import canvas.factory.dto.PropertyDtoCreatorInterface;
import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.composite.ShapeComposite;
import canvas.observer.Observer;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public abstract class PropertyButton extends JButton implements Observer, PropertyDtoCreatorInterface {
    protected ShapeComposite shapeComposite;
    protected Controller controller;

    public PropertyButton() {
        this.controller = Controller.getInstance();
        this.shapeComposite = controller.getClickedShapesComposite();
    }

    public void initializeButton(String text){
        setText(text);
        setVisible(true);
    };


    @Override
    public void onUpdateAllShapes() {}
    @Override
    public void onUpdateClickedShapes() {}
    @Override
    public void createPropertyDto() {}
    @Override
    public void createPropertyDto(Color color) {}
    @Override
    public void createPropertyDto(int integer) {}
    @Override
    public void createPropertyDto(int integer1, int integer2) {}
}
