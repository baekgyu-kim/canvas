package canvas.controller;
import canvas.dto.UpdateDtoInterface;
import canvas.model.Model;
import canvas.dto.ShapeDto;
import canvas.model.shape.Shape;

public class Controller {
    private final Model model = new Model();

    public Controller() {
    }

    public void createShape(ShapeDto shapeDto) {
        model.createShape(shapeDto);
    }

    public void clickShapes(int index) {
        model.clickShape(index);
    }

    public void clearClicks(){model.clearClicks();}

    public void updateShape(UpdateDtoInterface dto) {
        model.updateShape(dto);
    }

}
