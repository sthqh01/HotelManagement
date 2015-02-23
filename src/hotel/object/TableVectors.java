/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.object;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author danielhuynh
 */
public class TableVectors 
{
    Vector cols, data;
    public TableVectors(ResultSet resultSet) throws SQLException
    {
        int len = resultSet.getMetaData().getColumnCount();
        Vector cols = new Vector(len);
        for(int i=1; i <= len; i++)
        {
            cols.add(resultSet.getMetaData().getColumnName(i));
        }
        Vector data = new Vector();
        while(resultSet.next())
        {
            Vector row = new Vector(len);
            for(int i=1; i<=len; i++)
            {
                row.add(resultSet.getString(i));
            }
            data.add(row);
        }
        this.cols = cols;
        this.data = data;
    }
    
    public TableVectors()
    {
        
    }
    
    public Vector getCols()
    {
        return cols;
    }
    
    public Vector getData()
    {
        return data;
    }
    
}
