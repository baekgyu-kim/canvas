package canvas.model;
import canvas.model.observer.Observer;
import canvas.model.observer.Subject;
import canvas.model.shape.ShapeState;

import java.util.ArrayList;
import java.util.List;

public class Model implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private List<ShapeState> shapes = new ArrayList<>();

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
    public void notifyObservers(ShapeState state) {
        for (Observer observer : observers) {
            // 마지막에 변경된 도형의 상태를 알림
            if (!shapes.isEmpty()) {
                observer.update(shapes.get(shapes.size() - 1));
            }
        }
    }

    // 도형의 상태를 추가하는 메소드
    public void addShape(ShapeState state) {
        shapes.add(state);
        notifyObservers(state);
    }

    // 여기에 더 많은 메소드 추가
}
