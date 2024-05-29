package canvas.state.shapeCreateStates;

import canvas.factory.shape.shapeFactories.TextCreator;
import canvas.model.shape.ShapeAbstractClass;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class TextShapeCreateState extends ShapeCreateStateAbstractClass {
    public TextShapeCreateState() {
        super();
        this.shapeCreatorInterface = new TextCreator();
    }

    @Override
    public void handleMouseClick(MouseEvent e, ArrayList<ShapeAbstractClass> allShapes) {
        String text = JOptionPane.showInputDialog(null, "Enter text for the text box:", "Text Box Input", JOptionPane.PLAIN_MESSAGE);
        if (text == null || text.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Text cannot be empty.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } else {
            int id = allShapes.size();
            shapeCreatorInterface.createShape(e, id, text);
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