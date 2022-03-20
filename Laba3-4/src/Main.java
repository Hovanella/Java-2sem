import Director.Director;
import ShowTime.ShowTime;
import Shows.Advertising;
import Shows.Movie;
import Shows.News;
import Shows.Show;
import XmlSaxParser.Sax;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static {
        new DOMConfigurator().doConfigure("log/log4j.xml", LogManager.getLoggerRepository());
    }

    private static final Logger LOG = Logger.getLogger(Main.class);


    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        LOG.info("Starting program_____________________________");
        Laba3();
        Laba4();
    }

    public static void Laba3() {
        try {
            Show firstMovie = new Movie("Batman", 100, ShowTime.Evening, 18);
            Show firstNews = new News("News", 120, ShowTime.Morning);
            Show firstAdvertising = new Advertising("Colgate", 5, ShowTime.Daytime);

            firstMovie.writeTheTypeOfShow();
            firstNews.writeTheTypeOfShow();
            firstAdvertising.writeTheTypeOfShow();
            ((Movie) firstMovie).sayYourRating();


            var showList = new ArrayList<Show>();
            showList.add(firstMovie);
            showList.add(firstNews);
            showList.add(firstAdvertising);

            Director director = new Director();
            System.out.println(director.findMaxDurationShow(showList).get().get_showMinutes());
            System.out.println(director.findFullDurationOfShowList(showList));
            director.findNews(showList).forEach(Show::writeTheTypeOfShow);
            director.sortShowListAccordingToDuration(showList);

            showList.forEach(Show::writeTheTypeOfShow);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Laba4() throws ParserConfigurationException, SAXException, IOException {

        System.out.println("-----SAX-----");
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        Sax sax = new Sax();
        parser.parse(new File("files/Shows.xml"), sax);
        News news = sax.getResult();
        System.out.println(news.toString());


        System.out.println("-----XML Serialize-----");
        FileOutputStream xmlOut = new FileOutputStream("files/info.xml");
        XMLEncoder xmlEncoder = new XMLEncoder(xmlOut);
        xmlEncoder.writeObject(news);
        xmlEncoder.close();
        LOG.info("XML serialized");


        System.out.println("-----XML Deserialize-----");
        FileInputStream xmlIn = new FileInputStream("files/info.xml");
        XMLDecoder xmlDecoder = new XMLDecoder(xmlIn);
        News newsFromFile = (News) xmlDecoder.readObject();
        xmlDecoder.close();
        System.out.println(newsFromFile.toString());
        LOG.info("XML deserialized");


        System.out.println("-----JSON Serialize-----");
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(news);
        System.out.println(json);
        FileOutputStream jsonOut = new FileOutputStream("files/info.json");
        byte[] outText = json.getBytes(StandardCharsets.UTF_8);
        jsonOut.write(outText, 0, outText.length);
        LOG.info("JSON serialized");

        System.out.println("-----JSON Deserialize-----");
        Scanner scanner = new Scanner(new File("files/info.json"));
        StringBuilder result = new StringBuilder();
        while (scanner.hasNext())
            result.append(scanner.nextLine());
        scanner.close();
        News jsonNews = gson.fromJson(result.toString(), News.class);
        System.out.println(jsonNews.toString());
        LOG.info("JSON deserialized");
    }

}
