package canvas.view.property;

import canvas.controller.Controller;
import canvas.model.shape.composite.ShapeComposite;
import canvas.view.property.propertyButton.PropertyButton;
import canvas.view.property.propertyButton.propertyButtons.*;

import javax.swing.*;

public class Property extends JPanel  {
    Controller controller;
    private ShapeComposite shapeComposite;
    private PropertyButton moveButton;
    private PropertyButton resizeButton;
    private PropertyButton colorButton;
    private PropertyButton bringFrontButton;
    private PropertyButton sendBackButton;


    public Property(Controller controller) {
        this.controller = controller;
        initComponents();
        registerButtonsAsObserver();
        setBackground(java.awt.Color.red);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        addComponents();
        setVisible(true);
    }
    private void initComponents() {
        this.resizeButton = new ResizeButton(this.shapeComposite, this.controller);
        this.colorButton = new ColorButton(this.shapeComposite, this.controller);
        this.bringFrontButton = new BringFrontButton(this.shapeComposite, this.controller);
        this.sendBackButton = new SendBackButton(this.shapeComposite, this.controller);


    }
    private void registerButtonsAsObserver(){
        controller.registerObserver(this.resizeButton);
        controller.registerObserver(this.colorButton);
        controller.registerObserver(this.bringFrontButton);
        controller.registerObserver(this.sendBackButton);
    }
    private void addComponents() {
        add(new JLabel("Resize Button"));
        add(this.resizeButton);
        add(this.colorButton);
        add(this.bringFrontButton);
        add(this.sendBackButton);
    }
}
