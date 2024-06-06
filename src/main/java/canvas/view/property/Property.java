package canvas.view.property;

import canvas.view.property.propertyButton.PropertyButton;
import canvas.view.property.propertyButton.propertyButtons.*;

import javax.swing.*;
import java.awt.*;

import static canvas.util.ViewUtils.createCategoryPanel;

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

}
