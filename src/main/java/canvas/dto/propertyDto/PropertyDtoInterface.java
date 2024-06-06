package canvas.dto.propertyDto;

import canvas.model.shape.ShapeAbstractClass;

public interface PropertyDtoInterface {
    void applyPropertyUpdate(ShapeAbstractClass shapeAbstractClass);
    void backupCurrentState();
    void restoreBackupState();
}
