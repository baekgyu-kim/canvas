package canvas.view.property;

import canvas.controller.Controller;
import canvas.model.shape.composite.ShapeComposite;
import canvas.view.property.propertyButton.PropertyButton;
import canvas.view.property.propertyButton.propertyButtons.*;
import canvas.view.property.propertyTextField.PropertyTextField;
import canvas.view.property.propertyTextField.propertyTextFields.*;

import javax.swing.*;

public class Property extends JPanel  {
    Controller controller;
    private ShapeComposite shapeComposite;

    private PropertyButton colorButton;
    private PropertyButton bringFrontButton;
    private PropertyButton sendBackButton;

    private PropertyTextField moveYTextField;
    private PropertyTextField moveXTextField;
    private PropertyTextField widthTextField;
    private PropertyTextField heightTextField;
    private PropertyTextField colorTextField;

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
        this.colorButton = new ColorButton(this.shapeComposite, this.controller);
        this.bringFrontButton = new BringFrontButton(this.shapeComposite, this.controller);
        this.sendBackButton = new SendBackButton(this.shapeComposite, this.controller);

        this.moveXTextField = new MoveXTextField(this.shapeComposite, 1);
        this.moveYTextField = new MoveYTextField(this.shapeComposite, 1);
        this.widthTextField = new WidthTextField(this.shapeComposite, 1);
        this.heightTextField = new HeightTextField(this.shapeComposite, 1);
        this.colorTextField = new ColorTextField(this.shapeComposite, 1);

    }
    private void registerButtonsAsObserver(){
        controller.registerObserver(this.colorButton);
        controller.registerObserver(this.bringFrontButton);
        controller.registerObserver(this.sendBackButton);
    }
    private void addComponents() {
        add(new JLabel("X 좌표"));
        add(this.moveYTextField);
        add(new JLabel("Y 좌표"));
        add(this.moveXTextField);

        add(new JLabel("너비"));
        add(this.widthTextField);
        add(new JLabel("높이"));
        add(this.heightTextField);

        add(this.colorButton);

        add(this.bringFrontButton);
        add(this.sendBackButton);
    }
}
