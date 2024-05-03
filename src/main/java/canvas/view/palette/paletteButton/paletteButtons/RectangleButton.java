package canvas.view.palette.paletteButton.paletteButtons;

import canvas.controller.Controller;
import canvas.factory.shape.RectangleShape;
import canvas.factory.shape.ShapeAbstractClass;
import canvas.factory.shape.composite.ShapeComposite;
import canvas.view.palette.paletteButton.PaletteButton;


import java.awt.*;
import java.util.List;

public class RectangleButton extends PaletteButton {
    public RectangleButton(Controller controller, int seq) {
        super(controller, seq);
        initializeButton("Rectangle");
        createShape();
    }

    @Override
    public void createShape() {
        addActionListener(e -> {
            int id = seq;int xPos = 350; int yPos = 250; int width = 100; int height = 100; Color color = Color.green; int opacity = 50;int zOrder = seq; boolean shadow = false;boolean frame =false;
            RectangleShape rectangleShape = new RectangleShape(id, xPos, yPos, width, height, color, opacity, zOrder, shadow, frame);
            controller.createShape(rectangleShape);
        });

    }
}
