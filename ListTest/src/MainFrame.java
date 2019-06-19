import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {

    private JPanel rootPanel = new JPanel();
    private JList jList = new JList();
    private SimpleListModel model = new SimpleListModel();
    private DefaultListModel<Contact> lm = new DefaultListModel<>();
    private ListSelectionModel lsm = new DefaultListSelectionModel();
    private JScrollPane listPane;

    public  MainFrame() {

        rootPanel.setLayout(new BorderLayout());
        setSize(600, 400);
        setTitle("List Test");
        setDefaultCloseOperation(EXIT_ON_CLOSE);



        setListModel();
        listPane = new JScrollPane(jList);
        listPane.setSize(300, 200);
        rootPanel.add(listPane, BorderLayout.CENTER);
        setContentPane(rootPanel);
        setVisible(true);


    }

    private void setListModel() {

        for (int i = 0; i < 10; i++) {
            String s1 = "Фамилия" + String.valueOf(i);
            String s2 = "Имя" + i;
            String s3 = "Отчество" + i;
            //model.addItem();
            lm.addElement(new Contact(s1, s2, s3));
        }
        jList.setModel(lm);
        //jList.setSelectionModel(lsm);
        //jList.addListSelectionListener(new listSelectionListener());
        jList.setCellRenderer(new ContactRender());

    }

    class listSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            // Выделенная строка
            int selected = ((JList<?>)e.getSource()).
                    getSelectedIndex();
            System.out.println ("Выделенная строка : " +
                    String.valueOf(selected));
        }
    }

    private class SimpleListModel extends AbstractListModel<Contact> {

        private List<Contact> items = new ArrayList<>();

        @Override
        public int getSize() {
            return items == null ? 0 : items.size() ;
        }

        @Override
        public Contact getElementAt(int index) {
            return index >= items.size() ? null : items.get(index);

        }

        public void addItem(Contact contact) {
            items.add(contact);
        }
    }

    private class ContactRender extends JPanel implements ListCellRenderer<Contact> {

        private final JTextPane label = new JTextPane();
        private final JPanel topPanel = new JPanel();
        private final JPanel downPanel = new JPanel();

        @Override
        public Component getListCellRendererComponent(JList<? extends Contact> list,
                                                      Contact value, int index,
                                                      boolean isSelected,
                                                      boolean cellHasFocus) {

            setLayout(new BorderLayout());

            add(topPanel, BorderLayout.NORTH);
            add(downPanel, BorderLayout.SOUTH);

            if (isSelected) {
                topPanel.setBackground(Color.BLUE);
                downPanel.setBackground(Color.BLUE);
                label.setBackground(Color.BLUE);
                label.setForeground(Color.WHITE);
                System.out.println("draw selected " + value.toString() + " " + cellHasFocus);
            }
            else {
                topPanel.setBackground(Color.WHITE);
                downPanel.setBackground(Color.WHITE);
                label.setBackground(Color.YELLOW);
                label.setSelectedTextColor(Color.BLUE);
                label.setForeground(Color.BLUE);
                System.out.println("draw unselected " +value.toString() + " " + cellHasFocus);
            }
            label.setText(value.toString());
            add(topPanel, BorderLayout.NORTH);
            add(downPanel, BorderLayout.SOUTH);
            add(label, BorderLayout.CENTER);
            return this;
        }
    }
}
