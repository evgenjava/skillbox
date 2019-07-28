package ui;

import core.Message;

import java.awt.*;

public class MessageInPanel extends MessagePanel {

    public MessageInPanel(Message message) {
        super(message, MessagePanel.IN);
        pnlContainer.add(triangle, BorderLayout.WEST);
        pnlContainer.add(pnlMessage, BorderLayout.CENTER);
        add(pnlContainer, BorderLayout.CENTER);
        add(pnlTime, BorderLayout.SOUTH);
    }

}
