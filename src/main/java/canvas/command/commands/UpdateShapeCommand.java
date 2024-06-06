package canvas.command.commands;

import canvas.command.CommandInterface;
import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.model.Model;

public class UpdateShapeCommand implements CommandInterface {
    private final PropertyDtoAbstractClass propertyDtoAbstractClass;
    private final Model model;
    public UpdateShapeCommand(PropertyDtoAbstractClass propertyDtoAbstractClass){
        this.propertyDtoAbstractClass = propertyDtoAbstractClass;
        this.model = Model.getInstance();
    }

    @Override
    public void execute() {
        propertyDtoAbstractClass.backupCurrentState();
        model.updateShape(propertyDtoAbstractClass);
    }

    @Override
    public void unexecute() {
        model.restoreUpdate(propertyDtoAbstractClass);
    }
}
