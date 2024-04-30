package canvas.view.paletteButton;

import canvas.controller.Controller;
import canvas.dto.ShapeDto;
import canvas.enums.ShapeType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LineButton extends JButton implements PaletteButtonInterface{
    Controller controller;
    int seq;
    public LineButton(Controller controller, int seq) {
        this.controller = controller;
        this.seq = seq;
        initializeButton("Line");
        addAction(controller, seq);
    }
    @Override
    public void addAction(Controller controller, int seq) {
        addActionListener(e -> {
            ShapeDto dto = new ShapeDto(seq, ShapeType.line, 5, 500, 100, 100, Color.black, 50, seq, false, false);
            controller.createShape(dto);
        });
    }

    @Override
    public void initializeButton(String text) {
        setText(text);
        setVisible(true);
    }
}
