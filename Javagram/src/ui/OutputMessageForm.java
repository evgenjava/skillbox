package ui;

import javax.swing.*;

public class OutputMessageForm {
    private JPanel rootPanel;
    private JPanel pnlTopGap;
    private JPanel pnlTime;
    private JPanel pnlLeftGap;
    private JTextPane paneText;
    private JPanel pnlTimeGap;
    private JLabel lblTime;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public void setTextMessage(String msg) {
        paneText.setText(msg);
    }
}
