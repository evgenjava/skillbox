import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class Loader {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите адрес сайта откуда загружать картинки : ");
        String path = reader.readLine().trim();
        if (path.charAt(path.length() - 1) != '/') {
            path = path + "/";
        }
        Document document = Jsoup.parse(new URL(path), 10000);
        Elements elements = document.select("img");
        for (Element element : elements) {
            String attr = element.attr("src");
              URL url;
            if (attr.contains("http")) {
                url = new URL(attr);
            }
            else {
                int index = 0;
                while (!Character.isLetterOrDigit(attr.charAt(index)))
                    ++index;
                url = new URL(path + attr.substring(index));


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
                System.out.println("Не удалось открыть - " + e.getMessage());
            }
        }
    }
}
