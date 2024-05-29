package canvas.factory.dto;

import canvas.controller.Controller;
import canvas.model.shape.composite.ShapeComposite;

import java.awt.*;

public abstract class PropertyDtoCreatorAbstractClass implements PropertyDtoCreatorInterface{
    protected Controller controller;
    protected ShapeComposite shapeComposite;;
    public PropertyDtoCreatorAbstractClass() {
        this.controller = Controller.getInstance();
        this.shapeComposite = controller.getClickedShapesComposite();
    }

    @Override
    public void createPropertyDto() {}

    @Override
    public void createPropertyDto(Color color) {}

    @Override
    public void createPropertyDto(int integer) {}

    @Override
    public void createPropertyDto(int integer1, int integer2) {}

    @Override
    public void createPropertyDto(Boolean bool) {}
}
