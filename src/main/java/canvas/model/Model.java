package canvas.model;

import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.composite.ShapeComposite;
import canvas.observer.Observer;
import canvas.observer.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Model implements Subject {
    private static Model modelInstance;

    private final List<Observer> observers;
    private final List<ShapeAbstractClass> allShapes;
    private final ShapeComposite clickedShapesComposite;

    private Model() {
        this.observers = new ArrayList<>();
        this.allShapes = new ArrayList<>();
        this.clickedShapesComposite = new ShapeComposite();
    }

    public static Model getInstance() {
        if (modelInstance == null) {
            modelInstance = new Model();
        }
        return modelInstance;
    }

    @Override
    public void registerObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void notifyObserversAllShapes() {
        for (Observer observer : observers) {
            observer.onUpdateAllShapes();
        }
    }

    @Override
    public void notifyObserversClickedShapes() {
        for (Observer observer : observers) {
            observer.onUpdateClickedShapes();
        }
    }

    public void createShape(ShapeAbstractClass shape) {
        allShapes.add(shape);
        notifyObserversAllShapes();
    }

    public void clearAllShapes() {
        allShapes.clear();
        notifyObserversAllShapes();
    }

    public void removeOneShape(ShapeAbstractClass shape) {
        if (!allShapes.contains(shape)) {
            throw new NoSuchElementException();
        }
        allShapes.remove(shape);
        notifyObserversAllShapes();
    }

    public void updateShape(PropertyDtoAbstractClass propertyDto) {
        List<ShapeAbstractClass> clickedShapes = propertyDto.getClickedShapes();
        for (ShapeAbstractClass shape : clickedShapes) {
            propertyDto.applyPropertyUpdate(shape);
        }
        notifyObserversAllShapes();
    }

    public void restoreUpdate(PropertyDtoAbstractClass propertyDto){
        propertyDto.restoreBackupState();
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


    private ShapeAbstractClass findShapeById(int id) throws NoSuchElementException {
        for (ShapeAbstractClass shape : allShapes) {
            if (shape.getId() == id) {
                return shape;
            }
        }
        throw new NoSuchElementException("No shape found with ID: " + id);
    }
    public List<ShapeAbstractClass> getAllShapes() {
        return allShapes;
    }

    public List<ShapeAbstractClass> getClickedShapes() {
        return clickedShapesComposite.getChildren();
    }
}
