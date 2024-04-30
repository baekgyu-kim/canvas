package canvas.view.palette;

import canvas.controller.Controller;
import canvas.dto.ShapeDto;
import canvas.enums.ShapeType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rectangle extends JButton {

    Controller controller;


    public Rectangle(Controller controller, int seq)

    {
        this.controller = controller;
        setText("Rectangle");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShapeDto dto = new ShapeDto(
                        seq,
                        ShapeType.rectangle,
                        12,
                        20,
                        100,
                        100,
                        Color.blue,
                        50,
                        seq,
                        false,
                        false
                );
                controller.createShape(dto);
            }
        });

        setVisible(true);
    }
}
