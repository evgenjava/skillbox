import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FormFIO {
    private JPanel rootPanel;
    private JTextField txtLname;
    private JTextField txtFname;
    private JTextField txtMname;
    private JButton btnChange;
    private JLabel lblFamilia;
    private JLabel lblName;
    private JLabel lblOtchestvo;

    public interface ChangeListener {
        public void changePanel(String lname, String fname, String mname);
    }

    private ChangeListener listener;



    public FormFIO() {
        btnChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkInputData() && listener != null) {
                    listener.changePanel(txtLname.getText(), txtFname.getText(), txtMname.getText());
                }
            }
        });
        btnChange.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER && e.isControlDown()) {
                    if (checkInputData() && listener != null) {
                        listener.changePanel(txtLname.getText(), txtFname.getText(), txtMname.getText());
                    }
                }

            }
        });
    }

    private boolean checkInputData() {
        if (txtLname.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPanel, "Необходимо ввести Фамилию", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (txtFname.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPanel, "Необходимо ввести Имя", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (txtMname.getText().length() == 0) {
            int result = JOptionPane.showConfirmDialog(rootPanel, "Вы уверены, что не хотите ввести Отчество",
                    "Отчество", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            return result == JOptionPane.YES_OPTION;
        }
        return true;
    }

    public void setData(String lname, String fname, String mname) {
        txtLname.setText(lname);
        txtFname.setText(fname);
        txtMname.setText(mname);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        txtLname = new JTextField();
        txtLname.requestFocusInWindow();

    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public void setListener(ChangeListener listener) {
        this.listener = listener;
    }
}
