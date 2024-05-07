package canvas.model;


import canvas.dto.updateDto.UpdateDtoAbstractClass;
import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.composite.ShapeComposite;
import canvas.observer.Observer;
import canvas.observer.Subject;


import java.util.ArrayList;
import java.util.List;

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
        if (clickedShapesComposite.is_shape_in_chidren(id)) {
            // 클릭 해제 로직
        } else{
            // 클릭 로직
        }
        notifyObserversClickedShapes();
    }

    public void unClickShape(int index){
        ShapeAbstractClass clickedShape = allShapes.get(index);
        clickedShapesComposite.remove(clickedShape);
    }

    public void clearClicks(){
        clickedShapesComposite.clear();
        notifyObserversClickedShapes();
    }


    public void updateShape(UpdateDtoAbstractClass dto) {
        // update logic 구현
        notifyObserversAllShapes();
    }

}
