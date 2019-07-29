package core;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Contact {
    private String name;
    private String phone;
    private BufferedImage avatar;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }
}
