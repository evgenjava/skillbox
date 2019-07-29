import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MessagePanel extends JPanel {
    public static final int IN = 100;
    public static final int OUT = 101;

    protected final JLabel lblTime = new JLabel();

    protected final JPanel pnlContainer = new JPanel(new BorderLayout());
    protected final JPanel pnlMessage = new JPanel(new BorderLayout());
    protected final JPanel sPanel = new JPanel(new BorderLayout());

    protected final Font timeFont = UIResources.getFont(UIResources.OPEN_SANS_LIGHT);
    protected final DateFormat format = new SimpleDateFormat("dd.MM.YYYY hh:mm");

    protected final JTextPane paneMessage = new JTextPane();
    protected int width;
    protected int height;
    protected DrawingPanel topPanel;
    protected DrawingPanel bottomPanel;
    protected Color bColor;
    protected JPanel pnlTime;
    protected TrianglePanel triangle;
    protected Message message;

    public MessagePanel(Message msg, int typeMessage) {
        this.message = msg;
        setLayout(new BorderLayout());
        switch (typeMessage) {
            case IN :
                width = 308;
                height = 46;
                topPanel = new DrawingPanel(DrawingPanel.IN_TOP);
                bottomPanel = new DrawingPanel(DrawingPanel.IN_BOTTOM);
                bColor = UIResources.LIGHT_BLUE_COLOR;
                triangle = new TrianglePanel(TrianglePanel.IN_LEFT, 46);
                pnlTime = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
                break;
            case OUT :
                width = 307;
                height = 48;
                topPanel = new DrawingPanel(DrawingPanel.OUT_TOP);
                bottomPanel = new DrawingPanel(DrawingPanel.OUT_BOTTOM);
                bColor = UIResources.VIOLET_COLOR;
                triangle = new TrianglePanel(TrianglePanel.OUT_RIGHT, 48);
                pnlTime = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
                break;
        }
        pnlMessage.setOpaque(false);
        pnlTime.setBackground(Color.WHITE);
        lblTime.setFont(timeFont.deriveFont(10.0F));
        lblTime.setForeground(UIResources.DARK_GRAY_COLOR);
        lblTime.setText(format.format(new Date()));
        pnlTime.add(lblTime);
        setComponentSize(sPanel, new Dimension(width + 20, height + 14));
        setComponentSize(pnlContainer, new Dimension(width + 20, height));
        setComponentSize(pnlMessage, new Dimension(width, height));
        setComponentSize(pnlTime, new Dimension(width, 14));
        //sPanel.setBackground(bColor);
        paneMessage.setEditable(false);
        paneMessage.setBackground(bColor);
        paneMessage.setForeground(Color.WHITE);
        paneMessage.setText(message.getText());
        pnlMessage.add(topPanel, BorderLayout.NORTH);
        pnlMessage.add(bottomPanel, BorderLayout.SOUTH);
        pnlMessage.add(paneMessage, BorderLayout.CENTER);
    }

    protected void setComponentSize(JComponent comp, Dimension size) {
        comp.setMaximumSize(size);
        comp.setMinimumSize(size);
        comp.setPreferredSize(size);
    }
}
