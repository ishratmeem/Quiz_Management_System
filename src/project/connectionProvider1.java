
package project;

import java.sql.*;

public class connectionProvider1 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        String user="root";
        String password="";
        String url="jdbc:mysql://127.0.0.1:3306/quizemanagement";
      Connection conn= DriverManager.getConnection(url,user,password);
   
      Statement statement=conn.createStatement();
      
       /*Display Code
      
      String query="SELECT* FROM studentinfo";
      ResultSet result=statement.executeQuery(query);
      while(result.next())
      {
          String Id,name;
          Id=result.getString("Id");
          name=result.getString("name");
          System.out.println(Id+" "+name);
          
      }
*/
       
       /*Adding Code
    String query="INSERT INTO `studentinfo`(`name`) VALUES ('Mohima')";
      statement.executeUpdate(query);
      
    }
    */
       
       /*Update Code
       String query="UPDATE `studentinfo` SET `name`='Faria' WHERE Id=7";
       statement.executeUpdate(query);
       
       */
      
       
       /*Delete code
       String query = "DELETE FROM `studentinfo` WHERE Id=9";
       statement.executeUpdate(query);
       
       */
       
       statement.close();
      conn.close();
    }

    public static Connection getCon() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}


  
              /*  Class.forName("com.mysql.cj.jdbc.Driver");
            String user="root";
            String password="";
            String url="jdbc:mysql://127.0.0.1:3306/quizemanagement";
            Connection conn= DriverManager.getConnection(url,user,password);
            Statement statement=conn.createStatement();
            
            
            
            String Id=nolabel.getText();
            int id=Integer.parseInt(Id);
            
            String question=qtext.getText();
            String opt1=opt1text.getText();
            String opt2=opt2text.getText();
            String opt3=opt3text.getText();
            String opt4=opt4text.getText();
            String answer=anstext.getText();
            
            String query="INSERT INTO question(id,question, option1, option2, option3, option4, answer) VALUES ("+id+",'"+question+"','"+opt1+"','"+opt2+"','"+opt3+"','"+opt4+"','"+answer+"')";
            statement.executeUpdate(query);
      JOptionPane.showMessageDialog(addNewQuestion.this, "Successfully added");
      statement.close();
      conn.close();
*/