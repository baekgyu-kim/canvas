package canvas.dto.propertyDto;

import canvas.model.shape.ShapeAbstractClass;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class PropertyDtoAbstractClass implements PropertyDtoInterface {
    protected List<ShapeAbstractClass> clickedShapes;
    protected List<ShapeAbstractClass> backupShapes;

    protected Color color;
    protected Integer value1;
    protected Integer value2;
    protected Boolean boolValue;
    public PropertyDtoAbstractClass(List<ShapeAbstractClass> clickedShapes) {
        this.clickedShapes = clickedShapes;
    }
    public PropertyDtoAbstractClass(List<ShapeAbstractClass> clickedShapes, Color color) {
        this.clickedShapes = clickedShapes;
        this.color = color;
    }
    public PropertyDtoAbstractClass(List<ShapeAbstractClass> clickedShapes, Integer value1) {
        this.clickedShapes = clickedShapes;
        this.value1 = value1;
    }
    public PropertyDtoAbstractClass(List<ShapeAbstractClass> clickedShapes, Integer value1, Integer value2) {
        this.clickedShapes = clickedShapes;
        this.value1 = value1;
        this.value2 = value2;
    }
    public PropertyDtoAbstractClass(List<ShapeAbstractClass> clickedShapes, Boolean boolValue) {
        this.clickedShapes = clickedShapes;
        this.boolValue = boolValue;
    }

    public List<ShapeAbstractClass> getClickedShapes() {
        return this.clickedShapes;
    }

    @Override
    public void applyPropertyUpdate(ShapeAbstractClass shapeAbstractClass) {}

    @Override
    public void backupCurrentState() {
        this.backupShapes = new ArrayList<>();
        for (ShapeAbstractClass shape : clickedShapes) {
            this.backupShapes.add(shape.cloneShape());
        }
    }

    @Override
    public void restoreBackupState() {
        for (ShapeAbstractClass backupShape : backupShapes) {
            for (ShapeAbstractClass shape : clickedShapes) {
                if (shape.getId() == backupShape.getId()) {
                    shape.restoreShape(backupShape);
                }
            }
        }
    }
}
