package canvas.view.palette.paletteButton;

import canvas.controller.Controller;
import canvas.factory.ShapeCreatorInterface;
import canvas.factory.shape.ShapeAbstractClass;
import canvas.factory.shape.composite.ShapeComposite;
import canvas.observer.Observer;

import javax.swing.*;
import java.util.List;


public abstract class PaletteButton extends JButton implements ShapeCreatorInterface, Observer {
    protected Controller controller;
    protected int seq;
    public PaletteButton(Controller controller, int seq) {
        this.controller = controller;
        this.seq = seq;
    }

    public void initializeButton(String text){
        setText(text);
        setVisible(true);
    };

    @Override
    public void updateAllShapes(List<ShapeAbstractClass> shapes) {
        this.seq = shapes.size();
    }

    @Override
    public void updateClickedShapes(ShapeComposite shapeComposite) {
        // 여기서는 아무것도 하지 않음.
    }
}
