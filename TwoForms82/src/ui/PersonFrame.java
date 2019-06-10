package ui;

import javax.swing.*;
import java.awt.*;

public class PersonFrame extends JFrame {

    public static final int WIDTH = 400;
    public static final int HEIGHT = 150;

    private FormFIO formFIO;
    private FormFIOCompact formFIOCompact;

    public PersonFrame() {

        formFIO = new FormFIO();
        formFIOCompact = new FormFIOCompact();
        formFIO.addChangeListener((e) -> changePanel(formFIOCompact));
        formFIOCompact.addChangeListener((e) -> changePanel(formFIO));
        setContentPane(formFIO);
        setSize(WIDTH, HEIGHT);
        setLocationByPlatform(true);
        setTitle("Персональные данные");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void changePanel(Container panel) {
        setContentPane(panel);
        revalidate();
    }
}
