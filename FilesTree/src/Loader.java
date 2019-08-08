import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Loader {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите путь к папке :");
        String path = reader.readLine();
        File file = new File(path);
        printFiles(file, "");


    }

    public static void printFiles(File file, String tabs) {
        File [] fileList = file.listFiles();
        for (File f : fileList) {
            if (f.isDirectory()) {
                System.out.println(tabs + f.getName());
                printFiles(f, tabs + "  ");
            }
            else {

                System.out.println(tabs + f.getName() + " - " + f.length() + " байт");
            }
        }
    }
}
