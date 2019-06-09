import javax.swing.*;

public class Form {
    private JPanel rootPanel;
    private JTextField txtLName;
    private JTextField txtMName;
    private JTextField txtBirthday;
    private JTextField txtCity;
    private JButton clickButton;
    private JLabel lblLName;
    private JTextField txtFName;
    private JLabel lblFName;
    private JLabel lblMName;
    private JLabel lblBirthday;
    private JLabel lblCity;
    private JPanel pnlLName;
    private JPanel pnlMName;
    private JPanel pnlCity;
    private JPanel pnlFName;
    private JPanel btnPanel;
    private JPanel pnlBirthday;

    public Form() {
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.Y_AXIS));
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
