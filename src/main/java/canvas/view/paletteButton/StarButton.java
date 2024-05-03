package canvas.view.paletteButton;

import canvas.controller.Controller;
import canvas.factory.shape.StarShape;


import java.awt.*;

public class StarButton extends PaletteButton {
    Controller controller;
    int seq;
    public StarButton(Controller controller, int seq) {
        this.controller = controller;
        this.seq = seq;
        initializeButton("Star");
        createShape();
    }

    @Override
    public void initializeButton(String text) {
        setText(text);
        setVisible(true);
    }
    @Override
    public void createShape() {
        addActionListener(e -> {
            int id = seq;int xPos = 50; int yPos = 120; int width = 100; int height = 100; Color color = Color.green; int opacity = 50;int zOrder = seq; boolean shadow = false;boolean frame =false;
            StarShape starShape = new StarShape(id, xPos, yPos, width, height, color, opacity, zOrder, shadow, frame);
            controller.createShape(starShape);
        });

    }
}
