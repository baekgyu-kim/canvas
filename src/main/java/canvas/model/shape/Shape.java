package canvas.model.shape;

public interface Shape {
    void move(int deltaX, int deltaY);
    void resize(int newWidth, int newHeight);
    // 등등
}
