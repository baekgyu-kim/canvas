package canvas.model.shape;

import java.awt.*;

public interface ShapeInterface {
    void draw(Graphics g);
    void changeColor(Color color);
    void changeMove(int newX, int newY);
    void changeSize(int newWidth, int newHeight);
    void changeOpacity(int opacity);
    void changeShade(boolean hasShade);
    void changeFrame(boolean hasFrame);

    int getId();
    int getXPos();
    int getYPos();
    int getWidth();
    int getHeight();
    Color getColor();
    int getOpacity();
    boolean getShadow();
    boolean getFrame();
    String getText();
}
