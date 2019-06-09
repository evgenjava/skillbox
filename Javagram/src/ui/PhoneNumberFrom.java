package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class PhoneNumberFrom {

    private final String welcomInput = "Введите код страны и номер мобильного телефона";
    private JPanel rootPanel;
    private JPanel pnlMain;
    private JPanel pnlLogo;
    private JPanel pnlWelcomInput;
    private JTextPane txtWelcomInput;
    private JPanel pnlPhoneNumber;
    private JTextField txtPhoneNumber;
    private JPanel pnlNext;
    private JButton btnNext;

    private ChangePanel changePanel;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
    public PhoneNumberFrom() {

        pnlMain.setLayout(new BoxLayout(pnlMain, BoxLayout.Y_AXIS));
        btnNext.setBackground(new Color(21, 61, 242));
        txtWelcomInput.setText(welcomInput);

        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (changePanel != null) {
                    changePanel.next(txtPhoneNumber.getText());
                }
            }
        });
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public void setChangePanel(ChangePanel changePanel) {
        this.changePanel = changePanel;
    }
}
