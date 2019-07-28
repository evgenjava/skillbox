import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageInPanel extends MessagePanel {

    public MessageInPanel(Message message) {
        super(message, MessagePanel.IN);
        pnlContainer.add(triangle, BorderLayout.WEST);
        pnlContainer.add(pnlMessage, BorderLayout.CENTER);
        add(pnlContainer, BorderLayout.CENTER);
        add(pnlTime, BorderLayout.SOUTH);
    }

}
