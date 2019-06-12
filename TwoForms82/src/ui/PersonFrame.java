package ui;

import model.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class PersonFrame extends JFrame {

    public static final int WIDTH = 400;
    public static final int HEIGHT = 200;
    public static final String ACTION_KEY = "CHANGE_PANEL";

    private BasePanel currentPanel;
    private FormFIO formFIO;
    private FormFIOCompact formFIOCompact;

    public PersonFrame() {

        formFIO = new FormFIO();
        formFIOCompact = new FormFIOCompact();
        formFIO.addChangeListener((e) -> changePanel());
        formFIOCompact.addChangeListener((e) -> changePanel());
        changePanel();
        setSize(WIDTH, HEIGHT);
        setLocationByPlatform(true);
        setTitle("Персональные данные");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        InputMap im = getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = getRootPane().getActionMap();
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, KeyEvent.CTRL_DOWN_MASK, true), ACTION_KEY);
        am.put(ACTION_KEY, new ChangeAction());

        setVisible(true);
    }

    private void changePanel() {
        Container container = getContentPane();
        if (container instanceof BasePanel) {
            Person person = createPerson(currentPanel);
            if (currentPanel == formFIO) {
                if(!checkData(person)) return;
                currentPanel = formFIOCompact;
            }
            else {
                currentPanel = formFIO;
            }
            currentPanel.setData(new String[] {person.getLastName(), person.getFirstName(), person.getMiddleName()});
        }
        else {
            currentPanel = formFIO;
        }
        setPanel(currentPanel);
    }

    private void setPanel(Container panel) {
        setContentPane(panel);
        revalidate();
    }

    private Person createPerson(BasePanel panel) {
        String[]  fio = panel.getData();
        if (fio.length == 1) {
            return parseFio(fio[0]);
        }
        else {
            return new Person(fio[0], fio[1], fio[2]);
        }
    }

    private boolean checkData(Person person) {
        if (person.getLastName().length() == 0) {
            JOptionPane.showMessageDialog(this, "Необходимо ввести Фамилию", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (person.getFirstName().length() == 0) {
            JOptionPane.showMessageDialog(this, "Необходимо ввести Имя", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (person.getMiddleName().length() == 0) {
            int result = JOptionPane.showConfirmDialog(this, "Вы уверены, что не хотите ввести Отчество",
                    "Отчество", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            return result == JOptionPane.YES_OPTION;
        }
        return true;
    }

    private Person parseFio(String fio) {
        String[] name = fio.split(" ");
        switch(name.length) {
            case 0: return new Person();
            case 1: return new Person(name[0], "", "");
            case 2: return new Person(name[0], name[1],  "");
            default: return new Person(name[0], name[1],  name[2]);
        }
    }

    class ChangeAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            changePanel();
        }
    }

}
