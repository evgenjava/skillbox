package core;

import java.util.Date;

public class Message {
    private String text;
    private Date time;

    public Message(String text) {
        this.text = text;
        time =new Date();
    }

    public String getText() {
        return text;
    }

    public Date getTime() {
        return time;
    }
}
