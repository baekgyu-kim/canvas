package canvas.view;


import canvas.controller.Controller;
import canvas.view.palette.Cursor;
import canvas.view.palette.Line;
import canvas.view.palette.Rectangle;
import canvas.view.palette.Ellipse;
import canvas.view.palette.Star;

import javax.swing.*;
import java.awt.*;

public class Palette extends JPanel {
    Controller controller;
    private int seq;

    public Palette(Controller controller) {
        this.controller = controller;

        setBackground(Color.blue);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new Cursor());
        add(new Line());
        add(new Rectangle(controller));
        add(new Ellipse());
        add(new Star());
        setVisible(true);
    }
}
