import org.javagram.TelegramApiBridge;
import org.javagram.response.AuthCheckedPhone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Loader {

    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        TelegramApiBridge bridge = new TelegramApiBridge("149.154.167.50:443", 719857,
                "116418fc8fe7c94af47225f0860cf85d");


        System.out.println("Введите номер телефона: ");
        AuthCheckedPhone checkPhone = bridge.authCheckPhone(console.readLine().trim());

        System.out.println("Зарегистрирован? - " + checkPhone.isRegistered());
        System.out.println("Приглашен? - " + checkPhone.isInvited());
    }
}
