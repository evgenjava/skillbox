import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class MainFrame extends JFrame {

    public final String [] items = {"ВАдим Ивнов", "Петр Сергеев","item 2","item 3","item 4","item 5","item 6","item 7","item 8"};
    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;

    private DefaultListModel<Message> listModel = new DefaultListModel<Message>();
    private JList list = new JList();
    private JComponent rootPane;
    private ArrayList<Contact> listContact = new ArrayList<>();

    public MainFrame() {

        rootPane = getRootPane();
       //rootPane.setLayout(new BoxLayout(rootPane, BoxLayout.Y_AXIS));
        //getRootPane().setLayout(new BorderLayout());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationByPlatform(true);
        createList();
        getRootPane().add(list, BorderLayout.CENTER);
        setVisible(true);
    }


    private void createList() {
        for (int i = 0; i < items.length; i++) {
            if (i % 2 == 0) {
                listModel.add(i, new Message(items[i], Message.INPUT));
            }
            else {
                listModel.add(i, new Message(items[i], Message.OUTPUT));
            }
            //Message msg = new Message(items[i], Message.INPUT);
            //addOut(new MessageOutPanel(msg, 600), 10);
            //addIn(new MessageInPanel(msg, 600), 10);
        }
        list.setModel(listModel);
        list.setCellRenderer(new ItemRenderer());
    }

    private class ItemRenderer implements ListCellRenderer<Message> {

        @Override
        public Component getListCellRendererComponent(JList<? extends Message> list,
                                                      Message value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {

            if (value.getType() == Message.INPUT) {
                return new MessageInPanel(value, 600);
            }
            else {
                return new MessageOutPanel(value, 600);
            }

        }
    }

    public void addIn(JComponent component, int deltaY){
        rootPane.add(Box.createRigidArea(new Dimension(0, deltaY)));
        component.setAlignmentX(Box.CENTER_ALIGNMENT);
        rootPane.add(component);
    }

    public void addOut(JComponent component, int deltaY){
        rootPane.add(Box.createRigidArea(new Dimension(0, deltaY)));
        component.setAlignmentX(Box.CENTER_ALIGNMENT);
        rootPane.add(component);
    }
}
