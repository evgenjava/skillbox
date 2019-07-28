package core;

import java.util.ArrayList;
import java.util.List;

public class Chat {
    private Contact with;
    private List<Message>  chat = new ArrayList<>();

    public Chat(Contact with) {
        this.with = with;
    }
    public Contact getWith() {
        return with;
    }

    public String getContactName() {
        return with.getName();
    }

    public void addMessage(String msg) {
        chat.add(new Message(msg));
    }

    public List<Message> getMessages() {
        return chat;
    }

    public Message getLastMessage() {
        return chat.get(chat.size() - 1);
    }
}
