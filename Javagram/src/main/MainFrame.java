package main;

import core.Chat;
import core.Contact;
import core.Message;
import core.UserProfile;
import ui.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainFrame extends JFrame {

    public static final int WIDTH = 905;
    public static final int HEIGHT = 630;

    private String phoneNumber;
    private String code;

    private PhoneNumberFrom phoneNumberFrom;

    public static interface  RunEditContact {
        public void editContact(Chat chat);
    }

    private RunEditContact runEditContact = (contact) -> {
        Container contentPane = getContentPane();
        contentPane.removeAll();
        setContentPane(getEditContactForm(contact).getRootPanel());
        revalidate();
    };

    private ActionListener runCodeFormListener = (e) -> {
        Container contentPane = getContentPane();
        contentPane.removeAll();
        setContentPane(getCodeForm(phoneNumberFrom.getPhone()).getRootPanel());
        revalidate();
    };
    private ActionListener runMessageFormListener = (e) -> {
        Container contentPane = getContentPane();
        contentPane.removeAll();
        setContentPane(getMessagesForm().getRootPanel());
        revalidate();
    };

    private ActionListener runSetupListener = (e) -> {
        Container contentPane = getContentPane();
        contentPane.removeAll();
        setContentPane(getProfileForm().getRootPanel());
        revalidate();
    };

    private ActionListener runAddContactListener = (e) -> {
        Container contentPane = getContentPane();
        contentPane.removeAll();
        setContentPane(getAddContactForm().getRootPanel());
        revalidate();
    };



    public MainFrame()  {
        setContentPane(getFormNumberForm().getRootPanel());
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setTitle("Javagram");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setVisible(true);
    }

    private PhoneNumberFrom getFormNumberForm() {
        phoneNumberFrom = new PhoneNumberFrom();
        JPanel controlPanel = new ControlPanel().getRootPanel();
        JPanel rootPanel = phoneNumberFrom.getRootPanel();
        rootPanel.add(controlPanel, BorderLayout.NORTH);
        phoneNumberFrom.setChangeListener(runCodeFormListener);
        return phoneNumberFrom;
    }

    private CodeForm getCodeForm(String param) {
        CodeForm codeForm = new CodeForm();
        JPanel controlPanel = new ControlPanel().getRootPanel();
        JPanel rootPanel = codeForm.getRootPanel();
        rootPanel.add(controlPanel, BorderLayout.NORTH);
        codeForm.setPhoneNumber(param);
        codeForm.setChangeListener(runMessageFormListener);
        return codeForm;
    }

    private MessagesForm getMessagesForm() {
        MessagesForm messagesForm = new MessagesForm();
        JPanel controlPanel = new ControlPanel().getRootPanel();
        JPanel rootPanel = messagesForm.getRootPanel();
        rootPanel.add(controlPanel, BorderLayout.NORTH);
        messagesForm.setChatList(App.getInstance().getChatList());
        messagesForm.setSetupListener(runSetupListener);
        messagesForm.setEditContactListener(runEditContact);
        messagesForm.setAddContactListener(runAddContactListener);
        return messagesForm;
    }

    private ProfileForm getProfileForm() {
        UserProfile user = App.getInstance().getUser();
        ProfileForm profileForm = new ProfileForm();

        profileForm.setUser(user);
        profileForm.setBackListener(runMessageFormListener);
        profileForm.setExitListener(runMessageFormListener);
        JPanel controlPanel = new ControlPanel().getRootPanel();
        JPanel rootPanel = profileForm.getRootPanel();
        rootPanel.add(controlPanel, BorderLayout.NORTH);
        return profileForm;
    }

    private EditContactForm getEditContactForm(Chat chat) {
        EditContactForm editContactForm = new EditContactForm(chat);
        editContactForm.setBackListener(runMessageFormListener);
        JPanel controlPanel = new ControlPanel().getRootPanel();
        JPanel rootPanel = editContactForm.getRootPanel();
        rootPanel.add(controlPanel, BorderLayout.NORTH);
        return editContactForm;
    }

    private RegistrationForm createRegistrationForm() {
        RegistrationForm registrationForm = new RegistrationForm();
        JPanel controlPanel = new ControlPanel().getRootPanel();
        JPanel rootPanel = registrationForm.getRootPanel();
        rootPanel.add(controlPanel, BorderLayout.NORTH);
        return registrationForm;
    }

    private AddContactForm getAddContactForm() {

        AddContactForm addContactForm = new AddContactForm();
        addContactForm.setBackListener(runMessageFormListener);
        JPanel controlPanel = new ControlPanel().getRootPanel();
        JPanel rootPanel = addContactForm.getRootPanel();
        rootPanel.add(controlPanel, BorderLayout.NORTH);
        return addContactForm;
    }
}
