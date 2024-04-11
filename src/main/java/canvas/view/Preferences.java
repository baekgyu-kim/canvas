package canvas.view;

import canvas.controller.Controller;
import canvas.model.observer.Observer;
import canvas.model.shape.Shape;
import canvas.view.preferences.color;
import canvas.view.preferences.height;
import canvas.view.preferences.width;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Preferences extends JPanel implements Observer {
    Controller controller;
    public Preferences(Controller controller) {
        this.controller = controller;

        setBackground(Color.red);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(new width());
        add(new height());
        add(new color());

        setVisible(true);
    }
    @Override
    public void update(List<Shape> shapes) {
        // 여기에 인자로 들어온 shapes 리스트로 Preferences 화면 그리는 코드 구현
    }
}
