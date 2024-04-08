package canvas.model.observer;

// MVC에서 View가 Observer
public interface Observer {
    void update(String state); // subject의 상태가 바뀌면 호출됨
}
