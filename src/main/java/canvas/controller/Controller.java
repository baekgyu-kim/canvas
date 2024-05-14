package canvas.controller;
import canvas.controller.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.controller.dto.propertyDto.propertyDtos.ZOrderPropertyDto;
import canvas.model.shape.ShapeAbstractClass;
import canvas.model.Model;
import canvas.model.shape.composite.ShapeComposite;
import canvas.observer.Observer;
import canvas.state.DefaultState;
import canvas.state.StateInterface;
import canvas.view.palette.paletteButton.PaletteButton;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final Model model;
    private StateInterface currentState;
    private PaletteButton activeButton;

    public Controller(Model model){
        this.model=model;
        this.currentState = new DefaultState(this);
        this.currentState.activateState();
    }

    public void registerObserver(Observer observer){model.registerObserver(observer);}

    public void removeObserver(Observer observer){model.removeObserver(observer);}

    public void createShape(ShapeAbstractClass shape){model.createShape(shape);}

    public void toggleShapeClick(int id){model.clickShape(id);}

    public void clearClicks(){model.clearClicks();}

    public void updateShape(ShapeComposite shapeComposite, PropertyDtoAbstractClass propertyDto){model.updateShape(shapeComposite, propertyDto);}

    public void bringFront(ZOrderPropertyDto propertyDto) {
        model.bringFront(propertyDto);
    }

    public void sendBack(ZOrderPropertyDto propertyDto) {
        model.sendBack(propertyDto);
    }

    public void setState(StateInterface state) {
        currentState.deactivateState();
        this.currentState = state;
        currentState.activateState();
    }

    public void handleMouseClick(MouseEvent e, ArrayList<ShapeAbstractClass> allShapes) {
        currentState.handleMouseClick(e, allShapes);
    }

    public void setActiveButton(PaletteButton button) {
        if (this.activeButton != null) {
            this.activeButton.deactivate();
        }
        this.activeButton = button;
        this.activeButton.activate();
    }
    public void setDefaultState() {
        if (this.activeButton != null) {
            this.activeButton.deactivate();
        }
        this.activeButton = null;
        setState(new DefaultState(this));
    }

    public PaletteButton getActiveButton() {
        return this.activeButton;
    }
}
