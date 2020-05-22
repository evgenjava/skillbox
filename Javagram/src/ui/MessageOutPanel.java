package ui;

import core.Message;

import java.awt.*;

public class MessageOutPanel extends MessagePanel {


    public MessageOutPanel(Message message,int widthParent) {
        super(message, MessagePanel.OUT);
        setComponentSize(this, new Dimension(widthParent, height + 14));
        pnlContainer.add(triangle, BorderLayout.EAST);
        pnlContainer.add(pnlMessage, BorderLayout.CENTER);
        sPanel.add(pnlContainer, BorderLayout.CENTER);
        sPanel.add(pnlTime, BorderLayout.SOUTH);
        add(sPanel, BorderLayout.EAST);
    }

}
