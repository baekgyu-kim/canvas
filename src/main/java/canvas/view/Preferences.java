package canvas.view;

import canvas.view.preferences.color;
import canvas.view.preferences.height;
import canvas.view.preferences.width;

import javax.swing.*;
import java.awt.*;

public class Preferences extends JPanel {
    public Preferences() {
        setBackground(Color.red);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(new width());
        add(new height());
        add(new color());

        setVisible(true);
    }
}
