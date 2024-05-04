package canvas.controller;
import canvas.dto.updateDto.UpdateDtoAbstractClass;
import canvas.dto.updateDto.UpdateDtoInterface;
import canvas.shape.ShapeAbstractClass;
import canvas.model.Model;
import canvas.observer.Observer;

public class Controller {
    private final Model model;

    public Controller(Model model) {
        this.model = model;
    }

    public void registerObserver(Observer observer){model.registerObserver(observer);}

    public void removeObserver(Observer observer){model.removeObserver(observer);}

    public void createShape(ShapeAbstractClass shape) {
        model.createShape(shape);
    }

    public void clickShapes(int index) {
        model.clickShape(index);
    }

    public void clearClicks(){model.clearClicks();}

    public void updateShape(UpdateDtoAbstractClass dto) {
        model.updateShape(dto);
    }

}
