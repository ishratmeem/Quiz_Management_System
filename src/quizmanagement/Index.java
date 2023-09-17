
package quizmanagement;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Index extends JFrame{
    
                      
    private Container c;
    private JButton jButton1,jButton2,jButton3;
    private JLabel jLabel1, jLabel2;
    private Font f,f1;
    private ImageIcon studentimg,adminimg,exitimg,indexbackgroundimg;
    private JPanel quizpanel;
   
    
    
    public Index() {
        initComponents();
    }
    
     private void initComponents() {
        this.setSize(1260, 768);
        this.setLocationRelativeTo(null);
         this.setTitle("Index Page");
               
         f=new Font("Tahoma",Font.BOLD,16);
         f1=new Font("Tahoma",Font.BOLD,24);
         
         studentimg=new ImageIcon(getClass().getResource("/img/index student.png"));
        adminimg=new ImageIcon(getClass().getResource("/img/index admin.png"));
        exitimg=new ImageIcon(getClass().getResource("/img/Close.png"));
        indexbackgroundimg=new ImageIcon(getClass().getResource("/img/index background.png"));
        
         
         c=this.getContentPane();
         c.setLayout(null);
         
           //Quize Management label
           
           quizpanel = new JPanel();
        quizpanel.setBounds(360, 300, 460, 200);
        quizpanel.setBackground(Color.orange);
        quizpanel.setLayout(null);
        c.add(quizpanel);
           
         
        jLabel2=new JLabel("WELCOME QUIZ MANAGEMENT");
         jLabel2.setBounds(50,2,450,200);
         jLabel2.setFont(f1);
         jLabel2.setForeground(Color.black);
         
         quizpanel.add(jLabel2);

         jLabel1=new JLabel();
         jLabel1.setSize(1260, 768);
         jLabel1.setIcon(indexbackgroundimg);
         c.add(jLabel1);
         

        //Student Button
         
       jButton1=new JButton("Student");
       jButton1.setFont(f);
       jButton1.setBounds(500,20,180,80);
       jButton1.setBackground(Color.white);
       jButton1.setIcon(studentimg);
       c.add(jButton1);
       
       
        //Admin Button
       jButton2=new JButton("Admin");
       jButton2.setFont(f);
       jButton2.setBounds(700,20,180,80);
       jButton2.setBackground(Color.white);
       jButton2.setIcon(adminimg);
       c.add(jButton2);
       
        //Exit Button
       jButton3=new JButton("Exit");
       jButton3.setFont(f);
       jButton3.setBounds(900,20,180,80);
       jButton3.setBackground(Color.white);
       jButton3.setIcon(exitimg);
       c.add(jButton3);
       
       //Student Button Action
       jButton1.addActionListener(new ActionListener()
       {
       
       @Override
       public void actionPerformed(ActionEvent e)
       {
           setVisible(false);
        new StudentDetails().setVisible(true);
       }
       });
       
       
        //Admin Button Action
       jButton2.addActionListener(new ActionListener()
       {
       
       @Override
       public void actionPerformed(ActionEvent e)
       {
           setVisible(false);
        new LoginFrame().setVisible(true);
       }
       });
       
       //Exit Button Action
       jButton3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                int choice= JOptionPane.showConfirmDialog(null, "Do you want to quit??", "Select", JOptionPane.YES_NO_OPTION);
        
        if(choice== 0)
		{
			
			System.exit(0);
		}
            }
       });
    }
     
  
     public static void main(String[] args) {
        
         Index frame=new Index();
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setVisible(true);
       // frame.setUndecorated(true);
         frame.setResizable(false);
}
}
