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

    public Palette(Controller controller, int seq) {
        this.controller = controller;

        setBackground(Color.blue);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(new Cursor(controller));
        add(new Line(controller, seq));
        add(new Rectangle(controller, seq));
        add(new Ellipse(controller, seq));
        add(new Star(controller, seq));

        setVisible(true);
    }

}
