package canvas.view.palette.paletteButton.paletteButtons;

import canvas.controller.Controller;
import canvas.model.shape.shapes.TextShape;
import canvas.view.palette.paletteButton.PaletteButton;

import javax.swing.*;
import java.awt.*;

public class TextButton extends PaletteButton {
    public TextButton(Controller controller, int seq) {
        super(controller, seq);
        this.controller = controller;
        this.seq = seq;
        initializeButton("Text Box");
        createShape();
    }

    @Override
    public void createShape() {
        addActionListener(e -> {
            // 다이얼로그를 통해 텍스트 입력 받기
            String text = JOptionPane.showInputDialog(null, "Enter text for the text box:", "Text Box Input", JOptionPane.PLAIN_MESSAGE);
            if (text == null || text.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Text cannot be empty.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }else {
                int id = seq;
                int xPos = 400;
                int yPos = 250;
                int width = 200;
                int height = 50;
                Color color = Color.black;
                int opacity = 100;
                boolean shadow = false;
                boolean frame = false;
                TextShape textShape = new TextShape(id, xPos, yPos, width, height, color, opacity, shadow, frame, text);
                controller.createShape(textShape);
            }
        });
    }
}
