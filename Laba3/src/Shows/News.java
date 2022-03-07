package Shows;

import ShowTime.ShowTime;

public class News extends Show {

    public News(String _name, int _showMinutes, ShowTime showTime) throws Exception {
        super(_name, _showMinutes, showTime);
        
        if (_showMinutes > 1000){
            throw new Exception("Превышение работы программы");
        }
      
    }

    @Override
    public void writeTheTypeOfShow() {
        System.out.println("It's News");
    }
}
