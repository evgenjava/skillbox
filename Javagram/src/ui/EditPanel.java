package ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class EditPanel extends JPanel {

    public static final int HEIGHT = 46;

    public EditPanel(int width) {
        setPreferredSize(new Dimension(width, HEIGHT));
        setMaximumSize(new Dimension(width, HEIGHT));
        setMinimumSize(new Dimension(width, HEIGHT));
        setOpaque(false);
        setLayout(new BorderLayout());
        Border border = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE);
        setBorder(border);

    }

    public void addIcon(JComponent icon) {
        add(icon, BorderLayout.WEST);
    }

    public void addTextField(JComponent textField) {
        add(textField, BorderLayout.CENTER);
    }
}
