import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageInPanel extends MessagePanel {

    public MessageInPanel(Message message, int widthParent) {
        super(message, MessagePanel.IN);
        setComponentSize(this, new Dimension(widthParent, height + 14));
        pnlContainer.add(triangle, BorderLayout.WEST);
        pnlContainer.add(pnlMessage, BorderLayout.CENTER);
        sPanel.add(pnlContainer, BorderLayout.CENTER);
        sPanel.add(pnlTime, BorderLayout.SOUTH);
        add(sPanel, BorderLayout.WEST);
    }

}
