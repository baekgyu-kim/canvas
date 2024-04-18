package canvas.view.palette;

import canvas.controller.Controller;
import canvas.dto.ShapeDto;
import canvas.enums.ShapeType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Line extends JButton {
    public Line(Controller controller) {
        setText("Line");

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShapeDto dto = new ShapeDto(0, ShapeType.line, 5, 500, 100, 100, Color.black, 50, 0, false, false);
                controller.createShape(dto);
            }
        });

        setVisible(true);
    }
}
