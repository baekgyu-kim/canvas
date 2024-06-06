package canvas.command.commands;

import canvas.command.CommandInterface;
import canvas.model.Model;

public class ClearAllShapesCommand implements CommandInterface {
    private final Model model;
    public ClearAllShapesCommand() {
        this.model = Model.getInstance();
    }

    @Override
    public void execute() {
        model.clearAllShapes();
    }
}
