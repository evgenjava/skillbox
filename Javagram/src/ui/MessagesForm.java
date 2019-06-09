package ui;

import core.Chat;
import core.Message;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MessagesForm {
    private JPanel rootPanel;
    private JPanel pnlFloor;
    private JPanel pnlInfo;
    private JLabel lblName;
    private JButton btnSetup;
    private JButton btnAdd;
    private JPanel pnlContacts;
    private JPanel pnlMain;
    private JSplitPane paneContent;
    private JPanel pnlList;
    private JPanel pnlSearch;
    private JButton btnSearch;
    private JTextField txtSearch;
    private JPanel pnlAddButton;
    private JPanel pnlCurrentChat;
    private JPanel pnlSmallPhoto;
    private JButton btnEdit;
    private JTextPane paneCurrentName;
    private JPanel pnlLeftBorder;
    private JPanel pnlRightBorder;
    private JPanel pnlInputText;
    private JPanel pnlTopGap;
    private JPanel pnlBottomGap;
    private JPanel pnlLeftGap;
    private JButton btnSend;
    private JTextPane paneMessage;
    private JPanel pnlBottomGapList;
    private JPanel pnlTopGapList;
    private JPanel pnlLeftGapList;
    private JPanel pnlRightGap;
    private JPanel pnlText;
    private JPanel pnlButton;
    private JPanel pnlChat;
    private JPanel pnlMessages;

    private List<Chat> chatList;
    private List<ListItemForm> listItems = new ArrayList<>();


    public MessagesForm() {
        btnAdd.setBackground(new Color(21, 61, 242));
        pnlContacts.setLayout(new BoxLayout(pnlContacts, BoxLayout.Y_AXIS));
        pnlMessages.setLayout(new BoxLayout(pnlMessages, BoxLayout.Y_AXIS));
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addOutputMessage(paneMessage.getText());
                pnlMessages.revalidate();
            }
        });
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public void setChatList(List<Chat> list) {
        pnlContacts.removeAll();
        chatList = list;
        for (int i = 0; i < list.size(); i++) {
            ListItemForm form = new ListItemForm();
            Chat chat = list.get(i);
            form.setName(chat.getWith().getName());
            form.setLast("last message...");
            pnlContacts.add(form.getRootPanel());
        }
        addInputMessages("Какое-то входящее сообщение ..");
        addOutputMessage("Какое-то исходящее сообщение ..");
    }

    private void addInputMessages(String msg) {
        InputMessageForm inputMessageForm = new InputMessageForm();
        inputMessageForm.setTextMessage(msg);
        pnlMessages.add(inputMessageForm.getRootPanel());
    }

    private void addOutputMessage(String msg) {
        OutputMessageForm outputMessageForm = new OutputMessageForm();
        outputMessageForm.setTextMessage(msg);
        pnlMessages.add(outputMessageForm.getRootPanel());
    }
}
