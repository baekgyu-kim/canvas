package canvas.view.preferences;

import canvas.controller.Controller;
import canvas.factory.shape.ShapeAbstractClass;
import canvas.factory.shape.composite.ShapeComposite;
import canvas.observer.Observer;
import canvas.view.palette.paletteButton.paletteButtons.*;
import canvas.view.preferences.preferenceButton.PreferenceButton;
import canvas.view.preferences.preferenceButton.preferenceButtons.*;

import javax.swing.*;
import java.util.List;

public class Preferences extends JPanel implements Observer {
    Controller controller;

    private PreferenceButton widthButton;
    private PreferenceButton heightButton;
    private PreferenceButton colorButton;
    private PreferenceButton bringFrontButton;
    private PreferenceButton sendBackButton;

    private ShapeComposite shapeComposite;


    public Preferences(Controller controller) {
        this.controller = controller;
        initComponents();
        setBackground(java.awt.Color.red);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        addComponents();
        setVisible(true);
    }
    private void initComponents() {
        this.widthButton = new WidthButton(this.shapeComposite);
        this.heightButton = new HeightButton(this.shapeComposite);
        this.colorButton = new ColorButton(this.shapeComposite);
        this.bringFrontButton = new BringFrontButton(this.shapeComposite);
        this.sendBackButton = new SendBackButton(this.shapeComposite);
    }
    private void addComponents() {
        add(this.widthButton);
        add(this.heightButton);
        add(this.colorButton);
        add(this.bringFrontButton);
        add(this.sendBackButton);
    }
    @Override
    public void updateAllShapes(List<ShapeAbstractClass> shapes) {
        // 여기서는 아무것도 하지 않음.
    }

    @Override
    public void updateClickedShapes(ShapeComposite shapeComposite) {
        this.shapeComposite = shapeComposite;
        initComponents();
        removeAll();
        addComponents();
        revalidate();
        repaint();
    }
}
