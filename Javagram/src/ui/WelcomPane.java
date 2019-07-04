package ui;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;

public class WelcomPane extends JTextPane {

    public WelcomPane(Dimension size) {
        setPreferredSize(size);
        setOpaque(false);
        setMargin(new Insets(10, 10, 10, 10));
        setForeground(Color.WHITE);
        setText("Some text message");
        StyledDocument doc = getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
    }

    @Override
    public void setFont(Font font) {
        super.setFont(font);
    }

    @Override
    public void setText(String t) {
        super.setText(t);
    }
}
