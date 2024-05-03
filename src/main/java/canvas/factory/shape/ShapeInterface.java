package canvas.factory.shape;

public interface ShapeInterface {
    void draw();
    void move(int newX, int newY);
    void resize(int newWidth, int newHeight);
}
