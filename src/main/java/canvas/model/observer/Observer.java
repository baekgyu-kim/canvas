package canvas.model.observer;

public interface Observer {
    void update(String state); // subject의 상태가 바뀌면 호출됨
}
