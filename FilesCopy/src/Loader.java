import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Loader {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите путь к папке откуда будут копироваться файлы : ");
        String pathFrom = reader.readLine();
        System.out.println("Введите путь к папке куда будут копироваться файлы : ");
        String pathTo = reader.readLine();
        //File file = new File(pathFrom);
        //System.out.println(file.getPath());
        copyFiles(pathFrom, pathTo);
    }

    public static void copyFiles(String source, String target) throws IOException {
        File [] fileList = new File(source).listFiles();
        if (!Files.exists(Paths.get(target))) {
            Files.createDirectory(Paths.get(target));
        }
        for (File f : fileList) {
            if (f.isDirectory()) {
                copyFiles(f.getPath(), target + "/" + f.getName());
            }
            else {
                System.out.println(source + "/" + f.getName() + " --> " + target);

                Files.copy(Paths.get(source + "/" + f.getName()), Paths.get(target + "/" + f.getName()),
                        StandardCopyOption.REPLACE_EXISTING);
            }
        }
    }
}
