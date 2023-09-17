
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateQuestion extends JFrame{
    
    
    
    private Container c;
    private JButton updatebutton, clearbutton,closebutton,searchbutton;
    private JLabel background, label1, label2,label3,qnolabel, qlabel, opt1label, opt2label, opt3label, opt4label, anslabel;
    private Font f1, f2;
    private ImageIcon updateimg, saveimg, clearimg, closeimg, backgroudimg,searchimg;
    private JTextField  qtext, opt1text, opt2text, opt3text, opt4text, anstext,searchtext;
    
    public UpdateQuestion() {
        initComponents();
    }

    private void initComponents() {
        this.setSize(860, 600);
        this.setLocationRelativeTo(null);
        this.setTitle("Update Question Page");

//Frame in Container c
        c = this.getContentPane();
        c.setLayout(null);

        f1 = new Font("Tahoma", Font.BOLD, 14);
        f2 = new Font("Tahoma", Font.BOLD, 20);

        //Inserting Images
        updateimg = new ImageIcon(getClass().getResource("/img/Update Question.png"));
        saveimg = new ImageIcon(getClass().getResource("/img/save.png"));
        closeimg = new ImageIcon(getClass().getResource("/img/Close.png"));
        clearimg = new ImageIcon(getClass().getResource("/img/clear.png"));
        backgroudimg = new ImageIcon(getClass().getResource("/img/logIn Background.jpg"));
        searchimg=new ImageIcon(getClass().getResource("/img/search.png"));

        //Headline 
        
        label1 = new JLabel();
        label1.setIcon(updateimg);
        label1.setBounds(30, 10, 100, 100);
        c.add(label1);
      
        label2 = new JLabel("Update Questions");
        label2.setBounds(100, 10, 200, 100);
        label2.setFont(f2);
        c.add(label2);
        
        //Close Button
        
        closebutton=new JButton();
        closebutton.setIcon(closeimg);
       closebutton.setBounds(750, 20, 60, 60);
       closebutton.setBackground(Color.white);
        c.add(closebutton);
        
        
    //Question NO
        qnolabel = new JLabel("Qusetion No : ");
        qnolabel.setBounds(100,100,150,40);
        qnolabel.setFont(f1);
        c.add(qnolabel);
        
        
        //Question Number Search
        searchtext=new JTextField();
        searchtext.setBounds(250,100,150,40);
        searchtext.setFont(f1);
        c.add(searchtext);
        
        //Search Button
        searchbutton=new JButton("Search");
         searchbutton.setIcon(searchimg);
       searchbutton.setBounds(430,100,150,40);
       searchbutton.setBackground(Color.white);
       searchbutton.setFont(f1);
        c.add(searchbutton);
        
        
        //Question 
        qlabel = new JLabel("Question : ");
        qlabel.setBounds(100,150,150,40);
        qlabel.setFont(f1);
        c.add(qlabel);
        
              
        qtext=new JTextField();
        qtext.setBounds(250,150,500,40);
        qtext.setFont(f1);
        c.add(qtext);
                
        //Option1

        opt1label = new JLabel("Option1 :");
        opt1label.setBounds(100,200,150,40);
        opt1label.setFont(f1);
        c.add(opt1label);
        
        opt1text=new JTextField();
        opt1text.setBounds(250,200,500,40);
        opt1text.setFont(f1);
        c.add(opt1text);
        
        //Option2
        opt2label = new JLabel("Option2 :");
        opt2label.setBounds(100,250,150,40);
        opt2label.setFont(f1);
        c.add(opt2label);
        
        opt2text=new JTextField();
        opt2text.setBounds(250,250,500,40);
        opt2text.setFont(f1);
        c.add(opt2text);

        
        //Option3
        opt3label = new JLabel("Option3 :");
        opt3label.setBounds(100,300,150,40);
        opt3label.setFont(f1);
        c.add(opt3label);
        
        opt3text=new JTextField();
        opt3text.setBounds(250,300,500,40);
        opt3text.setFont(f1);
        c.add(opt3text);
        
        
        //Option4
        opt4label = new JLabel("Option4 :");
        opt4label.setBounds(100,350,150,40);
        opt4label.setFont(f1);
        c.add(opt4label);
        
        opt4text=new JTextField();
        opt4text.setBounds(250,350,500,40);
        opt4text.setFont(f1);
        c.add(opt4text);
        
        //Answer
        anslabel = new JLabel("Answer :");
        anslabel.setBounds(100,400,150,40);
        anslabel.setFont(f1);
        c.add(anslabel);
        
        anstext=new JTextField();
        anstext.setBounds(250,400,500,40);
        anstext.setFont(f1);
        c.add(anstext);

        
        //Update Button
        updatebutton=new JButton("UPDATE");
        updatebutton.setIcon(saveimg);
        updatebutton.setBounds(250,460,130,30);
        c.add(updatebutton);
        
        //Clear Button
        clearbutton=new JButton("CLEAR");
        clearbutton.setIcon(clearimg);
        clearbutton.setBounds(400,460,130,30);
        c.add(clearbutton);
        
        
        // Background
        background = new JLabel();
        background.setSize(1366, 768);
        background.setIcon(backgroudimg);
        c.add(background);
        
        
        
        
        //Search Button Action
        searchbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String id=searchtext.getText();
                try{
                    
                    Connection conn=connectionProvider.getCon();
                    Statement statement=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    ResultSet rs=statement.executeQuery("SELECT * FROM question WHERE id= '"+id+"'");
                if(rs.first())
                {
                    qtext.setText(rs.getString(2));
                            opt1text.setText(rs.getString(3));
                            opt2text.setText(rs.getString(4));
                            opt3text.setText(rs.getString(5));
                            opt4text.setText(rs.getString(6));
                            anstext.setText(rs.getString(7));
                            
                            searchtext.setEditable(false);
                }
                else
                        {
                            JFrame jf=new JFrame();
                            jf.setAlwaysOnTop(true);
                            JOptionPane.showMessageDialog(jf, "Question Id does not Exist ");
                        }
                }
                catch(Exception e)
                {
                    JFrame jf=new JFrame();
                            jf.setAlwaysOnTop(true);
                            JOptionPane.showMessageDialog(jf, e);
                }
            } 
        });
        
        
        
        //Update Button Action
        updatebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String id=searchtext.getText();
                String question=qtext.getText();
                String option1=opt1text.getText();
                String option2=opt2text.getText();
                String option3=opt3text.getText();
                String option4=opt4text.getText();
                String answer=anstext.getText();
                
                
                try{
                    
                    Connection conn=connectionProvider.getCon();
                     
                    PreparedStatement ps=conn.prepareStatement("UPDATE question SET question=?,option1=?,option2=?,option3=?,option4=?,answer=? WHERE id=?");
                   ps.setString(1, question);
                   ps.setString(2, option1);
                   ps.setString(3, option2);
                   ps.setString(4, option3);
                   ps.setString(5, option4);
                   ps.setString(6, answer);
                   ps.setString(7, id);
                   
                   ps.executeUpdate();
                   
                   JFrame jf = new JFrame();
                    jf.setAlwaysOnTop(true);
                    JOptionPane.showMessageDialog(jf, "Successfully Updated");
                
                    setVisible(false);
                    new UpdateQuestion().setVisible(true);
               
                }
                catch(Exception e)
                {
                    JFrame jf=new JFrame();
                            jf.setAlwaysOnTop(true);
                            JOptionPane.showMessageDialog(jf, e);
                }
            } 
        });
        
        
        //Clear button Action
        
        clearbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchtext.setText("");
                qtext.setText("");
                opt1text.setText("");
                opt2text.setText("");
                opt3text.setText("");
                opt4text.setText("");
                anstext.setText("");
                
                searchtext.setEditable(true);
            }
        });
        
        
        //closebutton action
        closebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                AdminHome.open=0;
                setVisible(false);
            }
        });
        
        
        
    }

    
    public static void main(String[] args) {

        UpdateQuestion frame = new UpdateQuestion();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
       // frame.setUndecorated(true);
        frame.setResizable(false);
    }
}
