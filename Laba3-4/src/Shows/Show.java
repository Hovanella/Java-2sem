package Shows;

import ShowTime.ShowTime;

public abstract class Show {

    protected String _name;

    public void set_name(String _name) {
        this._name = _name;
    }

    public void set_showTime(ShowTime _showTime) {
        this._showTime = _showTime;
    }

    protected int _showMinutes;
    protected ShowTime _showTime;

    public int get_showMinutes() {
        return _showMinutes;
    }

    public void set_showMinutes(int showMinutes) {
        _showMinutes = showMinutes;
    }


    public String get_name() {
        return _name;
    }

    public ShowTime get_showTime() {
        return _showTime;
    }


    public Show(String name, int showDuration, ShowTime showTime) {
        this._name = name;
        this._showMinutes = showDuration;
        this._showTime = showTime;
    }

    public Show() {

    }

    public abstract void writeTheTypeOfShow();


}
