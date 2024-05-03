package canvas.view.WhiteCanvas;

import canvas.controller.Controller;
import canvas.factory.shape.ShapeAbstractClass;
import canvas.observer.Observer;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class WhiteCanvas extends JPanel implements Observer {
    Controller controller;
    public WhiteCanvas(Controller controller) {
        this.controller = controller;

        setBackground(Color.white);
        setVisible(true);
    }

    @Override
    public void update(List<ShapeAbstractClass> shapes) {
        for (ShapeAbstractClass shape : shapes) {
            shape.draw();
        }
    }

}