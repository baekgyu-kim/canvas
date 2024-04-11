package canvas.view;

import canvas.controller.Controller;
import canvas.view.preferences.color;
import canvas.view.preferences.height;
import canvas.view.preferences.width;

import javax.swing.*;
import java.awt.*;

public class Preferences extends JPanel {
    Controller controller;
    public Preferences(Controller controller) {
        this.controller = controller;

        setBackground(Color.red);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(new width());
        add(new height());
        add(new color());

        setVisible(true);
    }
}
