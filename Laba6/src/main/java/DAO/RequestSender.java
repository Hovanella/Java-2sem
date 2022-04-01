package DAO;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RequestSender {
    
    Connection connection = null;
    static final Logger logger = LogManager.getLogger(RequestSender.class);

    public RequestSender(Connection connection) {
        this.connection = connection;
    }

    public ResultSet SendRequest(String strSql) {
        try {
            var query = connection.createStatement();
            ResultSet rs = query.executeQuery(strSql);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void ShowWeatherForecastOfRegion() throws SQLException {
        
        
        var responseString = SendRequest("SELECT * FROM WeatherForecast Where RegionID = 1");


        System.out.print("Date        ");
        System.out.print("PrecipitationAmount    ");
        System.out.print("Temperature(C)  ");
        System.out.println();
        while (responseString.next()) {
            System.out.print(responseString.getString("ForecastDate") + "          ");
            System.out.print(responseString.getString("PrecipitationAmount")+ "                ");
            System.out.print(responseString.getString("Temperature")+ "  ");
            System.out.println();
        }
        System.out.println();
        logger.info("SQl request one done");
    }

    public void ShowDatesWhenSnowWasInCurrentRegion() throws SQLException {

      /*  Вывести даты, когда в заданном регионе шел снег и температура была
        ниже заданной отрицательной*/

        var responseString = SendRequest("SELECT * FROM WeatherForecast Where RegionID = 2 and PrecipitationAmount ='snow' and Temperature < 0");
        
        System.out.println("Date        ");
        while (responseString.next()) {
            System.out.print(responseString.getString("ForecastDate") + "       ");
            System.out.println();
        }
        
    }

    public void req3(String tema) throws SQLException {

        /*Вывести информацию о погоде за прошедшую неделю в регионах,
                жители которых общаются на заданном языке.*/
        
        var str = "select distinct [ФИО], [Дата Рождения]\n" +
                "from People join Letters\n" +
                "    ON People.ФИО = Letters.Отправитель\n" +
                "WHERE Letters.[Тема Письма]=?";
        
        var st = connection.prepareStatement(str);
        st.setString(1, tema);
        var rs = st.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("ФИО") + " " + rs.getString("Дата Рождения"));

        }
        System.out.println();
        logger.info("SQl request three done");

    }

    public void req4(String tema) throws SQLException {
        var str = "select distinct [ФИО], [Дата Рождения]\n" +
                "from People join Letters\n" +
                "    ON People.ФИО = Letters.Отправитель\n" +
                "WHERE NOT Letters.[Тема Письма]=?";
        var st = connection.prepareStatement(str);
        st.setString(1, tema);
        var rs = st.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("ФИО") + " " + rs.getString("Дата Рождения"));

        }
        System.out.println();
        logger.info("SQl request four done");


    }

    public void req5(String Name, String Tema) throws SQLException {
        var allNames = new ArrayList<String>();
        var rs = SendRequest("SELECT [ФИО] from People");
        while (rs.next()) {
            allNames.add(rs.getString("ФИО"));
        }
        var st = connection.prepareStatement("insert into Letters VALUES(?, ?, ?, ?, '2022-05-21')");

        for (var name : allNames) {
            st.setString(1, Name);
            st.setString(2, name);
            st.setString(3, Tema);
            st.setString(4, "SPAM MESSAGE");
            st.executeUpdate();

        }
        logger.info("SQl request five done");

    }

}
