package org.example;

import DAO.DAOConnectionManager;
import DAO.RequestSender;

import java.sql.SQLException;


public class App 
{
    public static void main( String[] args ) throws SQLException {
        System.out.println( "Hello World!" );
        
        var sqlConnetion = new DAOConnectionManager().Connect();
        
        var requestSender = new RequestSender(sqlConnetion);
        
        requestSender.ShowWeatherForecastOfRegion();
        
        requestSender.ShowDatesWhenSnowWasInCurrentRegion();
    }
}
