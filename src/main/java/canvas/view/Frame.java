package canvas.view;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame{
    public Frame() {
        int frame_width = 1300;
        int frame_height = frame_width * 3/5;


        setSize(frame_width, frame_height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        add(new JLabel(" "), BorderLayout.NORTH);
        add(new Palette(), BorderLayout.WEST);
        add(new WhiteCanvas(),BorderLayout.CENTER);
        add(new Preferences(), BorderLayout.EAST);
        add(new JLabel(" "), BorderLayout.SOUTH);

        setVisible(true);
    }
}
