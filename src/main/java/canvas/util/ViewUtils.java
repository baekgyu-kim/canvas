package canvas.util;

import javax.swing.*;
import java.awt.*;

public class ViewUtils {
    @SafeVarargs
    public static <T extends JButton> JPanel createCategoryPanel(String title, T... buttons) {
        JPanel panel = getPanel();
        JLabel label = new JLabel(title);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("SansSerif", Font.BOLD, 16));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(label);
        panel.add(Box.createVerticalStrut(10));

        for (T button : buttons) {
            panel.add(button);
            panel.add(Box.createVerticalStrut(10));
        }

        return panel;
    }

    private static JPanel getPanel() {
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
