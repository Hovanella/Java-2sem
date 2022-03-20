package XmlSaxParser;

import ShowTime.ShowTime;
import Shows.News;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Sax extends DefaultHandler {
     News news = new News();
    String thisElement = "";

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        thisElement = qName;
    }

    public News getResult()
    {
        return news;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (thisElement.equals("name")) {
            news.setName(new String(ch, start, length));
        }
        else if(thisElement.equals("showMinutes"))
        {
            news.set_showMinutes(Integer.parseInt(new String(ch, start, length)));
        }
        else if (thisElement.equals("showTime")) {
            String showTimeString = new String(ch, start, length);
            
            
             var ShowTimeCasesToString = new String[] { ShowTime.Night.toString(),ShowTime.Daytime.toString(),ShowTime.Evening.toString(),ShowTime.Morning.toString()};
             
            
            switch (showTimeString) {
                case "Night" :news.setShowTime(ShowTime.Night); break;  
                case "Morning" :news.setShowTime(ShowTime.Morning); break;
                case "Evening" :news.setShowTime(ShowTime.Evening); break;
                case "DayTime" :
                default:news.setShowTime(ShowTime.Daytime);break;
            }
        }

    }
    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        thisElement = "";
    }
}