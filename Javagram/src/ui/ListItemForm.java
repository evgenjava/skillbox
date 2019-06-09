package ui;

import javax.swing.*;
import java.awt.*;

public class ListItemForm {
    private JPanel pnlItem;
    private JPanel pnlPhoto;
    private JPanel pnlRight;
    private JPanel pnlContact;
    private JTextPane paneName;
    private JTextPane paneLast;
    private JPanel rootPanel;

    public ListItemForm() {

    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public void setName(String name) {
        paneName.setText(name);
    }
    public void setLast(String last) {
        paneLast.setText(last);
    }

}
