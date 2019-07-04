package ui;

import main.UIResources;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class WelcomPane extends JTextPane {

    private Font font;

    public WelcomPane(Dimension size, String message) {
        loadFont(UIResources.OPEN_SANS_LIGHT);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setOpaque(false);
        setMargin(new Insets(10, 10, 10, 10));
        setForeground(Color.WHITE);
        setEditable(false);
        setText(message);
        StyledDocument doc = getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
    }

    private void loadFont(String fontName) {
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File(fontName));
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setFontSize(float size) {
        setFont(font.deriveFont(size));
    }

}
