/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author danielhuynh
 */
public class DatabaseConnectionModel 
{
    private Connection connection = null;
    public DatabaseConnectionModel()
    {
    }
    
    public void connect(String hostName, String port, String database, String username, String password) throws ClassNotFoundException, SQLException
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + hostName + ":" + port + "/" + database, username  , password);
            System.out.println("Connected to Database Successfully!");
        }
        catch(ClassNotFoundException | SQLException ex)
        {
            System.out.println("Error: " + ex);
        }
    }
    
    public Connection getConnection()
    {
        return connection;
    }
}
