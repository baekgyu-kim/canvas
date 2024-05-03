package canvas.view.palette.paletteButton.paletteButtons;

import canvas.controller.Controller;
import canvas.factory.shape.RectangleShape;
import canvas.view.palette.paletteButton.PaletteButton;


import java.awt.*;

public class RectangleButton extends PaletteButton {
    Controller controller;
    int seq;
    public RectangleButton(Controller controller, int seq) {
        this.controller = controller;
        this.seq = seq;
        initializeButton("Rectangle");
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
            RectangleShape rectangleShape = new RectangleShape(id, xPos, yPos, width, height, color, opacity, zOrder, shadow, frame);
            controller.createShape(rectangleShape);
        });

    }
}