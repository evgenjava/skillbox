import javax.swing.*;
import java.awt.*;
import java.util.Collections;

public class MainFrame extends JFrame {

    public final String [] items = {"item 0", "item 1","item 2","item 3","item 4","item 5","item 6","item 7","item 8"};
    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;

    private DefaultListModel<String> listModel = new DefaultListModel<String>();
    private JList list = new JList();
    private JComponent rootPane;

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
            //listModel.add(i, items[i]);
            Message msg = new Message(items[i]);
            addIn(new MessageInPanel(msg), 20);
        }
        //list.setModel(listModel);
        //list.setCellRenderer(new ItemRenderer());
    }

    private class ItemRenderer implements ListCellRenderer<String> {

        private JPanel topPanel = new JPanel();
        private JPanel bottomPanel = new JPanel();
        private JTextPane pane = new JTextPane();

        @Override
        public Component getListCellRendererComponent(JList<? extends String> list,
                                                      String value, int index,
                                                      boolean isSelected,
                                                      boolean cellHasFocus) {
           Message msg =new Message(value);
           return new MessageInPanel(msg);
        }
    }

    public void addIn(JComponent component, int deltaY){
        rootPane.add(Box.createRigidArea(new Dimension(0, deltaY)));
        component.setAlignmentX(Box.LEFT_ALIGNMENT);
        rootPane.add(component);
    }
}
