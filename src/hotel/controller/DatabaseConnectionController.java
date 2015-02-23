/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.controller;

import hotel.model.CustomerManagerModel;
import hotel.model.DatabaseConnectionModel;
import hotel.view.CustomerManagerView;
import hotel.view.DatabaseConnectionView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 *
 * @author danielhuynh
 */
public class DatabaseConnectionController 
{
    DatabaseConnectionModel databaseConnectionModel;
    DatabaseConnectionView databaseConnectionView;
    
    public DatabaseConnectionController(DatabaseConnectionModel databaseConnectionModel, DatabaseConnectionView databaseConnectionView)
    {
        this.databaseConnectionModel = databaseConnectionModel;
        this.databaseConnectionView = databaseConnectionView;
        this.databaseConnectionView.addDBConnector(new DBConnectionListener());
    }
    
    class DBConnectionListener implements ActionListener
    {
        String hostName, port, database, username, password;

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            try
            {
                hostName = databaseConnectionView.getHostName();
                port = databaseConnectionView.getPort();
                database = databaseConnectionView.getDatabase();
                username = databaseConnectionView.getUsername();
                password = databaseConnectionView.getPassword();
                databaseConnectionModel.connect(hostName, port, database, username, password);
                databaseConnectionView.setVisible(false);
//                CustomerManagerController cusRegController = new CustomerManagerController(databaseConnectionModel.getConnection(), new CustomerManagerModel(), new CustomerManagerView());
            }
            catch(SQLException | ClassNotFoundException ex)
            {
                System.out.println("Error: " + ex);
            }
        }
    }
}
