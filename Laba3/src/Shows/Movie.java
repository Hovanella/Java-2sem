package Shows;

import ShowTime.ShowTime;

public class Movie extends Show implements AgeRating{
    
    private final int _ageRating;
    
    public Movie(String _name, int _timeInProgram, ShowTime _showTime,int ageRating) {
        super(_name, _timeInProgram, _showTime);
        _ageRating = ageRating;
    }

    @Override
    public void writeTheTypeOfShow() {
        System.out.println("It's Movies");
    }

    @Override
    public void sayYourRating() {
        System.out.println("Age rating is " + _ageRating);
    }
}
