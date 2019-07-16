package ui;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;

public class FormFIOCompact extends BasePanel {
    private JPanel rootPanel;
    private JLabel lblFio;
    private JTextField txtFio;
    private JButton btnChange;
    private JProgressBar pbLenght;


    @Override
    public String[] getData() {
        return new String[]{txtFio.getText()};
    }

    @Override
    public void setData(String[] data) {
        txtFio.setText(String.format("%s %s %s", data[0], data[1], data[2]));
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
        rootPanel.setLayout(new GridBagLayout());
        final JPanel spacer1 = new JPanel();
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        rootPanel.add(spacer1, gbc);
        lblFio = new JLabel();
        lblFio.setRequestFocusEnabled(false);
        lblFio.setText("Ф.И.О.");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        rootPanel.add(lblFio, gbc);
        txtFio = new JTextField();
        txtFio.setMaximumSize(new Dimension(200, 2147483647));
        txtFio.setMinimumSize(new Dimension(200, 30));
        txtFio.setPreferredSize(new Dimension(200, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        rootPanel.add(txtFio, gbc);
        pbLenght = new JProgressBar();
        pbLenght.setPreferredSize(new Dimension(146, 20));
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        rootPanel.add(pbLenght, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        rootPanel.add(spacer2, gbc);
        btnChange = new JButton();
        btnChange.setText("Button");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        rootPanel.add(btnChange, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return rootPanel;
    }

    public interface ChangeListenerCompact {
        public void changePanel(String lname, String fname, String mname);
    }


    public FormFIOCompact() {
        add(rootPanel);
        txtFio.setDocument(new TextFilter());
        txtFio.setColumns(100);
        txtFio.requestFocusInWindow();

        txtFio.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateProgressBar(txtFio.getText().length());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateProgressBar(txtFio.getText().length());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateProgressBar(txtFio.getText().length());
            }
        });

    }

    public void addChangeListener(ActionListener listener) {
        btnChange.addActionListener(listener);
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public void setData(String fio) {
        txtFio.setText(fio);
        updateProgressBar(fio.length());
    }

    private void updateProgressBar(int length) {
        pbLenght.setString(Integer.toString(length));
        pbLenght.setValue(length);
    }

}