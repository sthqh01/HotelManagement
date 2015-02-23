/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.model;

import hotel.object.Customer;
import hotel.object.TableVectors;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author danielhuynh
 */
public class CustomerManagerModel
{
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    public CustomerManagerModel(Connection connection)
    {
        this.connection = connection;
    }
    
    public void register(Customer customer) throws SQLException
    {
        preparedStatement = connection.prepareStatement("INSERT INTO Customer (firstName, lastName, birthday, age, gender, phoneNumber, email, address, city, state, zipcode, country) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
        preparedStatement.setString(1, customer.getFirstName());
        preparedStatement.setString(2, customer.getLastName());
        preparedStatement.setDate(3, new java.sql.Date(customer.getBirthday().getTime()));
        preparedStatement.setInt(4, customer.getAge());
        preparedStatement.setString(5, customer.getGender());
        preparedStatement.setString(6, customer.getPhoneNumber());
        preparedStatement.setString(7, customer.getEmail());
        preparedStatement.setString(8, customer.getAddress());
        preparedStatement.setString(9, customer.getCity());
        preparedStatement.setString(10, customer.getStateProvince());
        preparedStatement.setString(11, customer.getZipcode());
        preparedStatement.setString(12, customer.getCountry());
        preparedStatement.executeUpdate();
    }
    
    public void deleteCustomer(String ID) throws SQLException
    {
        preparedStatement = connection.prepareStatement("DELETE FROM Customer WHERE ID = " + ID +";");
        preparedStatement.execute();
    }
    
    public TableVectors loadCustomer() throws SQLException
    {
        preparedStatement = connection.prepareStatement("SELECT * FROM Customer;");
        ResultSet resultSet = preparedStatement.executeQuery();
        return new TableVectors(resultSet);
    }
    
    public void editCustomer(String cID, Customer customer) throws SQLException
    {
        preparedStatement = connection.prepareStatement("UPDATE Customer SET firstName = '" + customer.getFirstName() 
                + "',lastName = '" + customer.getLastName() 
                + "', birthday = '" + new java.sql.Date(customer.getBirthday().getTime())
                + "', age = " + customer.getAge() 
                + ", gender = '" + customer.getGender() 
                + "', phoneNumber = '" + customer.getPhoneNumber() 
                + "', email = '" + customer.getEmail() 
                + "', address = '" + customer.getAddress() 
                + "', city = '" + customer.getCity() 
                + "', state = '" + customer.getStateProvince() 
                + "', zipcode = '" + customer.getZipcode() 
                + "', country = '" + customer.getCountry() 
                + "' WHERE cID = " + cID);
        preparedStatement.execute();
    }
}
