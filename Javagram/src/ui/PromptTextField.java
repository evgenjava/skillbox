package ui;

import main.UIResources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class PromptTextField extends JTextField implements FocusListener {

    private String prompt;
    private boolean showPrompt;

    public PromptTextField(String prompt) {
        super(prompt);
        this.prompt = prompt;
        this.showPrompt = !prompt.isEmpty();
        if (this.showPrompt) {
            setForeground(UIResources.PROMPT_COLOR);
        }
        else {
            setForeground(Color.WHITE);
        }
        super.addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (this.getText().isEmpty()) {
            setForeground(Color.WHITE);
            super.setText("");
            showPrompt = false;
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (this.getText().isEmpty()) {
            setForeground(UIResources.PROMPT_COLOR);
            super.setText(prompt);
            showPrompt = true;
        }
    }

    @Override
    public String getText() {
        return showPrompt ? "" : super.getText();
    }
}
