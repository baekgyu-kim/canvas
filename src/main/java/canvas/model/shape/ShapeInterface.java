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

    public int getId();

    public int getXPos();

    public int getYPos();

    public int getWidth();

    public int getHeight();

    public Color getColor();

    public int getOpacity();

    public boolean getShadow();

    public boolean getFrame();

    public String getText();
}
