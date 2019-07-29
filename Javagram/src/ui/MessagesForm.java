package ui;

import core.Chat;
import core.Contact;
import core.Message;
import core.UserProfile;
import main.App;
import main.MainFrame;
import main.UIResources;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;


public class MessagesForm {
    private JPanel rootPanel;
    private JPanel pnlFloor;
    private JPanel pnlInfo;
    private ControlButton btnSetup;
    private ControlButton btnAdd;
    private ControlButton btnEdit;
    private JPanel pnlMain;
    private JPanel pnlList;
    private JSplitPane paneContent;
    private JPanel pnlSearch;
    private ControlButton btnSearch;
    private JTextField txtSearch;
    private JPanel pnlAddButton;
    private JPanel pnlCurrentChat;
    private JPanel pnlInputText;
    private JPanel pnlChat;
    private JPanel pnlMessages;
    private JTextPane paneOutputMessage;
    private JButton btnSend;
    private JList list;

    private ArrayList<Chat> chatList;

    private Font lightFont;
    private Font regularFont;
    private ImageLabel userLabel;
    private ImageLabel contactLabel;
    private JPanel pnlContainer;
    private BufferedImage logoMicro;
    private BufferedImage btnSendImage;
    private UserProfile user;

    private DefaultListModel<Chat> listModel = new DefaultListModel<>();

    private MainFrame.RunEditContact editContactListener;

    private ActionListener runEditContactListener = (e) -> {
        if (editContactListener != null) {
            Chat chat = (Chat) list.getSelectedValue();
            editContactListener.editContact(chat);
        }
    };

    private ActionListener btnSendListener = (e) -> {
        String text = paneOutputMessage.getText();
        if (!text.isEmpty()) {
            Chat chat = (Chat) list.getSelectedValue();
            Message msg = new Message(text, Message.OUTPUT);
            chat.getMessages().add(msg);
            addOut(new MessageOutPanel(msg, pnlChat.getSize().width), 20);
            pnlMessages.revalidate();
        }

    };

    private ListSelectionListener listListener = (e) -> {
        Chat chat = (Chat) list.getSelectedValue();
        contactLabel.setText(chat.getWith().getName());
        showChatMessages(chat);
    };


