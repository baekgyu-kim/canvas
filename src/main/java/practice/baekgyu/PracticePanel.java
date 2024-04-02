package practice.baekgyu;

import practice.baekgyu.PracticeButton;

import javax.swing.*;

public class PracticePanel {
    private JPanel panel;

    public PracticePanel(PracticeButton practiceButton) {
        panel = new JPanel();
        panel.add(practiceButton.getButton());
    }

    public JPanel getPanel() {
        return panel;
    }
}
