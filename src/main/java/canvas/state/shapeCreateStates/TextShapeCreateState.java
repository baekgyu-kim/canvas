package canvas.state.shapeCreateStates;

import canvas.controller.Controller;
import canvas.factory.shape.TextCreator;
import canvas.model.shape.ShapeAbstractClass;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class TextShapeCreateState extends ShapeCreateStateAbstractClass {
    private Controller controller;
    public TextShapeCreateState() {
        super();
        this.shapeCreatorInterface = new TextCreator();
        this.controller = Controller.getInstance();
    }

    @Override
    public void handleMouseClick(MouseEvent e, ArrayList<ShapeAbstractClass> allShapes) {
        String text = JOptionPane.showInputDialog(null, "Enter text for the text box:", "Text Box Input", JOptionPane.PLAIN_MESSAGE);
        if (text == null || text.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Text cannot be empty.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else {
            int id = allShapes.size();
            ShapeAbstractClass textShape = shapeCreatorInterface.createShape(e, id, text);
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