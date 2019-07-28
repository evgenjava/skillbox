import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class MainFrame extends JFrame {

    public final String [] items = {"ВАдим Ивнов", "Петр Сергеев","item 2","item 3","item 4","item 5","item 6","item 7","item 8"};
    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;

    private DefaultListModel<Contact> listModel = new DefaultListModel<Contact>();
    private JList list = new JList();
    private JComponent rootPane;
    private ArrayList<Contact> listContact = new ArrayList<>();

    public MainFrame() {

        rootPane = getRootPane();
        rootPane.setLayout(new BoxLayout(rootPane, BoxLayout.Y_AXIS));
        //getRootPane().setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationByPlatform(true);
        createList();
        //getRootPane().add(list, BorderLayout.CENTER);
        setVisible(true);
    }


    private void createList() {
        for (int i = 0; i < items.length; i++) {
            //listModel.add(i, new Contact(items[i], "+79992125549"));
            Message msg = new Message(items[i]);
            addOut(new MessageOutPanel(msg), 20);
            addIn(new MessageInPanel(msg), 20);
        }
        //list.setModel(listModel);
        //list.setCellRenderer(new ItemRenderer());
    }

    private class ItemRenderer implements ListCellRenderer<Contact> {

        @Override
        public Component getListCellRendererComponent(JList<? extends Contact> list,
                                                      Contact value, int index,
                                                      boolean isSelected,
                                                      boolean cellHasFocus) {
            ChatItemPanel pnlChat;
            if (isSelected) {
                pnlChat = new ChatItemPanel(value, ChatItemPanel.SELECTED_ONLINE);
            }
            else {
                pnlChat = new ChatItemPanel(value, ChatItemPanel.ONLINE);
            }
            pnlChat.setLastTime(new Date());
            pnlChat.setText("Last message ... ");
            return pnlChat;
        }
    }

    public void addIn(JComponent component, int deltaY){
        rootPane.add(Box.createRigidArea(new Dimension(0, deltaY)));
        component.setAlignmentX(Box.LEFT_ALIGNMENT);
        rootPane.add(component);
    }

    public void addOut(JComponent component, int deltaY){
        rootPane.add(Box.createRigidArea(new Dimension(0, deltaY)));
        component.setAlignmentX(Box.RIGHT_ALIGNMENT);
        rootPane.add(component);
    }
}
