package core;

import java.util.List;

public class Chat {
    private Contact with;
    private List<Message>  chat;

    public Chat(Contact with) {
        this.with = with;
    }

    public Contact getWith() {
        return with;
    }
}
