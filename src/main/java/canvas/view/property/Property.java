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
        this.moveButton = new MoveButton(this.shapeComposite, this.controller);
        this.resizeButton = new ResizeButton(this.shapeComposite, this.controller);
        this.colorButton = new ColorButton(this.shapeComposite, this.controller);
        this.bringFrontButton = new BringFrontButton(this.shapeComposite, this.controller);
        this.sendBackButton = new SendBackButton(this.shapeComposite, this.controller);


    }
    private void registerButtonsAsObserver(){
        controller.registerObserver(this.moveButton);
        controller.registerObserver(this.resizeButton);
        controller.registerObserver(this.colorButton);
        controller.registerObserver(this.bringFrontButton);
        controller.registerObserver(this.sendBackButton);
    }
    private void addComponents() {
        add(new JLabel("도형 이동 버튼"));
        add(this.moveButton);
        add(new JLabel("도형 resize 버튼"));
        add(this.resizeButton);
        add(new JLabel("도형 색 바꾸기 버튼"));
        add(this.colorButton);
        add(new JLabel("맨 앞으로 가져오기 버튼 "));
        add(this.bringFrontButton);
        add(new JLabel("맨 뒤로 보내기 버튼 "));
        add(this.sendBackButton);
    }
}
