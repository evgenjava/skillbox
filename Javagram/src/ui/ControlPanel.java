package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel {
    private JPanel rootPanel;
    private JButton btnDown;
    private JButton btnClose;

    public ControlPanel() {
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Container frame = btnClose.getParent();
                do
                    frame = frame.getParent();
                while (!(frame instanceof JFrame));
                ((JFrame) frame).dispose();

            }
        });
        btnDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Container frame = btnDown.getParent();
                do
                    frame = frame.getParent();
                while (!(frame instanceof JFrame));
                ((JFrame) frame).setState(JFrame.ICONIFIED);
            }
        });
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        rootPanel = new JPanel();
        rootPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 0));
        rootPanel.setEnabled(false);
        btnDown = new JButton();
        btnDown.setMaximumSize(new Dimension(40, 26));
        btnDown.setMinimumSize(new Dimension(40, 26));
        btnDown.setPreferredSize(new Dimension(40, 26));
        btnDown.setText("-");
        rootPanel.add(btnDown);
        btnClose = new JButton();
        btnClose.setMaximumSize(new Dimension(45, 26));
        btnClose.setMinimumSize(new Dimension(45, 26));
        btnClose.setOpaque(false);
        btnClose.setPreferredSize(new Dimension(45, 26));
        btnClose.setText("x");
        rootPanel.add(btnClose);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return rootPanel;
    }
}
