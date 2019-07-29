package main;

import core.Chat;
import core.Contact;
import core.Message;
import core.UserProfile;

import java.util.ArrayList;

public class App {

    public static String[] names = {"Андрей Пертров", "Петр Сергеев", "Дмитрий Петров", "Екатерина Смиронва" };
    private UserProfile user;
    private ArrayList<Chat> chatList;
    private static App instance;

    private App() {
        user = new UserProfile();
        user.setFirstName("Вадим");
        user.setLastName("Иванов");
        user.setPhoneNumber("+7(926) 206-89-89");
        chatList = createChatList();
    }

    public UserProfile getUser() {
        return user;
    }
    public ArrayList<Chat> getChatList() {
        return chatList;
    }

    private ArrayList<Chat> createChatList() {
        ArrayList<Chat> list = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            Chat chat = new Chat(new Contact(names[i], "+7999212-55-49"));
            chat.setOnline( i % 2 > 0);
            for (int j = 0; j < 5; j++) {
                if ( j % 2 > 0) {
                    chat.addMessage(new Message("Input message " + (j + i), Message.INPUT));
                }
                else {
                    chat.addMessage(new Message("Output message " + (j + i), Message.OUTPUT));
                }
            }
            list.add(chat);
        }
        return list;
    }

    public static App getInstance() {
        if (instance == null) {
            instance = new App();
        }
        return instance;
    }
}
