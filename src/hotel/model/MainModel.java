/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.model;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author danielhuynh
 */
public class MainModel 
{
    private JTabbedPane mainTabbedPane = null;
    private JComponent component = null;
    private String title = null;
    
    public MainModel(JTabbedPane mainTabbedPane, JComponent component, String title)
    {
        this.mainTabbedPane = mainTabbedPane;
        this.component = component;
        this.title = title;
    }
    
    
}
