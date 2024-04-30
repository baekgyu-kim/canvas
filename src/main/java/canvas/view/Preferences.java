package canvas.view;

import canvas.controller.Controller;
import canvas.model.observer.Observer;
import canvas.model.shape.Shape;
import canvas.view.preferences.*;

import javax.swing.*;
import java.util.List;

public class Preferences extends JPanel implements Observer {
    Controller controller;

    private Width width;
    private Height height;
    private Color color;
    private BringToFront bringToFront;
    private SendToBack sendToBack;
    public Preferences(Controller controller) {
        this.controller = controller;
        this.width = new Width();
        this.height = new Height();
        this.color = new Color();
        this.bringToFront = new BringToFront();
        this.sendToBack = new SendToBack();

        setBackground(java.awt.Color.red);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(width);
        add(height);
        add(color);
        add(bringToFront);
        add(sendToBack);


        setVisible(true);
    }
    @Override
    public void update(List<Shape> shapes) {
        // 여기에 인자로 들어온 shapes 리스트로 Preferences 화면 그리는 코드 구현
    }
}