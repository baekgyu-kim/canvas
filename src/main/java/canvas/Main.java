package canvas;

import canvas.controller.Controller;
import canvas.model.Model;
import canvas.view.Frame;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);
        Frame frame = new Frame(controller);
    }
}
