package canvas.model.observer;

// MVC에서 Model이 Subject
public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

