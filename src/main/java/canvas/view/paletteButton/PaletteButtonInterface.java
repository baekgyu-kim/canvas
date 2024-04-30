package canvas.view.paletteButton;

import canvas.controller.Controller;

public interface PaletteButtonInterface {
    void addAction(Controller controller, int seq);
    void initializeButton(String text);
}
