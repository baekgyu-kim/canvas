package canvas.view.palette;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Star extends JButton {


    public Star() {
        setText("Star");

        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(e);
            }
        });

        setVisible(true);
    }
}
