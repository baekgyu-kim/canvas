package canvas.command.commands;

import canvas.command.CommandInterface;
import canvas.model.Model;
import canvas.model.shape.ShapeAbstractClass;

import java.util.ArrayList;
import java.util.List;

public class ClearAllShapesCommand implements CommandInterface {
    private final Model model;
    private List<ShapeAbstractClass> backupShapes;
    public ClearAllShapesCommand() {
        this.model = Model.getInstance();
    }

    @Override
    public void execute() {
        this.backupShapes = new ArrayList<>(model.getAllShapes());
        model.clearAllShapes();
    }

    @Override
    public void unexecute() {
        for (ShapeAbstractClass shape : backupShapes) {
            model.createShape(shape);
        }
    }
}
