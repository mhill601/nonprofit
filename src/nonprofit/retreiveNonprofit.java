/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonprofit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
 
/**
 *
 * @author Mark's PC
 */
public class retreiveNonprofit {
    
    public String getSingle(){
        
    Connection conn1 = null;    
    Statement st = null;
    ResultSet rs = null;    
    
    String query = null;
    
    try {
            // connect way #1
            //String url1 = "jdbc:mysql://108.167.189.45/ab18911_adwords";
            //String user = "ab18911_jsix";
            //String password = "G7-Chord";
 
            //connect to local
            String url1 = "jdbc:mysql://localhost:3306/test";
            String user = "root";
            String password = "G7-Chord";        
        
            conn1 = DriverManager.getConnection(url1, user, password);
            if (conn1 != null) {
                st = conn1.createStatement();
                rs = st.executeQuery("SELECT * FROM test.nonprofits WHERE `status` = '0' LIMIT 1;");
                
                if (rs.next()) {
                    query = rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3); 
                    //System.out.println(rs.getString(1));
                    //System.out.println(rs.getString(2));
                    //System.out.println(rs.getString(3));
                    //System.out.println(rs.getString(4));
                }
                
            } 
     }
        catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
    
        return query;
    }
    
    
}
