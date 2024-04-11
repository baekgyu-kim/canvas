package canvas.view;

import canvas.controller.Controller;
import canvas.model.observer.Observer;
import canvas.model.shape.Shape;

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
    public void update(List<Shape> shapes) {

    }
}
