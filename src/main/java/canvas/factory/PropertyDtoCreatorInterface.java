package canvas.factory;

import canvas.view.property.Property;

import java.awt.*;

public interface PropertyDtoCreatorInterface {
    public void createPropertyDto();
    public void createPropertyDto(Color color);
    public void createPropertyDto(int integer);
    public void createPropertyDto(int integer1, int integer2);
}
