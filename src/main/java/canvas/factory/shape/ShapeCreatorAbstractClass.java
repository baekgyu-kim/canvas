package canvas.factory.shape;

import canvas.controller.Controller;
import canvas.model.shape.ShapeAbstractClass;

import java.awt.event.MouseEvent;

public abstract class ShapeCreatorAbstractClass implements ShapeCreatorInterface{
    Controller controller;
    public ShapeCreatorAbstractClass(){
        this.controller = Controller.getInstance();
    }
    @Override
    public void createShape(MouseEvent e, int id) {}

    @Override
    public void createShape(MouseEvent e, int id, String text) {}
}
