package by.belstu.it.Hovansky.basejava;

import java.util.Objects;

public class StringWrapper {
    private String _content;

    @Override
    public String toString() {
        return "StringWrapper{" +
                "_content='" + _content + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringWrapper that = (StringWrapper) o;
        return Objects.equals(_content, that._content);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(_content);
    }

    public void set_content(String _content) {
        this._content = _content;
    }

    public String get_content() {
        return _content;
    }

    public StringWrapper(String _content) {
        this._content = _content;
    }
    
    public void replace(char oldchar, char newchar) {
        _content.replace(oldchar,newchar);
    }
}
