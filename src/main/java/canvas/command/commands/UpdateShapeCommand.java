package canvas.command.commands;

import canvas.command.CommandInterface;
import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.model.Model;
import canvas.model.shape.ShapeAbstractClass;

import java.util.ArrayList;
import java.util.List;

public class UpdateShapeCommand implements CommandInterface {
    private final PropertyDtoAbstractClass propertyDtoAbstractClass;
    private final Model model;
    private final List<ShapeAbstractClass> targetShapes;
    private final List<ShapeAbstractClass> backupShapes;

    public UpdateShapeCommand(PropertyDtoAbstractClass propertyDtoAbstractClass){
        this.propertyDtoAbstractClass = propertyDtoAbstractClass;
        this.model = Model.getInstance();
        this.targetShapes = new ArrayList<>(model.getClickedShapes());
        this.backupShapes = new ArrayList<>();
    }

    @Override
    public void execute() {
        backupShapes.clear();
        for (ShapeAbstractClass shape : targetShapes) {
            backupShapes.add(shape.cloneShape());
        }
        model.updateShape(propertyDtoAbstractClass, targetShapes);
    }

    @Override
    public void unexecute() {
        model.restoreShapes(backupShapes);
    }
}