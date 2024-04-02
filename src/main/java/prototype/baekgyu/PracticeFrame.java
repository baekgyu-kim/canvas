package prototype.baekgyu;

import javax.swing.*;

public class PracticeFrame {
    private JFrame frame;

    public PracticeFrame(PracticePanel testPanel) {
        frame = new JFrame("간단한 JFrame 예제");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 500);
        frame.setLocationRelativeTo(null);
        frame.add(testPanel.getPanel());
    }

    public void display() {
        this.frame.setVisible(true);
    }
}
