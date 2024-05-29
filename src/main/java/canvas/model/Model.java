package canvas.model;


import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.dto.propertyDto.propertyDtos.ZOrderPropertyDto;
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
    public void removeObserver(Observer observer) {
        observers.remove(observer);
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


    public void updateShape(PropertyDtoAbstractClass propertyDto) {
        ShapeComposite shapeComposite = propertyDto.getShapeComposite();
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
    public void bringFront(ZOrderPropertyDto dto) {
        ShapeAbstractClass shape = dto.getShape();
        if (allShapes.remove(shape)) {
            allShapes.add(shape);
            notifyObserversAllShapes();
        }
    }

    public void sendBack(ZOrderPropertyDto dto) {
        ShapeAbstractClass shape = dto.getShape();
        if (allShapes.remove(shape)) {
            allShapes.add(0, shape);
            notifyObserversAllShapes();
        }
    }

    public List<ShapeAbstractClass> getAllShapes() {
        return allShapes;
    }

    public ShapeComposite getClickedShapesComposite() {
        return clickedShapesComposite;
    }
}
