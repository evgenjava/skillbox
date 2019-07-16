package ui;

import javax.swing.*;
import java.awt.*;

public class BlackPanel extends JPanel {

    public static final int WIDTH = 905;
    public static final int HEIGHT = 630;


    public BlackPanel() {
        setBackground(Color.BLACK);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setMaximumSize(new Dimension(WIDTH, HEIGHT));
        setMinimumSize(new Dimension(WIDTH, HEIGHT));

    }

    public void addComponent(JComponent component, int deltaY){
        add(Box.createRigidArea(new Dimension(0, deltaY)));
        component.setAlignmentX(Box.CENTER_ALIGNMENT);
        add(component);
    }
}
