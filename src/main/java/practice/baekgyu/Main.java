package practice.baekgyu;

public class Main {
    public static void main(String[] args) {
        PracticeButton practiceButton = new PracticeButton();
        PracticePanel practicePanel = new PracticePanel(practiceButton);
        PracticeFrame practiceFrame = new PracticeFrame(practicePanel);

        practiceFrame.display();
    }
}
