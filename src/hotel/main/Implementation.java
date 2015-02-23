/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.main;

import hotel.view.MainView;
import java.sql.SQLException;

/**
 *
 * @author danielhuynh
 */
public class Implementation 
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
//        Connection connection = null;
        try
        {
//            Class.forName("com.mysql.jdbc.Driver");
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "");
//            System.out.println("Successful Connection!!!");
            MainView mainView = new MainView();
//            DatabaseConnectionModel databaseConnectionModel = new DatabaseConnectionModel();
//            DatabaseConnectionView databaseConnectionView = new DatabaseConnectionView();
//            DatabaseConnectionController databaseConnectionController = new DatabaseConnectionController(databaseConnectionModel, databaseConnectionView);
//            CusRegController cusRegController = new CusRegController(databaseConnectionModel.getConnection(), new CusRegModel(), new CusRegView());
//            CusRegController cusRegController = new CusRegController(connection, new CusRegModel(), new CusRegView());            
        }
        catch(ClassNotFoundException | SQLException ex)
        {
            System.out.println("Error: " + ex);
        }
    }
}
