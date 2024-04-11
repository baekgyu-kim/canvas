package canvas.model;

import canvas.dto.UpdateDtoInterface;
import canvas.dto.UpdateMoveDto;
import canvas.dto.UpdateResizeDto;
import canvas.model.observer.Observer;
import canvas.model.observer.Subject;
import canvas.dto.ShapeDto;
import canvas.model.shape.Shape;
import canvas.model.shape.ShapeComposite;

import java.util.ArrayList;
import java.util.List;

public class Model implements Subject {
    private List<Observer> observers;
    private List<Shape> shapes;

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
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(shapes);
        }
    }

    private Shape shapeDtoToClass(ShapeDto dto) {
        return new Shape(dto.getId(), dto.getShapeType(), dto.getXPos(), dto.getYPos(), dto.getWidth(), dto.getHeight(), dto.getColor(), dto.getOpacity(), dto.getZOrder(), dto.getShadow(), dto.getFrame());
    }

    public void createShape(ShapeDto dto) {
        shapes.add(shapeDtoToClass(dto));
        notifyObservers();
    }

    public void clickShape(int index){
        if (index < 0 || index >= shapes.size()) {
            throw new IllegalArgumentException("Invalid shape index: " + index);
        }
        Shape clickedShape = shapes.get(index);
        clickedShapesComposite.add(clickedShape);
        notifyObservers();
    }

    public void clearClicks(){
        clickedShapesComposite.clear();
        notifyObservers();
    }


    public void updateShape(UpdateDtoInterface dto) {
        if (dto instanceof UpdateMoveDto) {
            UpdateMoveDto moveDto = (UpdateMoveDto) dto;
            clickedShapesComposite.move(moveDto.getNewXPos(), moveDto.getNewYPos());
        } else if (dto instanceof UpdateResizeDto) {
            UpdateResizeDto resizeDto = (UpdateResizeDto) dto;
            clickedShapesComposite.resize(resizeDto.getNewWidth(), resizeDto.getNewHeight());
        }
        notifyObservers();
    }

}
