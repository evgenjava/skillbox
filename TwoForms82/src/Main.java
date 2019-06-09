import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;

public class Main {

    public static final int WIDTH = 400;
    public static final int HEIGHT = 150;
    public static int count = 0;


    static final JFrame frame = new JFrame();;

    static FormFIO.ChangeListener changeListener = new FormFIO.ChangeListener() {
        @Override
        public void changePanel(String lname, String fname, String mname) {
            Container contentPane = frame.getContentPane();
            contentPane.removeAll();
            frame.setContentPane(createFormFIOCompact(lname, fname, mname).getRootPanel());
            frame.revalidate();
        }
    };

    static FormFIOCompact.ChangeListenerCompact changeListenerCompact = new FormFIOCompact.ChangeListenerCompact() {
        @Override
        public void changePanel(String lname, String fname, String mname) {
            Container contentPane = frame.getContentPane();
            contentPane.removeAll();
            frame.setContentPane(createFormFIO(lname, fname, mname).getRootPanel());
            frame.revalidate();
        }
    };



    public static void main(String[] args) {

        frame.setContentPane(createFormFIO("", "", "").getRootPanel());
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationByPlatform(true);
        frame.setTitle("Персональные данные");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public static FormFIO createFormFIO(String lname, String fname, String mname) {
        FormFIO formFIO = new FormFIO();
        formFIO.setData(lname, fname, mname);
        formFIO.setListener(changeListener);
        return formFIO;
    }

    public static FormFIOCompact createFormFIOCompact(String lname, String fname, String mname) {
        FormFIOCompact fioCompact = new FormFIOCompact();
        fioCompact.setData(String.format("%s %s %s", lname, fname, mname));
        fioCompact.setListenerCompact(changeListenerCompact);
        return fioCompact;
    }







}
