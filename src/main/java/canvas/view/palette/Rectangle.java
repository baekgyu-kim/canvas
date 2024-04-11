package canvas.view.palette;

import canvas.controller.Controller;
import canvas.model.observer.Observer;
import canvas.model.shape.Shape;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Rectangle extends JButton implements Observer {


    public Rectangle() {
        setText("Rectangle");

        Controller controller = new Controller();

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        setVisible(true);
    }

    @Override
    public void update(List<Shape> shapes) {
    }
}
