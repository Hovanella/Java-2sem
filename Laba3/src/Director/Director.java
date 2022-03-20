import Shows.News;
import Shows.Show;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Director {

    public Optional<Show> findMaxDurationShow(List<Show> showList) {
        return showList.stream().max(Comparator.comparingInt(Show::get_showDuration));
    }

    public Stream<Show> findNews(List<Show> showList) {
        Stream<Show> newsList = showList.stream().filter(x -> x instanceof News);
        return newsList;
    }

    public int findFullDurationOfShowList(List<Show> showList) {
        return showList.stream().reduce(0, (duration, show2) -> duration + show2.get_showDuration(), Integer::sum);
    }
    
    public void sortShowListAccordingToDuration(List<Show> showList){
        showList.sort(Comparator.comparingInt(Show::get_showDuration));
    }
}
