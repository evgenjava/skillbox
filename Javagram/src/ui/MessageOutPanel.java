package ui;

import core.Message;

import java.awt.*;

public class MessageOutPanel extends MessagePanel {

    public MessageOutPanel(Message message) {
        super(message, MessagePanel.OUT);
        pnlContainer.add(triangle, BorderLayout.EAST);
        pnlContainer.add(pnlMessage, BorderLayout.CENTER);
        add(pnlContainer, BorderLayout.CENTER);
        add(pnlTime, BorderLayout.SOUTH);
    }

}
