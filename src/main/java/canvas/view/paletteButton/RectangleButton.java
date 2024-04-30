package canvas.view.paletteButton;

import canvas.controller.Controller;
import canvas.dto.ShapeDto;
import canvas.enums.ShapeType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RectangleButton extends JButton implements PaletteButtonInterface{

    Controller controller;
    int seq;


    public RectangleButton(Controller controller, int seq) {
        this.controller = controller;
        this.seq = seq;
        initializeButton("Rectangle");
        addAction(controller, seq);
    }
    @Override
    public void addAction(Controller controller, int seq) {
        addActionListener(e -> {
            ShapeDto dto = new ShapeDto(seq, ShapeType.rectangle, 40, 110, 100, 100, Color.yellow, 50, 1, false, false);
            controller.createShape(dto);
        });
    }

    @Override
    public void initializeButton(String text) {
        setText(text);
        setVisible(true);
    }
}
