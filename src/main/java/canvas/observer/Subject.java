package canvas.observer;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserversAllShapes();
    void notifyObserversClickedShapes();
}
