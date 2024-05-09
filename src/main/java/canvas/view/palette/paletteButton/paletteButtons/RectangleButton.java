package canvas.view.palette.paletteButton.paletteButtons;

import canvas.controller.Controller;
import canvas.model.shape.shapes.RectangleShape;
import canvas.view.palette.paletteButton.PaletteButton;


import java.awt.*;

public class RectangleButton extends PaletteButton {
    public RectangleButton(Controller controller, int seq) {
        super(controller, seq);
        initializeButton("Rectangle");
        createShape();
    }

    @Override
    public void createShape() {
        addActionListener(e -> {
            int id = seq;int xPos = 200; int yPos = 250; int width = 100; int height = 100; Color color = Color.green; int opacity = 100;boolean shadow = false;boolean frame =false;
            RectangleShape rectangleShape = new RectangleShape(id, xPos, yPos, width, height, color, opacity, shadow, frame);
            controller.createShape(rectangleShape);
        });

    }
}