    public MessagesForm() {
        $$$setupUI$$$();
        user = App.getInstance().getUser();
        logoMicro = loadImage(UIResources.MICRO_LOGO);
        list.addListSelectionListener(listListener);
        pnlSearch.add(btnSearch, BorderLayout.WEST);
        txtSearch.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
        pnlAddButton.add(btnAdd);
        userLabel.setText(user.getFullName());
        contactLabel.setText("");
        Dimension containerSize = new Dimension(btnSetup.getWidth() + userLabel.getWidth() + 200,
                btnSetup.getHeight());
        setActualSize(pnlContainer, containerSize);
        pnlMessages.setLayout(new BoxLayout(pnlMessages, BoxLayout.Y_AXIS));
        pnlContainer.setBackground(UIResources.LIGHT_BLUE_COLOR);
        pnlContainer.add(btnSetup, BorderLayout.EAST);
        pnlContainer.add(userLabel, BorderLayout.CENTER);
        pnlInfo.add(pnlContainer, BorderLayout.EAST);
        pnlCurrentChat.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, UIResources.GRAY_COLOR2));
        pnlCurrentChat.add(contactLabel, BorderLayout.WEST);
        pnlCurrentChat.add(btnEdit, BorderLayout.EAST);
        paneOutputMessage.setForeground(UIResources.DARK_GRAY_COLOR);
        paneOutputMessage.setFont(regularFont.deriveFont(20.0F));
        btnSend.addActionListener(btnSendListener);
        btnEdit.addActionListener(runEditContactListener);
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    private void createUIComponents() {

        //кнопки
        btnSearch = new ControlButton(new Dimension(50, 50), ControlButton.SEARCH);
        btnAdd = new ControlButton(new Dimension(26, 26), ControlButton.PLUS);
        btnSetup = new ControlButton(new Dimension(50, 50), ControlButton.SETTINGS);
        btnEdit = new ControlButton(new Dimension(50, 50), ControlButton.EDIT);
        btnSendImage = loadImage(UIResources.BUTTON_SEND);
        btnSend = new JButton() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(btnSendImage, 0, 0, null);
            }
        };

        //----------------------------------------------------
        //верхняя годубая панель
        pnlInfo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (logoMicro != null) {
                    g.drawImage(logoMicro, 25, (getHeight() - logoMicro.getHeight()) / 2, null);
                }
            }
        };

        pnlInfo.setLayout(new BorderLayout());
        pnlInfo.setBackground(UIResources.LIGHT_BLUE_COLOR);
        setActualSize(pnlInfo, new Dimension(600, 50));
        //контейнер для userLabel и btnSetup
        pnlContainer = new JPanel(new BorderLayout());
        //--------------------------------------------------
        userLabel = new ImageLabel(ImageLabel.MINI_BLUE_ICON, UIResources.LIGHT_BLUE_COLOR, Color.WHITE);
        contactLabel = new ImageLabel(ImageLabel.MINI_WHITE_ICON, Color.WHITE, UIResources.DARK_GRAY_COLOR);

        lightFont = UIResources.getFont(UIResources.OPEN_SANS_LIGHT);
        regularFont = UIResources.getFont(UIResources.OPEN_SANS_REGULAR);
    }

    private BufferedImage loadImage(String fileName) {
        try {
            return ImageIO.read(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setChatList(ArrayList<Chat> l) {
        chatList = l;
        for (int i = 0; i < l.size(); i++) {
            listModel.add(i, chatList.get(i));
        }
        list.setModel(listModel);
        list.setCellRenderer(new ContactRenderer());
    }

    public void addIn(JComponent component, int deltaY) {
        pnlMessages.add(Box.createRigidArea(new Dimension(20, deltaY)));
        component.setAlignmentX(Box.CENTER_ALIGNMENT);
        pnlMessages.add(component);
        pnlMessages.revalidate();
    }

    public void addOut(JComponent component, int deltaY) {
        pnlMessages.add(Box.createRigidArea(new Dimension(20, deltaY)));
        component.setAlignmentX(Box.CENTER_ALIGNMENT);
        pnlMessages.add(component);
        pnlMessages.revalidate();
    }

    private void setActualSize(JComponent component, Dimension size) {
        component.setMaximumSize(size);
        component.setMinimumSize(size);
        component.setPreferredSize(size);
    }

    private class ContactRenderer implements ListCellRenderer<Chat> {

        @Override
        public Component getListCellRendererComponent(JList<? extends Chat> list,
                                                      Chat value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            ChatItemPanel pnlChat;
            if (isSelected) {
                if (value.isOnline())
                    pnlChat = new ChatItemPanel(value.getWith(), ChatItemPanel.SELECTED_ONLINE);
                else
                    pnlChat = new ChatItemPanel(value.getWith(), ChatItemPanel.SELECTED_OFFLINE);
            } else {
                if (value.isOnline())
                    pnlChat = new ChatItemPanel(value.getWith(), ChatItemPanel.ONLINE);
                else
                    pnlChat = new ChatItemPanel(value.getWith(), ChatItemPanel.OFFLINE);
            }
            Message msg = value.getLastMessage();
            if (msg != null) {
                pnlChat.setLastTime(msg.getTime());
                pnlChat.setText(msg.getText());
            }
            return pnlChat;
        }
    }

    private void showChatMessages(Chat chat) {
        pnlMessages.removeAll();
        ArrayList<Message> msgs = (ArrayList<Message>) chat.getMessages();
        for (Message msg : msgs) {
            if (msg.getType() == Message.INPUT) {
                addIn(new MessageInPanel(msg, pnlMessages.getWidth()), 10);
            } else {
                addOut(new MessageOutPanel(msg, pnlMessages.getWidth()), 10);
            }
        }
        pnlMessages.repaint();
    }

    public void setEditContactListener(MainFrame.RunEditContact l) {
        editContactListener = l;
    }

    public void setSetupListener(ActionListener l) {
        btnSetup.addActionListener(l);
    }

    public void setAddContactListener(ActionListener l) {
        btnAdd.addActionListener(l);
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        rootPanel = new JPanel();
        rootPanel.setLayout(new BorderLayout(0, 0));
        pnlFloor = new JPanel();
        pnlFloor.setLayout(new BorderLayout(0, 0));
        rootPanel.add(pnlFloor, BorderLayout.CENTER);
        pnlInfo.setAutoscrolls(true);
        pnlInfo.setBackground(new Color(-16731162));
        pnlInfo.setMaximumSize(new Dimension(2147483647, 50));
        pnlInfo.setMinimumSize(new Dimension(300, 50));
        pnlInfo.setOpaque(true);
        pnlInfo.setPreferredSize(new Dimension(300, 50));
        pnlFloor.add(pnlInfo, BorderLayout.NORTH);
        pnlMain = new JPanel();
        pnlMain.setLayout(new BorderLayout(0, 0));
        pnlMain.setFocusCycleRoot(true);
        pnlFloor.add(pnlMain, BorderLayout.CENTER);
        paneContent = new JSplitPane();
        paneContent.setContinuousLayout(false);
        paneContent.setDividerLocation(250);
        paneContent.setDividerSize(5);
        pnlMain.add(paneContent, BorderLayout.CENTER);
        pnlList = new JPanel();
        pnlList.setLayout(new BorderLayout(0, 0));
        pnlList.setMinimumSize(new Dimension(200, 0));
        pnlList.setPreferredSize(new Dimension(200, 0));
        paneContent.setLeftComponent(pnlList);
        pnlSearch = new JPanel();
        pnlSearch.setLayout(new BorderLayout(0, 0));
        pnlSearch.setBackground(new Color(-65794));
        pnlSearch.setMaximumSize(new Dimension(2147483647, 50));
        pnlSearch.setMinimumSize(new Dimension(0, 50));
        pnlSearch.setOpaque(true);
        pnlSearch.setPreferredSize(new Dimension(0, 50));
        pnlList.add(pnlSearch, BorderLayout.NORTH);
        txtSearch = new JTextField();
        txtSearch.setText("");
        txtSearch.setToolTipText("Поиск");
        pnlSearch.add(txtSearch, BorderLayout.CENTER);
        pnlAddButton = new JPanel();
        pnlAddButton.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
        pnlAddButton.setBackground(new Color(-2039584));
        pnlAddButton.setMaximumSize(new Dimension(2147483647, 50));
        pnlAddButton.setMinimumSize(new Dimension(0, 50));
        pnlAddButton.setPreferredSize(new Dimension(0, 50));
        pnlList.add(pnlAddButton, BorderLayout.SOUTH);
        list = new JList();
        list.setBackground(new Color(-2039584));
        pnlList.add(list, BorderLayout.CENTER);
        pnlChat = new JPanel();
        pnlChat.setLayout(new BorderLayout(0, 0));
        paneContent.setRightComponent(pnlChat);
        pnlCurrentChat = new JPanel();
        pnlCurrentChat.setLayout(new BorderLayout(0, 0));
        pnlCurrentChat.setBackground(new Color(-1));
        pnlCurrentChat.setMaximumSize(new Dimension(2147483647, 50));
        pnlCurrentChat.setMinimumSize(new Dimension(0, 50));
        pnlCurrentChat.setPreferredSize(new Dimension(0, 50));
        pnlChat.add(pnlCurrentChat, BorderLayout.NORTH);
        pnlInputText = new JPanel();
        pnlInputText.setLayout(new GridBagLayout());
        pnlInputText.setMaximumSize(new Dimension(2147483647, 65));
        pnlInputText.setMinimumSize(new Dimension(0, 65));
        pnlInputText.setPreferredSize(new Dimension(0, 65));
        pnlChat.add(pnlInputText, BorderLayout.SOUTH);
        paneOutputMessage = new JTextPane();
        paneOutputMessage.setBackground(new Color(-2039584));
        paneOutputMessage.setMaximumSize(new Dimension(2147483647, 45));
        paneOutputMessage.setMinimumSize(new Dimension(7, 45));
        paneOutputMessage.setPreferredSize(new Dimension(7, 45));
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.8;
        gbc.fill = GridBagConstraints.BOTH;
        pnlInputText.add(paneOutputMessage, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlInputText.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        pnlInputText.add(spacer2, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        pnlInputText.add(spacer3, gbc);
        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlInputText.add(spacer4, gbc);
        btnSend.setMaximumSize(new Dimension(62, 45));
        btnSend.setMinimumSize(new Dimension(62, 45));
        btnSend.setPreferredSize(new Dimension(62, 45));
        btnSend.setText("Button");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlInputText.add(btnSend, gbc);
        pnlMessages = new JPanel();
        pnlMessages.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        pnlMessages.setBackground(new Color(-1));
        pnlChat.add(pnlMessages, BorderLayout.CENTER);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return rootPanel;
    }


}
