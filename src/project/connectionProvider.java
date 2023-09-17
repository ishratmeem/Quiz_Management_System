
package project;
import java.sql.*;

public class connectionProvider {
    
    public static Connection getCon()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
           Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/quizemanagement","root","");
           return conn;
            
            
        }
        
        
        catch(ClassNotFoundException | SQLException e)
        {
            return null;
            
    }
        
    
}
}
