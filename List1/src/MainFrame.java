import javax.swing.*;
import java.awt.*;
import java.util.Collections;

public class MainFrame extends JFrame {

    public final String [] items = {"item 0", "item 1","item 2","item 3","item 4","item 5","item 6","item 7","item 8"};
    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;

    private DefaultListModel<String> listModel = new DefaultListModel<String>();
    private JList list = new JList();

    public MainFrame() {

        getRootPane().setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationByPlatform(true);
        createList();
        getRootPane().add(list, BorderLayout.CENTER);
        setVisible(true);
    }


    private void createList() {
        for (int i = 0; i < items.length; i++) {
            listModel.add(i, items[i]);
        }
        list.setModel(listModel);
        list.setCellRenderer(new ItemRenderer());
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

            JPanel component = new JPanel();
            component.setSize(300, 40);
            component.setLayout(new BorderLayout());
            topPanel.setSize(300, 10);
            bottomPanel.setSize(300, 10);
            pane.setForeground(Color.BLACK);
            System.out.println("----------------------------------------");
            System.out.println("IS Selected = " + isSelected + " index = " + index + " value " + value);
            if (isSelected) {
                topPanel.setBackground(Color.YELLOW);
                bottomPanel.setBackground(Color.YELLOW);
                pane.setForeground(Color.YELLOW);
                pane.setBackground(Color.GRAY);
            }
            else {
                topPanel.setBackground(Color.BLUE);
                bottomPanel.setBackground(Color.BLUE);
                pane.setBackground(Color.WHITE);
                pane.setForeground(Color.BLACK);
            }
            pane.setText(value);
            component.add(topPanel, BorderLayout.NORTH);
            component.add(bottomPanel, BorderLayout.SOUTH);
            component.add(pane, BorderLayout.CENTER);
            return component;
        }
    }
}
