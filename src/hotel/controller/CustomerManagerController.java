/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.controller;

import hotel.model.CustomerManagerModel;
import hotel.object.Customer;
import hotel.view.CustomerManagerView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danielhuynh
 */
public class CustomerManagerController 
{
    CustomerManagerModel customerManagerModel;
    CustomerManagerView customerManagerView;
    
    public CustomerManagerController(CustomerManagerModel customerManagerModel, CustomerManagerView customerManagerView) throws SQLException
    {
        this.customerManagerModel = customerManagerModel;
        this.customerManagerView = customerManagerView;
        this.customerManagerView.refreshTable(customerManagerModel.loadCustomer());
        this.customerManagerView.addRegisterListener(new RegisterListener());
        this.customerManagerView.addDeleteListener(new DeleteListener());
        this.customerManagerView.addRefreshTableListener(new RefreshTableListener());
        this.customerManagerView.addEditListener(new EditListener());
    }
    
    class RegisterListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                if(customerManagerView.checkValidData())
                {
                    Customer customer = new Customer(customerManagerView.getFirstName(),
                            customerManagerView.getLastName(), 
                            customerManagerView.getBirthday(),
                            customerManagerView.getAge(),
                            customerManagerView.getGender(),
                            customerManagerView.getPhone(),
                            customerManagerView.getEmail(),
                            customerManagerView.getAddress(),
                            customerManagerView.getCity(),
                            customerManagerView.getStateProvince(),
                            customerManagerView.getZipCode(),
                            customerManagerView.getCountry());
                    customerManagerModel.register(customer);
                    customerManagerView.clearFields();
                    customerManagerView.refreshTable(customerManagerModel.loadCustomer());
                }
            }
            catch(SQLException ex)
            {
                System.out.println("Error: " + ex);
            }
        }
    }
    
    class DeleteListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            try 
            {
                customerManagerModel.deleteCustomer(customerManagerView.getCustomerID());
                customerManagerView.refreshTable(customerManagerModel.loadCustomer());
            } 
            catch (SQLException ex) 
            {
                System.out.println("Error: " + ex);
            }
        }
    }
    
    class EditListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            try
            {
                String cID = customerManagerView.getCustomerID();
                Customer customer = customerManagerView.getCustomer();
                customerManagerModel.editCustomer(cID, customer);
                customerManagerView.refreshTable(customerManagerModel.loadCustomer());
            }
            catch(SQLException|ParseException ex)
            {
                System.out.println("Error: " + ex);
            }
        }
    }
    
    class RefreshTableListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            try 
            {
                customerManagerView.refreshTable(customerManagerModel.loadCustomer());
            } 
            catch (SQLException ex) 
            {
                System.out.println("Error: " + ex);
            }
        }
    }
}
