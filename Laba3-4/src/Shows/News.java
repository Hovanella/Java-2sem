package Shows;

import ShowTime.ShowTime;

import java.io.Serializable;

public class News extends Show implements Serializable {

    public News(String _name, int _showMinutes, ShowTime showTime) throws Exception {
        super(_name, _showMinutes, showTime);

        if (_showMinutes > 1000) {
            throw new Exception("Превышение работы программы");
        }

    }

    public News() {
    }

    @Override
    public void writeTheTypeOfShow() {
        System.out.println("It's News");
    }

    public void setName(String name) {
        _name = name;
    }

    public void setShowTime(ShowTime showTime) {
        _showTime = showTime;
    }

    @Override
    public String toString() {
        return _name + "  " + _showTime + " " + _showMinutes;
    }
}
