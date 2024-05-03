package canvas.model;

import canvas.dto.UpdateDtoInterface;
import canvas.dto.UpdateMoveDto;
import canvas.dto.UpdateResizeDto;
import canvas.factory.shape.ShapeAbstractClass;
import canvas.factory.shape.composite.ShapeComposite;
import canvas.observer.Observer;
import canvas.observer.Subject;


import java.util.ArrayList;
import java.util.List;

public class Model implements Subject {
    private List<Observer> observers;
    private List<ShapeAbstractClass> shapes;

    private ShapeComposite clickedShapesComposite;

    public Model() {
        this.observers = new ArrayList<>();
        this.shapes = new ArrayList<>();
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
            observer.updateAllShapes(shapes);
        }
    }

    @Override
    public void notifyObserversClickedShapes() {
        for (Observer observer : observers) {
            observer.updateClickedShapes(clickedShapesComposite);
        }
    }

    public void createShape(ShapeAbstractClass shape) {
        shapes.add(shape);
        notifyObserversAllShapes();
    }

    public void clickShape(int index){
        if (index < 0 || index >= shapes.size()) {
            throw new IllegalArgumentException("Invalid shape index: " + index);
        }
        ShapeAbstractClass clickedShape = shapes.get(index);
        clickedShapesComposite.add(clickedShape);
        notifyObserversClickedShapes();
    }

    public void clearClicks(){
        clickedShapesComposite.clear();
        notifyObserversClickedShapes();
    }


    public void updateShape(UpdateDtoInterface dto) {
        if (dto instanceof UpdateMoveDto) {
            UpdateMoveDto moveDto = (UpdateMoveDto) dto;
            clickedShapesComposite.move(moveDto.getNewXPos(), moveDto.getNewYPos());
        } else if (dto instanceof UpdateResizeDto) {
            UpdateResizeDto resizeDto = (UpdateResizeDto) dto;
            clickedShapesComposite.resize(resizeDto.getNewWidth(), resizeDto.getNewHeight());
        }
        notifyObserversAllShapes();
    }

}
