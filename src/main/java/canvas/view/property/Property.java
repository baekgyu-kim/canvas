package canvas.view.property;

import canvas.view.property.propertyButton.PropertyButton;
import canvas.view.property.propertyButton.propertyButtons.*;

import javax.swing.*;
import java.awt.*;

public class Property extends JPanel {
    private PropertyButton moveButton;
    private PropertyButton resizeButton;
    private PropertyButton colorButton;
    private PropertyButton opacityButton;
    private PropertyButton shadowButton;
    private PropertyButton frameButton;
    private PropertyButton bringFrontButton;
    private PropertyButton sendBackButton;

    public Property() {
        initComponents();
        setBackground(new Color(45, 45, 48));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        addComponents();
        setVisible(true);
    }

    private void initComponents() {
        this.moveButton = createStyledButton(new MoveButton());
        this.resizeButton = createStyledButton(new ResizeButton());
        this.colorButton = createStyledButton(new ColorButton());
        this.opacityButton = createStyledButton(new OpacityButton());
        this.shadowButton = createStyledButton(new ShadowButton());
        this.frameButton = createStyledButton(new FrameButton());
        this.bringFrontButton = createStyledButton(new BringFrontButton());
        this.sendBackButton = createStyledButton(new SendBackButton());
    }

    private PropertyButton createStyledButton(PropertyButton button) {
        ((JButton) button).setBackground(new Color(75, 110, 175));
        ((JButton) button).setForeground(Color.WHITE);
        ((JButton) button).setFont(new Font("SansSerif", Font.BOLD, 14));
        ((JButton) button).setFocusPainted(false);
        ((JButton) button).setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        ((JButton) button).setAlignmentX(Component.CENTER_ALIGNMENT);
        ((JButton) button).setPreferredSize(new Dimension(150, 40));
        ((JButton) button).setMaximumSize(new Dimension(150, 40));
        return button;
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
