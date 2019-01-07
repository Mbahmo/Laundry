/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laundry;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Mbahmo
 */
public class koneksi {
    static  Connection koneksi;
    static  Connection getConnection() throws SQLException
    {
        if (koneksi==null)
        {
            new Driver();
            koneksi =(Connection) DriverManager.getConnection
        ("jdbc:mysql://localhost:3306/dblaundry","root","");
        }
        return koneksi;
  
   }

    static void excuteUpdate(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
