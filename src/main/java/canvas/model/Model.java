package canvas.model;


import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.dto.propertyDto.propertyDtos.BringFrontPropertyDto;
import canvas.dto.propertyDto.propertyDtos.SendBackPropertyDto;
import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.composite.ShapeComposite;
import canvas.observer.Observer;
import canvas.observer.Subject;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Model implements Subject {
    private List<Observer> observers;
    private List<ShapeAbstractClass> allShapes;

    private ShapeComposite clickedShapesComposite;

    public Model() {
        this.observers = new ArrayList<>();
        this.allShapes = new ArrayList<>();
        this.clickedShapesComposite = new ShapeComposite();
    }
    @Override
    public void registerObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserversAllShapes() {
        for (Observer observer : observers) {
            observer.updateAllShapes(allShapes);
        }
    }

    @Override
    public void notifyObserversClickedShapes() {
        for (Observer observer : observers) {
            observer.updateClickedShapes(clickedShapesComposite);
        }
    }

    public void createShape(ShapeAbstractClass shape) {
        allShapes.add(shape);
        notifyObserversAllShapes();
    }

    public void clickShape(int id){
        ShapeAbstractClass shape = findShapeById(id);
        if (clickedShapesComposite.is_shape_in_composite(id)) {
            clickedShapesComposite.remove(shape);
        } else{
            clickedShapesComposite.add(shape);
        }
        notifyObserversClickedShapes();
    }

    public void clearClicks(){
        clickedShapesComposite.clear();
        notifyObserversClickedShapes();
    }


    public void updateShape(ShapeComposite shapeComposite, PropertyDtoAbstractClass propertyDto) {
        List<ShapeAbstractClass> children = shapeComposite.getChildren();
        for (ShapeAbstractClass child : children) {
            propertyDto.applyPropertyUpdate(child);
        }
        notifyObserversAllShapes();
    }

    private ShapeAbstractClass findShapeById(int id) throws NoSuchElementException {
        for (ShapeAbstractClass shape : allShapes) {
            if (shape.getId() == id) {
                return shape;
            }
        }
        throw new NoSuchElementException("No shape found with ID: " + id);
    }
    public void bringFront(BringFrontPropertyDto dto) {
        ShapeAbstractClass shape = dto.getShape();
        if (allShapes.remove(shape)) {
            allShapes.add(shape);
            notifyObserversAllShapes();
        }
    }

    public void sendBack(SendBackPropertyDto dto) {
        ShapeAbstractClass shape = dto.getShape();
        if (allShapes.remove(shape)) {
            allShapes.add(0, shape);
            notifyObserversAllShapes();
        }
    }


}
