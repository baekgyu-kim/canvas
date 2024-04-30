package canvas.view.paletteButton;

import canvas.controller.Controller;
import canvas.dto.ShapeDto;
import canvas.enums.ShapeType;

import javax.swing.*;
import java.awt.*;

public class EllipseButton extends JButton implements PaletteButtonInterface{
    Controller controller;
    int seq;
    public EllipseButton(Controller controller, int seq) {
        this.controller = controller;
        this.seq = seq;
        initializeButton("Ellipse");
        addAction(controller, seq);
    }
    @Override
    public void addAction(Controller controller, int seq) {
        addActionListener(e -> {
            ShapeDto dto = new ShapeDto(seq, ShapeType.ellipse, 50, 120, 100, 100, Color.green, 50, seq, false, false);
            controller.createShape(dto);
        });
    }

    @Override
    public void initializeButton(String text) {
        setText(text);
        setVisible(true);
    }
}
