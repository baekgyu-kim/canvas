package canvas.model.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeComposite implements ShapeInterface {
    private List<ShapeInterface> children = new ArrayList<>();

    public void add(ShapeInterface component) {
        children.add(component);
    }
    public void clear() {
        children.clear();
    }
    @Override
    public void move(int deltaX, int deltaY) {
        for (ShapeInterface child : children) {
            child.move(deltaX, deltaY);
        }
    }

    @Override
    public void resize(int newWidth, int newHeight) {
        for (ShapeInterface child : children) {
            child.resize(newWidth, newHeight);
        }
    }
}