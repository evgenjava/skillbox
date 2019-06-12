package ui;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.PlainDocument;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FormFIO extends BasePanel {

    private JPanel rootPanel;
    private JTextField txtLname;
    private JTextField txtFname;
    private JTextField txtMname;
    private JButton btnChange;
    private JLabel lblFamilia;
    private JLabel lblName;
    private JLabel lblOtchestvo;

    @Override
    public String[] getData() {
        return new String[] {txtLname.getText(), txtFname.getText(), txtMname.getText()};
    }

    @Override
    public void setData(String[] data) {
        txtLname.setText(data[0]);
        txtFname.setText(data[1]);
        txtMname.setText(data[2]);
    }

    public FormFIO() {
        txtLname.setDocument(new BasePanel.TextFilter());
        txtFname.setDocument(new BasePanel.TextFilter());
        txtMname.setDocument(new BasePanel.TextFilter());
        txtLname.requestFocusInWindow();
        add(rootPanel);
    }

    public void addChangeListener(ActionListener listener) {
        btnChange.addActionListener(listener);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }



}
