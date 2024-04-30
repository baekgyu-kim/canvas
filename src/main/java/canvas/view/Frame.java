package canvas.view;

import canvas.controller.Controller;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame{

    private Palette palette;
    private WhiteCanvas whiteCanvas;
    private Preferences preferences;
    private int seq;
    public Frame(Controller controller) {
        // initiating class
        this.seq = 0;
        this.palette = new Palette(controller, this.seq);
        this.whiteCanvas = new WhiteCanvas(controller, this.seq);
        this.preferences = new Preferences(controller);

        controller.registerObserver(palette);
        controller.registerObserver(whiteCanvas);
        controller.registerObserver(preferences);

        // setting frame preferences
        int frame_width = 1300;
        int frame_height = frame_width * 3/5;

        setSize(frame_width, frame_height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // adding component
        add(new JLabel(" "), BorderLayout.NORTH);
        add(palette, BorderLayout.WEST);
        add(whiteCanvas,BorderLayout.CENTER);
        add(preferences, BorderLayout.EAST);
        add(new JLabel(" "), BorderLayout.SOUTH);

        setVisible(true);
    }

}
