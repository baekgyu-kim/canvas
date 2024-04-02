package prototype.baekgyu;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PracticeButton {
    private JButton button;

    public PracticeButton() {
        button = new JButton("Click Me");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked!");
            }
        });
    }

    public JButton getButton() {
        return button;
    }
}
