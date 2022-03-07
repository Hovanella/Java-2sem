package Shows;

import ShowTime.ShowTime;

public abstract class Show {
    
    private final String _name;

    public int get_showDuration() {
        return _showDuration;
    }

    private final int _showDuration;
    private final ShowTime _showTime;

    public Show(String name, int showDuration, ShowTime showTime) {
        this._name = name;
        this._showDuration = showDuration;
        this._showTime = showTime;
    }
    
    public abstract void writeTheTypeOfShow();

  
}
