/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.controller;

import hotel.model.ServiceManagerModel;
import hotel.object.CertaintyChecker;
import hotel.object.Service;
import hotel.object.TableVectors;
import hotel.view.ServiceManagerView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author danielhuynh
 */
public class ServiceManagerController 
{
    ServiceManagerModel serviceManagerModel = null;
    ServiceManagerView serviceManagerView = null;
    ResultSet resultSet = null;
    
    public ServiceManagerController(ServiceManagerModel serviceManagerModel, ServiceManagerView serviceManagerView) throws SQLException
    {
        this.serviceManagerModel = serviceManagerModel;
        this.serviceManagerView = serviceManagerView;
        this.serviceManagerView.addAddServiceListener(new AddServiceListener());
        this.serviceManagerView.addRefreshTableListener(new TableRefreshListener());
        this.serviceManagerView.addDeleteServiceListener(new DeleteServiceListener());
        this.serviceManagerView.addEditServiceListener(new EditServiceListener());
        this.serviceManagerView.addSearchServiceListener(new SearchServiceListner());
        this.serviceManagerView.refreshTable(serviceManagerModel.loadService());
    }
    
    class AddServiceListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if(serviceManagerView.checkServiceFieldsValidity())
            {
                Service service = new Service(serviceManagerView.getServiceName(),
                serviceManagerView.getCategoryComboBox(),
                serviceManagerView.getServiceDetail(),
                serviceManagerView.getUnitPrice(),
                serviceManagerView.getAvailableQuantity());
                try 
                {
                    serviceManagerModel.addService(service);
                    serviceManagerView.refreshTable(serviceManagerModel.loadService());
                } 
                catch (SQLException ex) 
                {
                    System.out.println("Error: " + ex);
                }
                serviceManagerView.clearFields();
            }
        }
    }
    
    class DeleteServiceListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if(CertaintyChecker.checkCertainty(serviceManagerView))
            {
                if(serviceManagerView.checkEditOrDeleteValidity())
                {
                    try {
                        serviceManagerModel.deleteService(serviceManagerView.getServiceID());
                        serviceManagerView.refreshTable(serviceManagerModel.loadService());
                    } catch (SQLException ex) 
                    {
                        System.out.println("Error: " + ex);
                    }
                }
            }
        }
    }
    
    class EditServiceListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if(CertaintyChecker.checkCertainty(serviceManagerView))
            {
                if(serviceManagerView.checkEditOrDeleteValidity())
                {
                    String sID = serviceManagerView.getServiceID();
                    Service service = serviceManagerView.getService();
                    try {
                        serviceManagerModel.editService(sID, service);
                        serviceManagerView.refreshTable(serviceManagerModel.loadService());
                    }
                    catch (SQLException ex) 
                    {
                        System.out.println("Error: " + ex);
                    }
                }
            }
        }
    }
    
    class SearchServiceListner implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            try
            {
                TableVectors tableVectors = serviceManagerModel.searchService(serviceManagerView.getServiceNameForSearch());
                serviceManagerView.refreshTable(tableVectors);
                serviceManagerView.clearSearchField();
            } 
            catch (SQLException ex) 
            {
                System.out.println("Error: " + ex);
            }
        }
        
    }
    
    class TableRefreshListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e1) 
        {
            try 
            {
                serviceManagerView.refreshTable(serviceManagerModel.loadService());
            }
            catch (SQLException ex) 
            {
                System.out.println("Error: " + ex);
            }
        }
    }
}
