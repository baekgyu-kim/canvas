package canvas.view.paletteButton;

import canvas.controller.Controller;
import canvas.dto.ShapeDto;
import canvas.enums.ShapeType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StarButton extends JButton implements PaletteButtonInterface{
    Controller controller;
    int seq;
    public StarButton(Controller controller, int seq) {
        this.controller = controller;
        this.seq = seq;
        initializeButton("Star");
        addAction(controller, seq);
    }
    @Override
    public void addAction(Controller controller, int seq) {
        addActionListener(e -> {
            ShapeDto dto = new ShapeDto(seq, ShapeType.star, 60, 130, 100, 100, new Color(0, 100, 0), 50, seq, false, false);
            controller.createShape(dto);
        });
    }

    @Override
    public void initializeButton(String text) {
        setText(text);
        setVisible(true);
    }
}
