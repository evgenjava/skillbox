import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class Loader {

    public static final String PATH = "https://course.skillbox.ru/webdev/";
    public static void main(String[] args) throws IOException {
        String htmlFile = "res/webdev.html";
        Document  document = Jsoup.parse(new File(htmlFile), "utf-8");
        Elements elements = document.select("img");
        for (Element element : elements) {
            String attr = element.attr("src");
            if (attr.contains("http")) {
                System.out.println(attr);
            }
            else {
                int index = attr.indexOf("./");
                System.out.println(PATH + attr.substring(index + 2));
            }
        }
    }
}
