package canvas.controller;
import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.model.shape.ShapeAbstractClass;
import canvas.model.Model;
import canvas.model.shape.composite.ShapeComposite;
import canvas.observer.Observer;

public class Controller {
    private final Model model;

    public Controller(Model model){this.model=model;}

    public void registerObserver(Observer observer){model.registerObserver(observer);}

    public void removeObserver(Observer observer){model.removeObserver(observer);}

    public void createShape(ShapeAbstractClass shape){model.createShape(shape);}

    public void toggleShapeClick(int id){model.clickShape(id);}

    public void clearClicks(){model.clearClicks();}

    public void updateShape(ShapeComposite shapeComposite, PropertyDtoAbstractClass propertyDto){model.updateShape(shapeComposite, propertyDto);}

}
