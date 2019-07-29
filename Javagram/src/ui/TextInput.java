package ui;

import main.UIResources;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TextInput extends PromptTextField {

    public static final int PHONE_INPUT = 100;
    public static final int NAME_INPUT = 101;
    public static final int FULLNAME_INPUT = 102;

    private final int HEIGHT = 46;

    private Font font;
    private Border border;
    private int width;

    public TextInput(int width, int typeInput, String prompt) {
        super(prompt);
        this.width = width;
        setMargin(new Insets(2, 5, 3, 5));
        setOpaque(false);
        setCaretColor(Color.WHITE);
        font = UIResources.getFont(UIResources.OPEN_SANS_LIGHT);

        switch (typeInput) {
            case PHONE_INPUT:
                border = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE);
                setBorder(border);
                setFont(font.deriveFont(40.0F));
                setPreferredSize(new Dimension(width, HEIGHT));
                setMaximumSize(new Dimension(width, HEIGHT));
                setMinimumSize(new Dimension(width, HEIGHT));
                setDocument(new PhoneFilter());
                setText("+7 ");
                break;
            case NAME_INPUT:
                border = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE);
                setBorder(border);
                setFont(font.deriveFont(34.0F));
                setPreferredSize(new Dimension(width, HEIGHT));
                setMaximumSize(new Dimension(width, HEIGHT));
                setMinimumSize(new Dimension(width, HEIGHT));
                break;
            case FULLNAME_INPUT:
                border = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE);
                setBorder(border);
                setFont(font.deriveFont(34.0F));
                setPreferredSize(new Dimension(width, HEIGHT));
                setMaximumSize(new Dimension(width, HEIGHT));
                setMinimumSize(new Dimension(width, HEIGHT));
                break;
        }
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
        setPreferredSize(new Dimension(width, HEIGHT));
        setMaximumSize(new Dimension(width, HEIGHT));
        setMinimumSize(new Dimension(width, HEIGHT));
    }

    public void setFilter(PlainDocument filter) {
        setDocument(filter);
    }

    public static class TextFilter extends PlainDocument {
        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            char c = str.charAt(0);
            if (Character.isLetter(c) || Character.isSpaceChar(c)) {
                super.insertString(offs, str, a);
            }
        }
    }

    public static class PhoneFilter extends PlainDocument {
        private final String symbols = "()-+";
        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            char c = str.charAt(0);
            if (Character.isDigit(c) || Character.isSpaceChar(c) || symbols.indexOf(c) >= 0) {
                super.insertString(offs, str, a);
            }
        }
    }
}
