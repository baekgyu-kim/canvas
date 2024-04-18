package canvas.view.palette;

import canvas.controller.Controller;
import canvas.dto.ShapeDto;
import canvas.enums.ShapeType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Star extends JButton {


    public Star(Controller controller) {
        setText("Star");

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShapeDto dto = new ShapeDto(0, ShapeType.star, 300, 40, 100, 100, Color.black, 50, 0, false, false);
                controller.createShape(dto);
            }
        });

        setVisible(true);
    }
}
