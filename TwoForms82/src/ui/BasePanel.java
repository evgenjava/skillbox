package ui;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public abstract class BasePanel extends JPanel {

    public abstract String[] getData();
    public abstract void setData(String[] data);

    public static class TextFilter extends PlainDocument {
        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            char c = str.charAt(0);
            if (Character.isLetter(c) || Character.isSpaceChar(c)) {
                super.insertString(offs, str, a);
            }
        }
    }

}
