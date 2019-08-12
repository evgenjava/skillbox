import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Loader {

    private static final String path = "files/data.txt";

    public static void main(String[] args) throws IOException {
        List<String> strings = readFile();
        String[][] dataArray = new String[strings.size()][];
        for (int i = 0; i < strings.size(); i++) {
            String[] ss = strings.get(i).split("\t");
            dataArray[i] = ss;
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("%s\t", ss[0]));
            for (int j = 1; j < ss.length; j++) {
                if (ss[j].length() < 4) {
                    sb.append(String.format("|\t%s\t\t\t", ss[j]));
                }
                else if (ss[j].length() < 8) {
                    sb.append(String.format("|\t%s\t\t", ss[j]));
                }
                else {
                    sb.append(String.format("|\t%s\t", ss[j]));
                }
            }

            System.out.println(sb.toString());
        }


    }

    public static List<String> readFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line;
        List<String> strs = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            strs.add(line);
        }
        return strs;
    }
}
