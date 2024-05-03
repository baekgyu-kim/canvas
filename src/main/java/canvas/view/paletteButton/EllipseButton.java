package canvas.view.paletteButton;

import canvas.controller.Controller;
import canvas.factory.shape.EllipseShape;


import java.awt.*;

public class EllipseButton extends PaletteButton {
    Controller controller;
    int seq;
    public EllipseButton(Controller controller, int seq) {
        this.controller = controller;
        this.seq = seq;
        initializeButton("Ellipse");
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
            EllipseShape ellipseShape = new EllipseShape(id, xPos, yPos, width, height, color, opacity, zOrder, shadow, frame);
            controller.createShape(ellipseShape);
        });

    }
}
