package canvas.model.observer;

import canvas.dto.ShapeStateDto;
import java.util.ArrayList;
import java.util.List;

public interface Subject {
    List<Observer> observers = new ArrayList<>();

    default void registerObserver(Observer o) {
        observers.add(o);
    }

    default void removeObserver(Observer o) {
        observers.remove(o);
    }

    // 이제 전체 도형의 상태를 Observer들에게 알림
    default void notifyObservers(List<ShapeStateDto> shapes) {
        for (Observer observer : observers) {
            observer.update(new ArrayList<>(shapes)); // 상태 리스트의 복사본을 전달
        }
    }
}
