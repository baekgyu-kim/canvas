package canvas.view.palette.paletteButton.paletteButtons;

import canvas.controller.Controller;
import canvas.shape.LineShape;
import canvas.view.palette.paletteButton.PaletteButton;


import java.awt.*;

public class LineButton extends PaletteButton {
    public LineButton(Controller controller, int seq) {
        super(controller, seq);
        this.controller = controller;
        this.seq = seq;
        initializeButton("Line");
        createShape();
    }

    @Override
    public void createShape() {
        addActionListener(e -> {
            int id = seq;int xPos = 350; int yPos = 250; int width = 100; int height = 100; Color color = Color.green; int opacity = 50;int zOrder = seq; boolean shadow = false;boolean frame =false;
            LineShape lineShape = new LineShape(id, xPos, yPos, width, height, color, opacity, zOrder, shadow, frame);
            controller.createShape(lineShape);
        });

    }
}
