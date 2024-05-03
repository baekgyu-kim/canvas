package canvas.view.preferences.preferenceButton;

import javax.swing.*;

public abstract class PreferenceButton extends JButton {
    public void initializeButton(String text){
        setText(text);
        setVisible(true);
    };

    public abstract void changePreference();
}
