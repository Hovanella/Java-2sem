import ShowTime.ShowTime;
import Shows.Advertising;
import Shows.Movie;
import Shows.News;
import Shows.Show;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.util.ArrayList;

public class Main {

    static {
        new DOMConfigurator().doConfigure("log/log4j.xml", LogManager.getLoggerRepository());
    }
        
    private static final Logger LOG = Logger.getLogger(Main.class);


    public static void main(String[] args) {
        LOG.info("Starting program_____________________________");

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
            System.out.println(director.findMaxDurationShow(showList).get().get_showDuration());
            System.out.println(director.findFullDurationOfShowList(showList));
            director.findNews(showList).forEach(Show::writeTheTypeOfShow);
            director.sortShowListAccordingToDuration(showList);

            showList.forEach(Show::writeTheTypeOfShow);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
