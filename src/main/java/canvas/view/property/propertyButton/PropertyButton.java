package canvas.view.property.propertyButton;

import canvas.factory.PropertyDtoCreatorInterface;
import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.composite.ShapeComposite;
import canvas.observer.Observer;

import javax.swing.*;
import java.util.List;

public abstract class PropertyButton extends JButton implements Observer, PropertyDtoCreatorInterface {
    ShapeComposite shapeComposite;

    public PropertyButton(ShapeComposite shapeComposite) {
        this.shapeComposite = shapeComposite;
    }

    public void initializeButton(String text){
        setText(text);
        setVisible(true);
    };

    public abstract void changeProperty();

    @Override
    public void updateAllShapes(List<ShapeAbstractClass> shapes) {}

    @Override
    public void updateClickedShapes(ShapeComposite shapeComposite) {
        this.shapeComposite = shapeComposite;
    }

}
