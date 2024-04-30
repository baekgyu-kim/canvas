package canvas.view.palette;

import canvas.controller.Controller;
import canvas.dto.ShapeDto;
import canvas.enums.ShapeType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Line extends JButton {
    public Line(Controller controller, int seq) {
        setText("Line");

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShapeDto dto = new ShapeDto(seq, ShapeType.line, 5, 500, 100, 100, Color.black, 50, seq, false, false);
                controller.createShape(dto);
            }
        });

        setVisible(true);
    }
}
