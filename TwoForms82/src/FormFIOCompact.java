import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.*;

public class FormFIOCompact {
    private JPanel rootPanel;
    private JTextField txtFio;
    private JButton btnChange;
    private JLabel lblFio;
    private JProgressBar pbLenght;

    private String lName = "";
    private String fName = "";
    private String mName = "";

    public interface ChangeListenerCompact {
        public void changePanel(String lname, String fname, String mname);
    }

    private ChangeListenerCompact listenerCompact;

    public FormFIOCompact() {
        txtFio.setColumns(100);
        btnChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listenerCompact != null) {
                    parseFio(txtFio.getText());
                    listenerCompact.changePanel(lName, fName, mName);
                }
            }
        });
        btnChange.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER && e.isControlDown()) {
                    if (listenerCompact != null) {
                        parseFio(txtFio.getText());
                        listenerCompact.changePanel(lName, fName, mName);
                    }
                }
            }
        });
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

    public void setListenerCompact(ChangeListenerCompact listenerCompact) {
        this.listenerCompact = listenerCompact;
    }

    private void parseFio(String fio) {

        String[] fullName = fio.split("[\\d\\s,.|?:;]+");
        if (fullName.length >= 3 ) {
            lName = fullName[0];
            fName = fullName[1];
            mName = fullName[2];
        }
        else if (fullName.length == 2) {
            lName = fullName[0];
            fName = fullName[1];
            mName = "";
        }
        else if (fullName.length == 1) {
            lName = fullName[0];
            fName = "";
            mName = "";
        }
        else {
            lName = "";
            fName = "";
            mName = "";
        }
    }
}
