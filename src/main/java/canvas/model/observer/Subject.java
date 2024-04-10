package canvas.model.observer;

import java.util.ArrayList;
import java.util.List;

public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    // 전체 도형의 상태를 Observer들에게 알림
    void notifyObservers();
}
