package ui;

import core.Chat;
import main.UIResources;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MessagesForm {
    private JPanel rootPanel;
    private JPanel pnlFloor;
    private JPanel pnlInfo;
    private JLabel lblName;
    private ControlButton btnSetup;
    private ControlButton btnAdd;
    private ControlButton btnEdit;
    private JPanel pnlContacts;
    private JPanel pnlMain;
    private JSplitPane paneContent;
    private JPanel pnlList;
    private JPanel pnlSearch;
    private ControlButton btnSearch;
    private JTextField txtSearch;
    private JPanel pnlAddButton;
    private JPanel pnlCurrentChat;
    private JPanel pnlInputText;
    private JButton btnSend;
    private JPanel pnlChat;
    private JPanel pnlMessages;
    private JTextField txtMessage;

    private List<Chat> chatList;
    private List<ListItemForm> listItems = new ArrayList<>();
    private Font lightFont;
    private NamePanel userPanel;
    private NamePanel pnlContact;
    private JPanel pnlContainer;
    private BufferedImage logoMicro;


    public MessagesForm() {
        createUIComponents();
        $$$setupUI$$$();
        //поисковая панель
        setLogo(UIResources.MICRO_LOGO);
        pnlSearch.add(btnSearch, BorderLayout.WEST);
        txtSearch.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
        //кнопка plus
        pnlAddButton.add(btnAdd);
        Dimension containerSize = new Dimension(btnSetup.getWidth() + userPanel.getWidth() + 250,
                btnSetup.getHeight());

        pnlContainer.setPreferredSize(containerSize);
        pnlContainer.setMinimumSize(containerSize);
        pnlContainer.setMaximumSize(containerSize);
        pnlContainer.setBackground(UIResources.LIGHT_BLUE_COLOR);
        pnlContainer.add(btnSetup, BorderLayout.EAST);
        pnlContainer.add(userPanel, BorderLayout.CENTER);
        pnlInfo.add(pnlContainer, BorderLayout.EAST);
        //pnlInfo.add(btnSetup);
        pnlCurrentChat.add(pnlContact, BorderLayout.WEST);
        pnlCurrentChat.add(btnEdit, BorderLayout.EAST);
        pnlContacts.setLayout(new BoxLayout(pnlContacts, BoxLayout.Y_AXIS));
        pnlMessages.setLayout(new BoxLayout(pnlMessages, BoxLayout.Y_AXIS));
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addOutputMessage(txtMessage.getText());
                pnlMessages.revalidate();
            }
        });
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        btnSearch = new ControlButton(new Dimension(50, 50), ControlButton.BTN_TYPE.SEARCH);
        btnAdd = new ControlButton(new Dimension(26, 26), ControlButton.BTN_TYPE.PLUS);
        btnSetup = new ControlButton(new Dimension(50, 50), ControlButton.BTN_TYPE.SETTINGS);
        btnEdit = new ControlButton(new Dimension(50, 50), ControlButton.BTN_TYPE.EDIT);
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
        pnlInfo.setMaximumSize(new Dimension(600, 50));
        pnlInfo.setMinimumSize(new Dimension(300, 50));
        pnlInfo.setOpaque(true);
        pnlInfo.setPreferredSize(new Dimension(300, 50));
        userPanel = new NamePanel("Вадим Иванов", UIResources.LIGHT_BLUE_COLOR, Color.WHITE,
                FacePanel.MASK_BLUE_MINI, 50);
        pnlContact = new NamePanel("Петр Сергеев", Color.WHITE, Color.BLACK, FacePanel.MASK_WHITE_MINI, 50);
        pnlContainer = new JPanel(new BorderLayout());
        lightFont = UIResources.getFont(UIResources.OPEN_SANS_LIGHT);

    }

    private void setLogo(String fileName) {
        try {
            logoMicro = ImageIO.read(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        pnlAddButton.setMaximumSize(new Dimension(2147483647, 50));
        pnlAddButton.setMinimumSize(new Dimension(0, 50));
        pnlAddButton.setPreferredSize(new Dimension(0, 50));
        pnlList.add(pnlAddButton, BorderLayout.SOUTH);
        pnlContacts = new JPanel();
        pnlContacts.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        pnlList.add(pnlContacts, BorderLayout.CENTER);
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
        pnlLeftBorder = new JPanel();
        pnlLeftBorder.setLayout(new BorderLayout(0, 0));
        pnlLeftBorder.setPreferredSize(new Dimension(20, 0));
        pnlChat.add(pnlLeftBorder, BorderLayout.WEST);
        pnlRightBorder = new JPanel();
        pnlRightBorder.setLayout(new BorderLayout(0, 0));
        pnlRightBorder.setMaximumSize(new Dimension(20, 2147483647));
        pnlRightBorder.setMinimumSize(new Dimension(20, 0));
        pnlRightBorder.setPreferredSize(new Dimension(20, 0));
        pnlChat.add(pnlRightBorder, BorderLayout.EAST);
        pnlInputText = new JPanel();
        pnlInputText.setLayout(new GridBagLayout());
        pnlInputText.setMaximumSize(new Dimension(2147483647, 50));
        pnlInputText.setMinimumSize(new Dimension(0, 50));
        pnlInputText.setPreferredSize(new Dimension(0, 50));
        pnlChat.add(pnlInputText, BorderLayout.SOUTH);
        final JPanel spacer1 = new JPanel();
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlInputText.add(spacer1, gbc);
        btnSend = new JButton();
        btnSend.setMaximumSize(new Dimension(62, 45));
        btnSend.setMinimumSize(new Dimension(62, 45));
        btnSend.setPreferredSize(new Dimension(40, 30));
        btnSend.setText("->");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        pnlInputText.add(btnSend, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        pnlInputText.add(spacer2, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(0, 8, 0, 0);
        pnlInputText.add(spacer3, gbc);
        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(0, 0, 0, 8);
        pnlInputText.add(spacer4, gbc);
        final JPanel spacer5 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        pnlInputText.add(spacer5, gbc);
        txtMessage = new JTextField();
        txtMessage.setMaximumSize(new Dimension(2147483647, 45));
        txtMessage.setMinimumSize(new Dimension(64, 45));
        txtMessage.setPreferredSize(new Dimension(64, 45));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlInputText.add(txtMessage, gbc);
        pnlMessages = new JPanel();
        pnlMessages.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        pnlChat.add(pnlMessages, BorderLayout.CENTER);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return rootPanel;
    }

}
