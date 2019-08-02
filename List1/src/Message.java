import java.util.Date;

public class Message {
    public static final int INPUT = 0;
    public static final int OUTPUT = 1;

    private String text;
    private Date time;
    private int type;

    public Message(String text, int type) {
        this.text = text;
        time =new Date();
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public Date getTime() {
        return time;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
