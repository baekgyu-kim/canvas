package canvas.view.property;

import canvas.controller.Controller;
import canvas.model.shape.composite.ShapeComposite;
import canvas.view.property.propertyButton.PropertyButton;
import canvas.view.property.propertyButton.propertyButtons.*;

import javax.swing.*;
import java.awt.*;

public class Property extends JPanel {
    Controller controller;
    private ShapeComposite shapeComposite;
    private PropertyButton moveButton;
    private PropertyButton resizeButton;
    private PropertyButton colorButton;
    private PropertyButton opacityButton;
    private PropertyButton shadowButton;
    private PropertyButton frameButton;
    private PropertyButton bringFrontButton;
    private PropertyButton sendBackButton;

    public Property(Controller controller) {
        this.controller = controller;
        initComponents();
        registerButtonsAsObserver();
        setBackground(new Color(45, 45, 48));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        addComponents();
        setVisible(true);
    }

    private void initComponents() {
        this.moveButton = createStyledButton(new MoveButton(this.shapeComposite, this.controller));
        this.resizeButton = createStyledButton(new ResizeButton(this.shapeComposite, this.controller));
        this.colorButton = createStyledButton(new ColorButton(this.shapeComposite, this.controller));
        this.opacityButton = createStyledButton(new OpacityButton(this.shapeComposite, this.controller));
        this.shadowButton = createStyledButton(new ShadowButton(this.shapeComposite, this.controller));
        this.frameButton = createStyledButton(new FrameButton(this.shapeComposite, this.controller));
        this.bringFrontButton = createStyledButton(new BringFrontButton(this.shapeComposite, this.controller));
        this.sendBackButton = createStyledButton(new SendBackButton(this.shapeComposite, this.controller));
    }

    private PropertyButton createStyledButton(PropertyButton button) {
        JButton btn = (JButton) button;
        btn.setBackground(new Color(75, 110, 175));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("SansSerif", Font.BOLD, 14));
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.setPreferredSize(new Dimension(150, 40));
        btn.setMaximumSize(new Dimension(150, 40));
        return button;
    }

    private void registerButtonsAsObserver() {
        controller.registerObserver(this.moveButton);
        controller.registerObserver(this.resizeButton);
        controller.registerObserver(this.colorButton);
        controller.registerObserver(this.opacityButton);
        controller.registerObserver(this.shadowButton);
        controller.registerObserver(this.frameButton);
        controller.registerObserver(this.bringFrontButton);
        controller.registerObserver(this.sendBackButton);
    }

    private void addComponents() {
        add(createCategoryPanel("Shape Modification", this.moveButton, this.resizeButton, this.colorButton, this.opacityButton));
        add(Box.createVerticalStrut(10));
        add(createCategoryPanel("Effects", this.shadowButton, this.frameButton));
        add(Box.createVerticalStrut(10));
        add(createCategoryPanel("Z-Order", this.bringFrontButton, this.sendBackButton));
        add(Box.createVerticalStrut(10));
    }

    private JPanel createCategoryPanel(String title, PropertyButton... buttons) {
        JPanel panel = getPanel();
        JLabel label = new JLabel(title);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("SansSerif", Font.BOLD, 16));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(label);
        panel.add(Box.createVerticalStrut(10));

        for (PropertyButton button : buttons) {
            panel.add(button);
            panel.add(Box.createVerticalStrut(10));
        }

        return panel;
    }

    private JPanel getPanel() {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
                g2d.setColor(new Color(60, 63, 65));
                g2d.fillRect(0, 0, getWidth(), getHeight());
                g2d.dispose();
            }
        };
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        return panel;
    }
}
