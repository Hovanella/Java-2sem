package Shows;

import ShowTime.ShowTime;

public class Advertising extends Show{
    
    public Advertising(String _name, int _timeInProgram, ShowTime _showTime) {
        super(_name, _timeInProgram, _showTime);
    }

    @Override
    public void writeTheTypeOfShow() {
        System.out.println("It's Advertising");
    }
}
