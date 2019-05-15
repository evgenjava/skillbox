import org.javagram.TelegramApiBridge;
import org.javagram.response.AuthAuthorization;
import org.javagram.response.AuthCheckedPhone;
import org.javagram.response.AuthSentCode;
import org.javagram.response.object.User;
import org.javagram.response.object.UserContact;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Loader {

        public static String phoneNumber;
        public static final int appId = 719857;
        public static final String appHash = "116418fc8fe7c94af47225f0860cf85d";

        public static void main(String[] args) throws IOException {

            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

            TelegramApiBridge bridge = new TelegramApiBridge("149.154.167.40:443", appId ,
                appHash);

            //System.out.println("Введите номер телефона: ");
            //Все мои номера в Telegram заблокированы.........
            phoneNumber = "9996624444";//console.readLine().trim();
            AuthCheckedPhone checkPhone = bridge.authCheckPhone(phoneNumber);

            System.out.println("Зарегистрирован? - " + checkPhone.isRegistered());
            System.out.println("Приглашен? - " + checkPhone.isInvited());

            AuthSentCode sentCode = bridge.authSendCode(phoneNumber);

            //System.out.println("Введите код :");
            String code = "22222";//console.readLine().trim();

            AuthAuthorization authAuthorization = bridge.authSignIn(code);
            User user = authAuthorization.getUser();

            System.out.println("Имя     :" + user.getFirstName());
            System.out.println("Фамилия :" + user.getLastName());
            System.out.println("Телефон :" + user.getPhone());

            ArrayList<UserContact> contacts = bridge.contactsGetContacts();
            for (UserContact uc : contacts) {
                System.out.println(user.getFirstName() + " " + uc.getLastName() + " : " + uc.getPhone());
            }
            
    }
}
