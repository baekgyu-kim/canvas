package canvas.view;

import canvas.controller.Controller;
import canvas.view.whiteCanvas.WhiteCanvas;
import canvas.view.palette.Palette;
import canvas.view.property.Property;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Frame extends JFrame {
    private static final int FRAME_WIDTH = 1300;
    private static final int FRAME_HEIGHT = FRAME_WIDTH * 3 / 5;

    private Palette palette;
    private WhiteCanvas whiteCanvas;
    private Property property;

    public Frame(Controller controller) {
        super("Canvas Application");
        initializeLookAndFeel();
        initializeComponents(controller);
        setupFrame();
        addComponents();
    }

    private void initializeLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initializeComponents(Controller controller) {
        palette = new Palette(controller, 0);
        whiteCanvas = new WhiteCanvas(controller);
        property = new Property(controller);


        palette.setBackground(new Color(245, 245, 245));
        palette.setBorder(new EmptyBorder(10, 10, 10, 10));

        whiteCanvas.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        whiteCanvas.setBackground(Color.WHITE);

        property.setBackground(new Color(245, 245, 245));
        property.setBorder(new EmptyBorder(10, 10, 10, 10));
    }

    private void setupFrame() {
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
    }

    private void addComponents() {
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(new JLabel(" "), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 0.2;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        add(palette, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.6;
        add(whiteCanvas, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.weightx = 0.2;
        add(property, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(new JLabel(" "), gbc);

        setVisible(true);
    }
}
