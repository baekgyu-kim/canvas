package canvas.view;


import canvas.view.palette.Cursor;
import canvas.view.palette.Pen;
import canvas.view.palette.Line;
import canvas.view.palette.Rectangle;
import canvas.view.palette.Ellipse;
import canvas.view.palette.Star;

import javax.swing.*;
import java.awt.*;

public class Palette extends JPanel {
    public Palette() {
        setBackground(Color.blue);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(new Cursor());
        add(new Pen());
        add(new Line());
        add(new Rectangle());
        add(new Ellipse());
        add(new Star());

        setVisible(true);
    }
}
