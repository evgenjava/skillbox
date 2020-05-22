package ui;

import core.Contact;
import main.UIResources;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatItemPanel extends JPanel {

    public static final int OFFLINE = 100;
    public static final int SELECTED_OFFLINE = 101;
    public static final int ONLINE = 102;
    public static final int SELECTED_ONLINE = 103;

    private final DateFormat format = new SimpleDateFormat("dd.MM.YY");

    private final int height = 60;
    private FacePanel pnlFace;
    private JPanel pnlContainer = new JPanel(new BorderLayout());
    private JTextPane paneName = new JTextPane();
    private JTextPane paneText = new JTextPane();
    private JLabel lblTime = new JLabel();
    private Font lightFont = UIResources.getFont(UIResources.OPEN_SANS_LIGHT);
    private Font regularFont = UIResources.getFont(UIResources.OPEN_SANS_SEMIBOLD);


    public ChatItemPanel(Contact contact, int state) {
        setLayout(new BorderLayout());
        setComponentSize(this, new Dimension(1000, height));
        setBorder(BorderFactory.createMatteBorder(1,1, 1, 1, UIResources.GRAY_COLOR2));
        paneName.setText(contact.getName());
        setComponentSize(paneName, new Dimension(1000, height / 2));
        paneName.setFont(regularFont.deriveFont(16.0F));
        paneText.setFont(lightFont.deriveFont(12.0F));
        lblTime.setFont(lightFont.deriveFont(10.0F));
        pnlContainer.add(paneName, BorderLayout.NORTH);
        pnlContainer.add(paneText, BorderLayout.CENTER);
        add(pnlContainer, BorderLayout.CENTER);
        switch(state) {
            case OFFLINE :
                pnlFace = new FacePanel(FacePanel.MASK_GRAY);
                setComponentsBackground(UIResources.GRAY_COLOR);
                setBackground(UIResources.GRAY_COLOR);
                add(lblTime, BorderLayout.EAST);
                break;
            case SELECTED_OFFLINE :
                pnlFace = new FacePanel(FacePanel.MASK_WHITE);
                setComponentsBackground(Color.WHITE);
                setBackground(Color.WHITE);
                setBorder(BorderFactory.createMatteBorder(0,0, 0, 5, UIResources.LIGHT_BLUE_COLOR));
                break;
            case ONLINE :
                pnlFace = new FacePanel(FacePanel.MASK_GRAY_ONLINE);
                setComponentsBackground(UIResources.GRAY_COLOR);
                setBackground(UIResources.GRAY_COLOR);
                add(lblTime, BorderLayout.EAST);
                break;
            case SELECTED_ONLINE :
                pnlFace = new FacePanel(FacePanel.MASK_WHITE_ONLINE);
                setComponentsBackground(Color.WHITE);
                setBackground(Color.WHITE);
                setBorder(BorderFactory.createMatteBorder(0,0, 0, 5, UIResources.LIGHT_BLUE_COLOR));
                break;
        }
        pnlFace.setActualSize(new Dimension(60, height));
        add(pnlFace, BorderLayout.WEST);
    }

    private void setComponentsBackground(Color color) {
        pnlContainer.setBackground(color);
        paneText.setBackground(color);
        paneName.setBackground(color);
        lblTime.setBackground(color);
    }

    private void setComponentSize(JComponent component, Dimension size) {
        component.setMaximumSize(size);
        component.setMinimumSize(size);
        component.setPreferredSize(size);
    }

    public String formatTime(Date time) {
        return format.format(time);
    }

    public void setLastTime(Date time) {
        lblTime.setText(formatTime(time));
    }

    public void setText(String text) {
        paneText.setText(text);
    }
}
