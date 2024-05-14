package canvas.view.property;

import canvas.controller.Controller;
import canvas.model.shape.composite.ShapeComposite;
import canvas.view.property.propertyButton.PropertyButton;
import canvas.view.property.propertyButton.propertyButtons.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Property extends JPanel {
    Controller controller;
    private ShapeComposite shapeComposite;
    private PropertyButton moveButton;
    private PropertyButton resizeButton;
    private PropertyButton colorButton;
    private PropertyButton opacityButton;
    private PropertyButton shadeButton;
    private PropertyButton frameButton;
    private PropertyButton bringFrontButton;
    private PropertyButton sendBackButton;

    public Property(Controller controller) {
        this.controller = controller;
        initComponents();
        registerButtonsAsObserver();
        setBackground(new Color(60, 63, 65)); // 배경색 변경
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        addComponents();
        setVisible(true);
    }

    private void initComponents() {
        this.moveButton = createStyledButton(new MoveButton(this.shapeComposite, this.controller));
        this.resizeButton = createStyledButton(new ResizeButton(this.shapeComposite, this.controller));
        this.colorButton = createStyledButton(new ColorButton(this.shapeComposite, this.controller));
        this.opacityButton = createStyledButton(new OpacityButton(this.shapeComposite, this.controller));
        this.shadeButton = createStyledButton(new ShadowButton(this.shapeComposite, this.controller));
        this.frameButton = createStyledButton(new FrameButton(this.shapeComposite, this.controller));
        this.bringFrontButton = createStyledButton(new BringFrontButton(this.shapeComposite, this.controller));
        this.sendBackButton = createStyledButton(new SendBackButton(this.shapeComposite, this.controller));
    }

    private PropertyButton createStyledButton(PropertyButton button) {
        JButton btn = (JButton) button;
        btn.setBackground(new Color(75, 110, 175));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Arial", Font.BOLD, 14));
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.setPreferredSize(new Dimension(150, 40)); // 버튼 크기 조정
        btn.setMaximumSize(new Dimension(150, 40)); // 최대 크기 설정
        return button;
    }

    private void registerButtonsAsObserver(){
        controller.registerObserver(this.moveButton);
        controller.registerObserver(this.resizeButton);
        controller.registerObserver(this.colorButton);
        controller.registerObserver(this.opacityButton);
        controller.registerObserver(this.shadeButton);
        controller.registerObserver(this.frameButton);
        controller.registerObserver(this.bringFrontButton);
        controller.registerObserver(this.sendBackButton);
    }

    private void addComponents() {
        add(Box.createVerticalStrut(10)); // 위쪽 간격 추가
        add(this.moveButton);
        add(Box.createVerticalStrut(10)); // 버튼 간 간격 추가
        add(this.resizeButton);
        add(Box.createVerticalStrut(10)); // 버튼 간 간격 추가
        add(this.colorButton);
        add(Box.createVerticalStrut(10)); // 버튼 간 간격 추가
        add(this.opacityButton);
        add(Box.createVerticalStrut(10)); // 버튼 간 간격 추가
        add(this.shadeButton);
        add(Box.createVerticalStrut(10)); // 버튼 간 간격 추가
        add(this.frameButton);
        add(Box.createVerticalStrut(10)); // 버튼 간 간격 추가
        add(this.bringFrontButton);
        add(Box.createVerticalStrut(10)); // 버튼 간 간격 추가
        add(this.sendBackButton);
        add(Box.createVerticalStrut(10)); // 아래쪽 간격 추가
    }
}
