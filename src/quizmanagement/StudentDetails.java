 
package quizmanagement;

import java.sql.*;
import project.connectionProvider;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class StudentDetails extends JFrame{
    
    
      private Container c;
    private JButton  closebutton,nextbutton,backbutton;
    private JLabel background, label1, label2,label3,label4,label5,label6,label7;
    private Font f1, f2;
    private ImageIcon  indeximg,saveimg, closeimg, backgroudimg,backimg;
    private JTextField  idtext,nametext,contacttext,emailtext;
    private JComboBox box1;
	private String[] gender= {"Male","Female"};
    public StudentDetails(){
        initComponents();
    }

    private void initComponents() {
        this.setSize(860, 600);
        this.setLocationRelativeTo(null);
        this.setTitle("Student Details ");

//Frame in Container c
        c = this.getContentPane();
        c.setLayout(null);

        f1 = new Font("Tahoma", Font.BOLD, 14);
        f2 = new Font("Tahoma", Font.BOLD, 20);

        //Inserting Images
        indeximg = new ImageIcon(getClass().getResource("/img/index student.png"));
        saveimg = new ImageIcon(getClass().getResource("/img/save.png"));
        closeimg = new ImageIcon(getClass().getResource("/img/Close.png"));
        backgroudimg = new ImageIcon(getClass().getResource("/img/logIn Background.jpg"));
        backimg = new ImageIcon(getClass().getResource("/img/Back.png"));
       
        
        //Headline 
        
        label1 = new JLabel();
        label1.setIcon(indeximg);
        label1.setBounds(30, 10, 100, 100);
        c.add(label1);
      
        label2 = new JLabel("Fill Up the Form");
        label2.setBounds(100, 10, 200, 100);
        label2.setFont(f2);
        c.add(label2);
        
        //Student ID
        label3 = new JLabel("ID : ");
        label3.setBounds(50,120,150,40);
        label3.setFont(f1);
        c.add(label3);
        
        //Student ID Text field
        idtext=new JTextField();
        idtext.setBounds(150,130,450,30);
         idtext.setFont(f1);
        c.add(idtext);
        
        
        //Student Name
        label4 = new JLabel("Name : ");
        label4.setBounds(50,160,150,40);
        label4.setFont(f1);
        c.add(label4);
        
        //Student Name Text field
        nametext=new JTextField();
        nametext.setBounds(150,170,450,30);
         nametext.setFont(f1);
        c.add(nametext);
        
        //Student Gender
        label5 = new JLabel("Gender : ");
        label5.setBounds(50,200,150,40);
        label5.setFont(f1);
        c.add(label5);
         
        //Student Gender Text field

        box1=new JComboBox(gender);
		box1.setBounds(150,210,450,30);
		box1.setBackground(Color.white);
		box1.setFont(f1);
                c.add(box1);
        
        
        //Student Contact
        label6 = new JLabel("Contact : ");
        label6.setBounds(50,240,150,40);
        label6.setFont(f1);
        c.add(label6);
        
        //Student Contact Text field
        contacttext=new JTextField();
        contacttext.setBounds(150,250,450,30);
         contacttext.setFont(f1);
        c.add(contacttext);
    
         //Student Email
        label7 = new JLabel("Email : ");
        label7.setBounds(50,280,150,40);
        label7.setFont(f1);
        c.add(label7);
        
        //Student Email Text field
        emailtext=new JTextField();
        emailtext.setBounds(150,290,450,30);
         emailtext.setFont(f1);
        c.add(emailtext);
    
        //Next Button
        nextbutton=new JButton("SAVE & NEXT");
        nextbutton.setIcon(saveimg);
       nextbutton.setBounds(250, 400, 150, 60);
       nextbutton.setBackground(Color.white);
        c.add(nextbutton);
               
       //Back button
        backbutton = new JButton("Back");
         backbutton.setFont(f1);
         backbutton.setBounds(450, 400, 150, 60);
         backbutton.setBackground(Color.white);
         backbutton.setIcon(backimg);
        c.add( backbutton);
        
        //Close Button
        closebutton=new JButton();
        closebutton.setIcon(closeimg);
       closebutton.setBounds(750, 20, 60, 60);
       closebutton.setBackground(Color.white);
        c.add(closebutton);
        
        
         // Background
        background = new JLabel();
        background.setSize(1366, 768);
        background.setIcon(backgroudimg);
        c.add(background);
        
        //Back Button Action
         backbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                      setVisible(false);
                    new Index().setVisible(true);
                }    
        });
         
         //Save & Next Button Action
         nextbutton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
                String rollNo=idtext.getText();
                String name=nametext.getText();
                String gender=(String)box1.getSelectedItem();
                String contact=contacttext.getText();
                String email=emailtext.getText();
                String marks="0";

                try{
                    Connection conn=connectionProvider.getCon();
                     
                    PreparedStatement ps = conn.prepareStatement("INSERT INTO studentdetail VALUES (?,?,?,?,?,?)");
                    
                   ps.setString(1, rollNo);
                   ps.setString(2, name);
                   ps.setString(3, gender);
                   ps.setString(4, contact);
                   ps.setString(5, email);
                   ps.setString(6, marks);
                   
                   ps.executeUpdate();
                   
                   setVisible(false);
                   new ExamInstruction(rollNo).setVisible(true);

                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null, e);
                }
            }            
       });
         

         //Close Button Action
           closebutton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                int choice= JOptionPane.showConfirmDialog(null, "Do you want to quit??", "Select", JOptionPane.YES_NO_OPTION);
        if(choice== 0)
		{
			
			System.exit(0);
		}
            }              
       });    
    }

      public static void main(String[] args) {

        StudentDetails frame = new StudentDetails();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
       // frame.setUndecorated(true);
        frame.setResizable(false);
    }
    
    
}
