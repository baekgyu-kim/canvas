package canvas.view;
import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public Frame() {
        int width = 1100;
        JPanel panel = new Panel();

        setPreferredSize(new Dimension(width, width/15*9));
        setSize(width, width/15*9);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setResizable(false);
        add(panel);

        setVisible(true);
    }
}
