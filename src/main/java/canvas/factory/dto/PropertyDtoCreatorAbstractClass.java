package canvas.factory.dto;

import canvas.controller.Controller;
import canvas.model.shape.ShapeAbstractClass;

import java.awt.*;
import java.util.List;

public abstract class PropertyDtoCreatorAbstractClass implements PropertyDtoCreatorInterface{
    protected Controller controller;
    protected List<ShapeAbstractClass> clickedShapes;
    public PropertyDtoCreatorAbstractClass() {
        this.controller = Controller.getInstance();
        this.clickedShapes = controller.getClickedShapes();
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
