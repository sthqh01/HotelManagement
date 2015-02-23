/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.object;

/**
 *
 * @author danielhuynh
 */
public class FieldChecker 
{   
    public static boolean isAllLetters(String str)
    {
        for(int i = 0; i < str.length(); i++)
        {
            if(!Character.isLetter(str.charAt(i)))
                return false;
        }
        return true;
    }
    
    public static boolean isAllNumbers(String str)
    {
        for(int i = 0; i< str.length(); i++)
        {
            if(!Character.isDigit(str.charAt(i)))
                return false;
        }
        return true;
    }
    
    public static boolean isDecimal(String str)
    {
        for(int i = 0; i < str.length(); i++)
        {
            if(!Character.isDigit(str.charAt(i)) && str.charAt(i) != '.')
                return false;
        }
        return true;
    }
}
