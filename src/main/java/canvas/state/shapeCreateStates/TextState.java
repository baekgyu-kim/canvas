package canvas.state.shapeCreateStates;

import canvas.controller.Controller;
import canvas.model.shape.ShapeAbstractClass;
import canvas.model.shape.shapes.TextShape;
import canvas.state.StateAbstractClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class TextState extends StateAbstractClass {

    public TextState(Controller controller, int seq) {
        super(controller, seq);
    }

    @Override
    public void handleMouseClick(MouseEvent e, ArrayList<ShapeAbstractClass> allShapes) {
        // 다이얼로그를 통해 텍스트 입력 받기
        String text = JOptionPane.showInputDialog(null, "Enter text for the text box:", "Text Box Input", JOptionPane.PLAIN_MESSAGE);
        if (text == null || text.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Text cannot be empty.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else {
            int id = allShapes.size();
            int xPos = e.getX();
            int yPos = e.getY();
            int width = 200;
            int height = 50;
            Color color = Color.black;
            int opacity = 100;
            boolean shadow = false;
            boolean frame = false;
            TextShape textShape = new TextShape(id, xPos, yPos, width, height, color, opacity, shadow, frame, text);
            controller.createShape(textShape);
        }
    }

    @Override
    public void activateState() {
        System.out.println("Text State activated: Click to create a text box.");
    }

    @Override
    public void deactivateState() {
        System.out.println("Text State deactivated.");
    }
}