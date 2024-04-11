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
        // shapes가 들어오면 shapes안에 도형이 몇개 있는지 당연히 알 수 있음.
        // 그거 갖고 id 넣으면 됨. (예를 들어 2개 있으면 다음 생성시 3번으로)
        // 일단 현재는 z-order를 id 값과 같은 값으로 넣어두고 나중에 구현
        System.out.println(shapes.get(0).getShapeType());
        System.out.println(shapes.size());
    }
}
