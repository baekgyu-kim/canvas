package canvas.view;
import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    public Panel() {
        setBackground(Color.BLUE);
        setLayout(null);
        setSize(200, 150);
        add(new JButton("button"));

        setVisible(true);
    }
}
