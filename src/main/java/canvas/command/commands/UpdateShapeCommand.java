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
    private List<ShapeAbstractClass> backupShapes;

    public UpdateShapeCommand(PropertyDtoAbstractClass propertyDtoAbstractClass){
        this.propertyDtoAbstractClass = propertyDtoAbstractClass;
        this.model = Model.getInstance();
    }

    @Override
    public void execute() {
        backupShapes = new ArrayList<>();
        for (ShapeAbstractClass shape : propertyDtoAbstractClass.getClickedShapes()) {
            backupShapes.add(shape.cloneShape());
        }
        model.updateShape(propertyDtoAbstractClass);
    }

    @Override
    public void unexecute() {
        model.restoreShapes(backupShapes);
    }
}
