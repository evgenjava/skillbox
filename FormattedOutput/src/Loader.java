import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Loader {

    private static final String file = "files/data.txt";
    private static final String formattedFile = "files/data-formatted.txt";

    public static void main(String[] args) throws IOException {
        List<String> strings = readFile();
        writeFile(strings);
        System.out.println("Данные отформатированы");
    }

    public static List<String> readFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        List<String> strList = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            strList.add(line);
        }
        reader.close();
        return strList;
    }

    public static void writeFile(List<String> data) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(formattedFile));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.size(); i++) {
            String[] ss = data.get(i).split("\t");
            for (int j = 0; j < ss.length; j++) {
                if (j == 0) {
                    sb.append(String.format(getFormat("", ss[j].length()), ss[j]));
                }
                else {
                    sb.append(String.format(getFormat("|", ss[j].length()), ss[j]));
                }
            }
            System.out.println(sb.toString());
            sb.append("\n");
            writer.write(sb.toString(), 0, sb.toString().length());
            sb.setLength(0);
        }
        writer.flush();
        writer.close();
    }

    public static String getFormat(String sep, int len) {
        StringBuilder sb = new StringBuilder();
        if (!sep.isEmpty()) {
            sb.append(sep + "\t");
        }
        if (len == 0) {
            sb.append("\t\t\t\t");
        }
        else if (len > 0 && len < 4) {
            sb.append("%s\t\t\t");
        }
        else if (len >= 4 && len < 8) {
            sb.append("%s\t\t");
        }
        else {
            sb.append("%s\t");
        }
        return sb.toString();
    }
}
