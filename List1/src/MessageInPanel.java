import javax.swing.*;
import java.awt.*;

public class MessageInPanel extends JPanel {

    private final int width = 308;
    private final DrawingPanel topPanel = new DrawingPanel(DrawingPanel.IN_TOP);
    private final DrawingPanel bottomPanel = new DrawingPanel(DrawingPanel.IN_BOTTOM);
    private final Color inColor = new Color(0x0, 0xa9, 0xdb);

    private final JPanel pnlMessage = new JPanel(new BorderLayout());
    private final JPanel pnlTime = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));

    private final JTextPane paneMessage = new JTextPane();

    private TrianglePanel left;
    private Message message;

    public MessageInPanel(Message message) {
        this.message = message;
        setLayout(new BorderLayout());
        pnlMessage.setOpaque(false);
        pnlTime.setBackground(Color.WHITE);
        setComponentSize(this, new Dimension(width + 20, 46));
        setComponentSize(pnlMessage, new Dimension(width, 46));
        paneMessage.setEditable(false);
        paneMessage.setBackground(inColor);
        paneMessage.setForeground(Color.WHITE);
        setComponentSize(paneMessage, new Dimension(width, 30));
        paneMessage.setText(message.getText());
        pnlMessage.add(topPanel, BorderLayout.NORTH);
        pnlMessage.add(bottomPanel, BorderLayout.SOUTH);
        pnlMessage.add(paneMessage, BorderLayout.CENTER);
        left = new TrianglePanel(TrianglePanel.IN_LEFT, 46);
        add(left, BorderLayout.WEST);
        add(pnlMessage, BorderLayout.CENTER);

    }

    private void setComponentSize(JComponent comp, Dimension size) {
        comp.setMaximumSize(size);
        comp.setMinimumSize(size);
        comp.setPreferredSize(size);
    }


}
