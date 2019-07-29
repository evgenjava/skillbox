package core;

import java.util.ArrayList;
import java.util.List;

public class Chat {
    private Contact with;
    private ArrayList<Message>  chat = new ArrayList<>();
    private boolean isOnline = false;

    public Chat(Contact with) {
        this.with = with;
    }
    public Contact getWith() {
        return with;
    }

    public String getContactName() {
        return with.getName();
    }

    public void addMessage(Message msg) {
        chat.add(msg);
    }

    public ArrayList<Message> getMessages() {
        return chat;
    }

    public Message getLastMessage() {
        return chat.size() > 0 ? chat.get(chat.size() - 1) : null;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }
}
