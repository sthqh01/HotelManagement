/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.view;

import hotel.controller.CustomerManagerController;
import hotel.controller.ServiceManagerController;
import hotel.model.CustomerManagerModel;
import hotel.model.ServiceManagerModel;
import hotel.object.RGBGrayFilter;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

/**
 *
 * @author danielhuynh
 */
public class MainView extends javax.swing.JFrame {

    /**
     * Creates new form MainView
     */
    Connection connection = null;
    public MainView() throws ClassNotFoundException, SQLException 
    {
        initComponents();
        this.setVisible(true);
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "");
        System.out.println("Successful Connection!!!");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        customerButton1 = new javax.swing.JButton();
        customerButton = new javax.swing.JButton();
        serviceButton = new javax.swing.JButton();
        customerButton2 = new javax.swing.JButton();
        customerButton3 = new javax.swing.JButton();
        mainTabbedPane = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1280, 768));

        jToolBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToolBar1.setRollover(true);

        customerButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/room.png"))); // NOI18N
        customerButton1.setText("Room");
        customerButton1.setFocusable(false);
        customerButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        customerButton1.setMaximumSize(new java.awt.Dimension(80, 80));
        customerButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        customerButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(customerButton1);

        customerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/customer.png"))); // NOI18N
        customerButton.setText("Customer");
        customerButton.setFocusable(false);
        customerButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        customerButton.setMaximumSize(new java.awt.Dimension(80, 80));
        customerButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        customerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(customerButton);

        serviceButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/service.png"))); // NOI18N
        serviceButton.setText("Service");
        serviceButton.setFocusable(false);
        serviceButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        serviceButton.setMaximumSize(new java.awt.Dimension(80, 80));
        serviceButton.setPreferredSize(new java.awt.Dimension(80, 80));
        serviceButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        serviceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serviceButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(serviceButton);

        customerButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/statistics.png"))); // NOI18N
        customerButton2.setText("Accounting");
        customerButton2.setFocusable(false);
        customerButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        customerButton2.setMaximumSize(new java.awt.Dimension(80, 80));
        customerButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        customerButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(customerButton2);

        customerButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/staff.png"))); // NOI18N
        customerButton3.setText("Staff");
        customerButton3.setFocusable(false);
        customerButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        customerButton3.setMaximumSize(new java.awt.Dimension(80, 80));
        customerButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        customerButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(customerButton3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
            .addComponent(mainTabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private Icon CLOSE_TAB_ICON = new ImageIcon(getClass().getResource("/resource/close-tab-icon.png"));
    public void addClosableTab(JTabbedPane mainTabbedPane, JComponent component, JButton button, String title, Icon icon)
    {
        mainTabbedPane.addTab(title, component);
        int pos = mainTabbedPane.indexOfComponent(component);

        // Create a FlowLayout that will space things 5px apart
        FlowLayout f = new FlowLayout(FlowLayout.CENTER, 0, 0);

        // Make a small JPanel with the layout and make it non-opaque
        JPanel pnlTab = new JPanel(f);
        pnlTab.setOpaque(false);

        // Add a JLabel with title and the left-side tab icon
        JLabel lblTitle = new JLabel(title);

        // Create a JButton for the close tab button
        JButton btnClose = new JButton();
        btnClose.setOpaque(false);

        // Configure icon and rollover icon for button
        btnClose.setRolloverIcon(icon);
        btnClose.setRolloverEnabled(true);
        btnClose.setIcon(RGBGrayFilter.getDisabledIcon(btnClose,icon));

        // Set border null so the button doesn't make the tab too big
        btnClose.setBorder(null);

        // Make sure the button can't get focus, otherwise it looks funny
        btnClose.setFocusable(false);

        // Put the panel together
        pnlTab.add(lblTitle);
        pnlTab.add(btnClose);

        // Add a thin border to keep the image below the top edge of the tab
        // when the tab is selected
        pnlTab.setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));

        // Now assign the component for the tab
        mainTabbedPane.setTabComponentAt(pos, pnlTab);

        // Add the listener that removes the tab
        ActionListener listener = new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            // The component parameter must be declared "final" so that it can be
            // referenced in the anonymous listener class like this.
            mainTabbedPane.remove(component);
            button.setEnabled(true);
          }
        };
        btnClose.addActionListener(listener);

        // Optionally bring the new tab to the front
        mainTabbedPane.setSelectedComponent(component);

        //-------------------------------------------------------------
        // Bonus: Adding a <Ctrl-W> keystroke binding to close the tab
        //-------------------------------------------------------------
        AbstractAction closeTabAction = new AbstractAction() {
          @Override
          public void actionPerformed(ActionEvent e) {
            mainTabbedPane.remove(component);
          }
        };   
    }
    private void serviceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serviceButtonActionPerformed
        ServiceManagerView serviceManagerView = new ServiceManagerView();
        try {
            ServiceManagerController serviceManagerController = new ServiceManagerController(new ServiceManagerModel(connection), serviceManagerView);
        } 
        catch (SQLException ex) 
        {
            System.out.println("Error: " + ex);
        }
        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(serviceManagerView);
        addClosableTab(mainTabbedPane, jScrollPane, serviceButton, "Service Manager ", CLOSE_TAB_ICON);
        serviceButton.setEnabled(false);
    }//GEN-LAST:event_serviceButtonActionPerformed

    private void customerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerButtonActionPerformed
        CustomerManagerView customerManagerView = new CustomerManagerView();
        try {            
            CustomerManagerController cusRegController = new CustomerManagerController(new CustomerManagerModel(connection), customerManagerView);
        } 
        catch (SQLException ex) 
        {
            System.out.println("Error: " + ex);
        }
        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(customerManagerView);
        addClosableTab(mainTabbedPane, jScrollPane, customerButton, "Customer Manager ", CLOSE_TAB_ICON);
        customerButton.setEnabled(false);
    }//GEN-LAST:event_customerButtonActionPerformed

    private void customerButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerButton1ActionPerformed

    private void customerButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerButton2ActionPerformed

    private void customerButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton customerButton;
    private javax.swing.JButton customerButton1;
    private javax.swing.JButton customerButton2;
    private javax.swing.JButton customerButton3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTabbedPane mainTabbedPane;
    private javax.swing.JButton serviceButton;
    // End of variables declaration//GEN-END:variables
}