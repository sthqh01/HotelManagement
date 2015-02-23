/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.object;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;

/**
 *
 * @author danielhuynh
 */
public class CertaintyChecker 
{
    public static boolean checkCertainty(JComponent component)
    {
        if(JOptionPane.showConfirmDialog(component, "Are you sure?", "Confirm Dialog", YES_NO_OPTION) == JOptionPane.YES_OPTION)
            return true;
        return false;
    }
    
}
