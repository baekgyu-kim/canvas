package canvas.view;

import canvas.controller.Controller;
import canvas.view.WhiteCanvas.WhiteCanvas;
import canvas.view.palette.Palette;
import canvas.view.property.Property;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    private static final int FRAME_WIDTH = 1300;
    private static final int FRAME_HEIGHT = FRAME_WIDTH * 3 / 5;

    private Palette palette;
    private WhiteCanvas whiteCanvas;
    private Property property;

    public Frame(Controller controller) {
        super("Canvas Application");
        initializeComponents(controller);
        setupFrame();
        addComponents();
    }

    private void initializeComponents(Controller controller) {
        palette = new Palette(controller, 0);
        whiteCanvas = new WhiteCanvas(controller);
        property = new Property(controller);
        controller.registerObserver(whiteCanvas);
    }

    private void setupFrame() {
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
    }

    private void addComponents() {
        add(new JLabel(" "), BorderLayout.NORTH);
        add(palette, BorderLayout.WEST);
        add(whiteCanvas, BorderLayout.CENTER);
        add(property, BorderLayout.EAST);
        add(new JLabel(" "), BorderLayout.SOUTH);
        setVisible(true);
    }
}
