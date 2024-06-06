package canvas.command.commands;

import canvas.command.CommandInterface;
import canvas.model.Model;
import canvas.model.shape.ShapeAbstractClass;

public class CreateShapeCommand implements CommandInterface {
    private final ShapeAbstractClass shapeAbstractClass;
    private final Model model;
    private ShapeAbstractClass backupShape;
    public CreateShapeCommand(ShapeAbstractClass shapeAbstractClass) {
        this.shapeAbstractClass = shapeAbstractClass;
        this.model = Model.getInstance();
    }
    @Override
    public void execute() {
        this.backupShape = shapeAbstractClass;
        model.createShape(shapeAbstractClass);
    }

    @Override
    public void unexecute() {
        model.removeOneShape(backupShape);
    }
}
