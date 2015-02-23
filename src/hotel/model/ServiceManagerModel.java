/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.model;

import hotel.object.Service;
import hotel.object.TableVectors;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author danielhuynh
 */
public class ServiceManagerModel 
{
    private Connection connection = null;
    public ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;
//    private Hashtable services;
    
    public ServiceManagerModel(Connection connection)
    {
        this.connection = connection;
    }
    
    public void addService(Service service) throws SQLException
    {
        preparedStatement = connection.prepareStatement("INSERT INTO Service (sName, category, detail, price, inventoryQuantity) VALUES (?, ?, ?, ?, ?)");
        preparedStatement.setString(1, service.getName());
        preparedStatement.setString(2, service.getCategory());
        preparedStatement.setString(3, service.getDetail());
        preparedStatement.setDouble(4, service.getPrice());
        preparedStatement.setLong(5, service.getInventoryQuantity());
        preparedStatement.execute();
    }
    
    public TableVectors loadService() throws SQLException
    {
        preparedStatement = connection.prepareStatement("SELECT * FROM Service");
        resultSet = preparedStatement.executeQuery();
        return new TableVectors(resultSet);
    }
    
    public void deleteService(String ID) throws SQLException
    {
        preparedStatement = connection.prepareStatement("DELETE FROM Service WHERE sID = " + ID +";");
        preparedStatement.execute();
    }
    
    public void editService(String sID, Service service) throws SQLException
    {
        preparedStatement = connection.prepareStatement("UPDATE Service SET sName = '" + service.getName() 
                + "',category = '" + service.getCategory() 
                + "', detail = '" + service.getDetail() 
                + "', price = " + service.getPrice() 
                + ", inventoryQuantity = " + service.getInventoryQuantity() 
                + " WHERE sID = " + sID);
        preparedStatement.execute();
    }
    
    public TableVectors searchService(String serviceName) throws SQLException
    {
        preparedStatement = connection.prepareStatement("SELECT * FROM Service WHERE sName REGEXP '^" + serviceName +"';");
        resultSet = preparedStatement.executeQuery();
        return new TableVectors(resultSet);
    }

}