package canvas.view.palette;

import canvas.controller.Controller;
import canvas.dto.ShapeDto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rectangle extends JButton{

    Controller controller;


    public Rectangle(Controller controller) {
        this.controller = controller;
        setText("Rectangle");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShapeDto dto = new ShapeDto(0, 10, 10, 100, 100, Color.black, 50, 0, false, false);
                controller.createShape(dto);
            }
        });

        setVisible(true);
    }
}
