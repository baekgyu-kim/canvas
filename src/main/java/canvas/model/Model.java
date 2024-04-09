package canvas.model;

import canvas.model.observer.Observer;
import canvas.model.observer.Subject;
import canvas.dto.ShapeStateDto;
import java.util.ArrayList;
import java.util.List;

public class Model implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private List<ShapeStateDto> shapes = new ArrayList<>();

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
    public void notifyObservers(List<ShapeStateDto> shapes) {
        for (Observer observer : observers) {
            observer.update(new ArrayList<>(shapes)); // 전체 도형들의 상태를 복사하여 전달
        }
    }

    public void addShape(ShapeStateDto state) {
        shapes.add(state);
        notifyObservers(shapes);
    }

    public void modifyShape(int index, ShapeStateDto newState) {
        if (index >= 0 && index < shapes.size()) {
            shapes.set(index, newState);
            notifyObservers(shapes);
        }
    }

    // 추가 메소드 구현 ...
}
