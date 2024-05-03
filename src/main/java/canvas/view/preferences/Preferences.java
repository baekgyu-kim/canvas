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

public class Preferences extends JPanel  {
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
        registerButtonsAsObserver();
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
    private void registerButtonsAsObserver(){
        controller.registerObserver(this.widthButton);
        controller.registerObserver(this.heightButton);
        controller.registerObserver(this.colorButton);
        controller.registerObserver(this.bringFrontButton);
        controller.registerObserver(this.sendBackButton);
    }
    private void addComponents() {
        add(this.widthButton);
        add(this.heightButton);
        add(this.colorButton);
        add(this.bringFrontButton);
        add(this.sendBackButton);
    }
}
