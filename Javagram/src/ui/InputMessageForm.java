package ui;

import javax.swing.*;

public class InputMessageForm {
    private JPanel rootPanel;
    private JPanel pnlTopGap;
    private JPanel pnlTime;
    private JPanel pnlRightGap;
    private JLabel lblTime;
    private JTextPane paneMessage;
    private JPanel pnlTimeGap;

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public void setTextMessage(String text) {
        paneMessage.setText(text);
    }

}
