package canvas.view.preferences;

import canvas.controller.Controller;
import canvas.factory.shape.ShapeAbstractClass;
import canvas.factory.shape.composite.ShapeComposite;
import canvas.observer.Observer;
import canvas.view.preferences.preferenceButton.preferenceButtons.*;

import javax.swing.*;
import java.util.List;

public class Preferences extends JPanel implements Observer {
    Controller controller;

    private WidthButton widthButton;
    private HeightButton heightButton;
    private ColorButton colorButton;
    private BringFrontButton bringFrontButton;
    private SendBackButton sendBackButton;
    public Preferences(Controller controller) {
        this.controller = controller;
        this.widthButton = new WidthButton();
        this.heightButton = new HeightButton();
        this.colorButton = new ColorButton();
        this.bringFrontButton = new BringFrontButton();
        this.sendBackButton = new SendBackButton();

        setBackground(java.awt.Color.red);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(widthButton);
        add(heightButton);
        add(colorButton);
        add(bringFrontButton);
        add(sendBackButton);


        setVisible(true);
    }
    @Override
    public void updateAllShapes(List<ShapeAbstractClass> shapes) {
        // 여기에 인자로 들어온 shapes 리스트로 Preferences 화면 그리는 코드 구현
    }

    @Override
    public void updateClickedShapes(ShapeComposite shapeComposite) {

    }
}
