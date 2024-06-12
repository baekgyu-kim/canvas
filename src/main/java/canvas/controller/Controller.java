package canvas.controller;

import canvas.command.CommandInterface;
import canvas.command.commands.ClearAllShapesCommand;
import canvas.command.commands.CreateShapeCommand;
import canvas.command.commands.UpdateShapeCommand;
import canvas.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.model.shape.ShapeAbstractClass;
import canvas.model.Model;
import canvas.observer.Observer;
import canvas.state.clickState.ClickState;
import canvas.state.StateInterface;
import canvas.view.palette.paletteButton.PaletteShapeButton;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Controller {
    private static Controller controllerInstance;

    private final Model model;
    private StateInterface currentState;
    private PaletteShapeButton activeButton;

    private final Stack<CommandInterface> undoStack = new Stack<>();
    private final Stack<CommandInterface> redoStack = new Stack<>();

    public static Controller getInstance() {
        if (controllerInstance == null) {
            controllerInstance = new Controller();
        }
        return controllerInstance;
    }

    private Controller(){
        this.model = Model.getInstance();
        this.currentState = new ClickState(this);
        this.currentState.activateState();
    }

    public void registerObserver(Observer observer){model.registerObserver(observer);}

    public void executeCommand(CommandInterface commandInterface){
        commandInterface.execute();
        undoStack.push(commandInterface);
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            CommandInterface command = undoStack.pop();
            command.unexecute();
            redoStack.push(command);
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            CommandInterface command = redoStack.pop();
            command.execute();
            undoStack.push(command);
        }
    }

    public void createShape(ShapeAbstractClass shapeAbstractClass){executeCommand(new CreateShapeCommand(shapeAbstractClass));}

    public void clearAllShapes() {executeCommand(new ClearAllShapesCommand());}

    public void updateShape(PropertyDtoAbstractClass propertyDtoAbstractClass){executeCommand(new UpdateShapeCommand(propertyDtoAbstractClass));}

    public void toggleShapeClick(int id){model.clickShape(id);}

    public void clearClicks(){model.clearClicks();}

    public void handleMouseClick(MouseEvent e, ArrayList<ShapeAbstractClass> allShapes) {
        currentState.handleMouseClick(e, allShapes);
    }

    public void setState(StateInterface state) {
        currentState.deactivateState();
        this.currentState = state;
        currentState.activateState();
    }

    public void setClickState() {
        if (this.activeButton != null) {
            this.activeButton.deactivate();
        }
        this.activeButton = null;
        setState(new ClickState(this));
    }

    public void setActiveButton(PaletteShapeButton button) {
        if (this.activeButton != null) {
            this.activeButton.deactivate();
        }
        this.activeButton = button;
        this.activeButton.activate();
    }

    public PaletteShapeButton getActiveButton() {return this.activeButton;}

    public List<ShapeAbstractClass> getAllShapes(){
        return model.getAllShapes();
    }

    public List<ShapeAbstractClass> getClickedShapes(){return model.getClickedShapes();}
}
