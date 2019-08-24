import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class Loader {
    public static final String PATH = "https://pngicon.ru/ikonki";

    public static void main(String[] args) throws IOException {
        String htmlFile = "res/png.html";
        Document document = Jsoup.parse(new File(htmlFile), "utf-8");
        Elements elements = document.select("img");
        for (Element element : elements) {
            String attr = element.attr("src");
              URL url;
            if (attr.contains("http")) {
                url = new URL(attr);
            }
            else {
                int index = 0;
                while (!Character.isLetter(attr.charAt(index)))
                    ++index;
                url = new URL(PATH + attr.substring(index));
            }
            System.out.println(url);

            try {
                InputStream inputStream =url.openStream();
                FileOutputStream out = new FileOutputStream(new File("img/" + attr.substring(attr.lastIndexOf("/") + 1)));
                out.write(inputStream.readAllBytes());
                out.flush();
                out.close();

            }
            catch (IOException e) {
                System.out.println();
                System.out.println("--------" + e.getMessage());
            }
        }
    }
}
