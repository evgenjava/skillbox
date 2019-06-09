package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CodeForm {

    private final String welcomInput = "На данный номер телефона было отправлено\n" +
            "SMS - сообщение с кодом подтверждения.\n" +
            "Пожалуйства, введите этот код в поле ниже:";

    private JPanel rootPanel;
    private JPanel pnlMain;
    private JPanel pnlLogo;
    private JPanel pnlWelcomInput;
    private JTextPane txtWelcomInput;
    private JPanel pnlCode;
    private JPanel pnlNext;
    private JButton btnNext;
    private JPasswordField txtCode;
    private JPanel pnlPhoneNumbet;
    private JLabel lblPhoneNumber;

    private ChangePanel changePanel;

    public CodeForm() {
        pnlMain.setLayout(new BoxLayout(pnlMain, BoxLayout.Y_AXIS));
        btnNext.setBackground(new Color(21, 61, 242));
        txtWelcomInput.setText(welcomInput);
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (changePanel != null) {
                    changePanel.next(txtCode.getPassword().toString());
                }
            }
        });
    }

    public void setPhoneNumber(String number) {
        lblPhoneNumber.setText(number);
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public void setChangePanel(ChangePanel changePanel) {
        this.changePanel = changePanel;
    }
}
