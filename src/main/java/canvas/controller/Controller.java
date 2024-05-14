package canvas.controller;
import canvas.controller.dto.propertyDto.PropertyDtoAbstractClass;
import canvas.controller.dto.propertyDto.propertyDtos.ZOrderPropertyDto;
import canvas.model.shape.ShapeAbstractClass;
import canvas.model.Model;
import canvas.model.shape.composite.ShapeComposite;
import canvas.observer.Observer;
import canvas.state.DefaultState;
import canvas.state.StateInterface;

import java.awt.event.MouseEvent;

public class Controller {
    private final Model model;
    private StateInterface currentState;

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

    public void handleMouseClick(MouseEvent e) {
        currentState.handleMouseClick(e);
    }

    public void handleMouseDrag(MouseEvent e) {
        currentState.handleMouseDrag(e);
    }

    public void handleMouseRelease(MouseEvent e) {
        currentState.handleMouseRelease(e);
    }
}
