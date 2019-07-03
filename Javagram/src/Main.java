import core.Chat;
import core.Contact;
import ui.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final int WIDTH = 905;
    public static final int HEIGHT = 622;

    public static String[] names = {"Андрей Пертров", "Петр Сергеев", "Дмитрий Петров"};
    public static JFrame frame = new JFrame();


    public static void main(String[] args) {

        //frame.setContentPane(createFormNumberForm().getRootPanel());
        frame.setContentPane(new PhonePanel());
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationByPlatform(true);
        frame.setTitle("Javagram");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //frame.setUndecorated(true);
        frame.setVisible(true);
    }

    public static PhoneNumberFrom createFormNumberForm() {
        ChangePanel change = new ChangePanel() {
            @Override
            public void next(String param) {
                Container contentPane = frame.getContentPane();
                contentPane.removeAll();
                frame.setContentPane(createCodeForm(param).getRootPanel());
                frame.revalidate();
            }
        };

        PhoneNumberFrom phoneNumberFrom = new PhoneNumberFrom();
        JPanel conntrolPanel = new ControlPanel().getRootPanel();
        JPanel rootPanel = phoneNumberFrom.getRootPanel();
        rootPanel.add(conntrolPanel, BorderLayout.NORTH);
        phoneNumberFrom.setChangePanel(change);
        return phoneNumberFrom;
    }

    public static CodeForm createCodeForm(String param) {
        ChangePanel change = new ChangePanel() {
            @Override
            public void next(String param) {
                Container contentPane = frame.getContentPane();
                contentPane.removeAll();
                frame.setContentPane(createMessagesForm().getRootPanel());
                frame.revalidate();
            }
        };
        CodeForm codeForm = new CodeForm();
        JPanel conntrolPanel = new ControlPanel().getRootPanel();
        JPanel rootPanel = codeForm.getRootPanel();
        rootPanel.add(conntrolPanel, BorderLayout.NORTH);
        codeForm.setPhoneNumber(param);
        codeForm.setChangePanel(change);
        return codeForm;
    }

    public static MessagesForm createMessagesForm() {
        MessagesForm messagesForm = new MessagesForm();
        JPanel conntrolPanel = new ControlPanel().getRootPanel();
        JPanel rootPanel = messagesForm.getRootPanel();
        rootPanel.add(conntrolPanel, BorderLayout.NORTH);
        messagesForm.setChatList(createChatList());
        return messagesForm;
    }

    public static List<Chat> createChatList() {
        List<Chat> list = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            list.add(new Chat(new Contact(names[i])));
        }
        return list;
    }
}
