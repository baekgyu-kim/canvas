package canvas.view.property.propertyButton;

import canvas.controller.Controller;
import canvas.factory.dto.PropertyDtoCreatorInterface;
import canvas.model.shape.composite.ShapeComposite;
import canvas.observer.Observer;

import javax.swing.*;

public abstract class PropertyButton extends JButton implements Observer {
    protected ShapeComposite shapeComposite;
    protected Controller controller;
    protected PropertyDtoCreatorInterface propertyDtoCreatorInterface;

    public PropertyButton() {
        this.controller = Controller.getInstance();
        this.shapeComposite = controller.getClickedShapesComposite();
        controller.registerObserver(this);
    }

    public void initializeButton(String text){
        setText(text);
        setVisible(true);
    }

    @Override
    public void onUpdateAllShapes() {}
    @Override
    public void onUpdateClickedShapes() {}
}
