package canvas.view;

import canvas.model.observer.Observer;
import canvas.model.shape.Shape;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class WhiteCanvas extends JPanel implements Observer {
    public WhiteCanvas() {
        setBackground(Color.white);

        setVisible(true);
    }

    @Override
    public void update(List<Shape> shapes) {

    }
}
