package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class PhoneNumberFrom {
    private JPanel rootPanel;
    private JButton btnClose;
    private JButton btnDown;
    private JPanel pnlControl;
    private JPanel pnlMain;
    private JPanel pnlLogo;
    private JPanel pnlWelcomInput;
    private JTextPane txtWelcomInput;
    private JPanel pnlPhoneNumber;
    private JTextField txtPhoneNumber;
    private JButton btnNext;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
    public PhoneNumberFrom() {

        pnlMain.setLayout(new BoxLayout(pnlMain, BoxLayout.Y_AXIS));
        btnNext.setBackground(new Color(21, 61, 242));
        txtWelcomInput.setAlignmentX(JTextPane.CENTER_ALIGNMENT);
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
