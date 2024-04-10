package canvas.model;

import canvas.model.observer.Observer;
import canvas.model.observer.Subject;
import canvas.dto.ShapeDto;
import canvas.model.shape.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Model implements Subject {
    private static final Logger logger = Logger.getLogger(Model.class.getName());
    private List<Observer> observers;
    private List<Shape> shapes;

    public Model() {
        this.observers = new ArrayList<>();
        this.shapes = new ArrayList<>();
    }
    @Override
    public void registerObserver(Observer o) {
        if (!observers.contains(o)) {
            observers.add(o);
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
        return new Shape(dto.getXPos(), dto.getYPos(), dto.getWidth(), dto.getHeight(), dto.getColor(), dto.getOpacity(), dto.getZOrder(), dto.getShadow(), dto.getFrame());
    }

    public void createShape(ShapeDto dto) {
        shapes.add(shapeDtoToClass(dto));
        notifyObservers();
    }
    public void updateShape(int index, ShapeDto dto) {
        if (index >= 0 && index < shapes.size()) {
            shapes.set(index, shapeDtoToClass(dto));
            notifyObservers();
        } else {
            // 예외 처리와 로깅
            String errorMessage = "Attempted to update a shape with invalid index: " + index;
            logger.warning(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
    }
    public void deleteShape(int index) {
        if (index >= 0 && index < shapes.size()) {
            shapes.remove(index);
            notifyObservers();
        } else {
            String errorMessage = "Attempted to delete a shape with invalid index: " + index;
            logger.warning(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
    }

}
