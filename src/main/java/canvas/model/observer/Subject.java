package canvas.model.observer;

import canvas.model.shape.ShapeState;

import java.util.ArrayList;
import java.util.List;

// MVC에서 Model이 Subject
public interface Subject {
    List<Observer> observers = new ArrayList<>();

    default void registerObserver(Observer o) {
        observers.add(o);
    }

    default void removeObserver(Observer o) {
        observers.remove(o);
    }

    default void notifyObservers(ShapeState state) {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }

}

