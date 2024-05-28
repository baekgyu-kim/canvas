package canvas.factory.dto;


import java.awt.*;

public interface PropertyDtoCreatorInterface {
    void createPropertyDto();
    void createPropertyDto(Color color);
    void createPropertyDto(int integer);
    void createPropertyDto(int integer1, int integer2);
}
