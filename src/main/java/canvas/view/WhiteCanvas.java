package canvas.view;

import canvas.controller.Controller;
import canvas.model.observer.Observer;
import canvas.model.shape.Shape;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class WhiteCanvas extends JPanel implements Observer {
    Controller controller;
    public WhiteCanvas(Controller controller) {
        this.controller = controller;
        setBackground(Color.white);
        setVisible(true);
    }

    @Override
    public void update(List<Shape> shapes) {
        // 여기에 인자로 들어온 shapes 리스트로 White Canvas 화면 그리는 코드 구현
        System.out.println(shapes.get(0).getColor());
    }
}
