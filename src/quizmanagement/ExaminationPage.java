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
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class ExaminationPage extends JFrame {

public String questionId = "1";
    public String answer;
    public int min = 0, sec = 0, marks = 0;
    
    private Container c;
    private JButton nextbutton, submitbutton;
    private JLabel background, label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11, totaltimelabel, timetakenlabel, timetakenlabel2, timetakenlabel3, questlabel,marklabel,marklabel2;
    private Font f1, f2;
    private ImageIcon cornerimg, backgroudimg, nextimg, submitimg;
    private JPanel upperpanel, lowerpanel;
    private JRadioButton opt1radio, opt2radio, opt3radio, opt4radio;


    //Answer Check Method
    public void answerCheck()
    {
        String studentanswer="";
        
        if(opt1radio.isSelected())
        {
            studentanswer=opt1radio.getText();
        }
        
        else if(opt2radio.isSelected())
        {
            studentanswer=opt2radio.getText();
        }
        
        else if(opt3radio.isSelected())
        {
            studentanswer=opt3radio.getText();
        }
        else
        {
            studentanswer=opt4radio.getText();
        }

        
        if(studentanswer.equals(answer))
        {
            marks=marks+1;
            String marks1=String.valueOf(marks);
            marklabel2.setText(marks1);   
        }
        
        //Question Number Changing
        int questionId1=Integer.parseInt(questionId);
        questionId1=questionId1+1;
        questionId=String.valueOf(questionId1);
        
        //Clear Radio Button
        opt1radio.setSelected(false);
        opt2radio.setSelected(false);
        opt3radio.setSelected(false);
        opt4radio.setSelected(false);
        
        
        //Last Question operation for hide next button
        if(questionId.equals("10"))
        {
            nextbutton.setVisible(false);
        }
    }
    
    
    
    //Question Method
    public void question()
    {
         try {
            Connection conn = connectionProvider.getCon();
            Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);  
            ResultSet rs1 = statement.executeQuery("SELECT * FROM question WHERE id= '" + questionId + "'");
            while (rs1.next()) {
                label11.setText(rs1.getString(1));
                questlabel.setText(rs1.getString(2));
                opt1radio.setText(rs1.getString(3));
                opt2radio.setText(rs1.getString(4));
                opt3radio.setText(rs1.getString(5));
                opt4radio.setText(rs1.getString(6));
                answer = rs1.getString(7);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    //Submit Method
     public void submit()
    {
        String id=label5.getText();
        answerCheck();
        try{
            Connection conn = connectionProvider.getCon();
            Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);  
          statement.executeUpdate("UPDATE studentdetail SET marks='"+marks+"' WHERE id='"+id+"'");
        String marks1=String.valueOf(marks);
                //JOptionPane.showMessageDialog(null, marks1);
        setVisible(false);
        new SuccessfullySubmitted(marks1).setVisible(true);
        }
        
        catch(Exception e)
        {
            
        JOptionPane.showMessageDialog(null, e);
    }
    }
    
    public ExaminationPage() {
        initComponents();
    }

    Timer time;
    public ExaminationPage(String id) {
        
        initComponents();
        label5.setText(id);

        //first question and students details
        try {
            Connection conn = connectionProvider.getCon();
            Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = statement.executeQuery("SELECT * FROM studentdetail WHERE id= '" + id + "'");
            while (rs.next()) {
                label7.setText(rs.getString(2));
            }

            ResultSet rs1 = statement.executeQuery("SELECT * FROM question WHERE id= '" + questionId + "'");
            while (rs1.next()) {
                label11.setText(rs1.getString(1));
                questlabel.setText(rs1.getString(2));
                opt1radio.setText(rs1.getString(3));
                opt2radio.setText(rs1.getString(4));
                opt3radio.setText(rs1.getString(5));
                opt4radio.setText(rs1.getString(6));
                answer = rs1.getString(7);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        //Timer
        
        setLocationRelativeTo(this);
        time=new Timer(1000,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               timetakenlabel3.setText(String.valueOf(sec));
               timetakenlabel2.setText(String.valueOf(min));
               if(sec==60)
               {
                   sec=0;
                   min++;
                   if(min==10)
                   {
                       time.stop();
                       answerCheck();
                       submit();
                   }
               }
               sec++;
            }
        });
        
        time.start();
    }
    
    

    private void initComponents() {
        this.setSize(860, 600);
        this.setLocationRelativeTo(null);
        this.setTitle("Exam Question ");

        //Frame in Container c
        c = this.getContentPane();
        c.setLayout(null);

        f1 = new Font("Tahoma", Font.BOLD, 14);
        f2 = new Font("Tahoma", Font.BOLD, 20);

        //Inserting Images
        cornerimg = new ImageIcon(getClass().getResource("/img/index student.png"));
        backgroudimg = new ImageIcon(getClass().getResource("/img/logIn Background.jpg"));
        nextimg = new ImageIcon(getClass().getResource("/img/Next.png"));
        submitimg = new ImageIcon(getClass().getResource("/img/save.png"));

        //Upper Panel
        upperpanel = new JPanel();
        upperpanel.setBounds(0, 0, 860, 100);
        upperpanel.setBackground(Color.LIGHT_GRAY);
        upperpanel.setLayout(null);
        c.add(upperpanel);

        //Lower Panel
        lowerpanel = new JPanel();
        lowerpanel.setBounds(00, 100, 300, 500);
        lowerpanel.setBackground(Color.DARK_GRAY);
        lowerpanel.setLayout(null);
        c.add(lowerpanel);

        //Headline 
        label1 = new JLabel();
        label1.setBounds(10, 20, 70, 40);
        label1.setIcon(cornerimg);

        label2 = new JLabel("Exam Paper");
        label2.setBounds(90, 20, 150, 40);
        label2.setFont(f2);

        //Total Time label
        label3 = new JLabel("Total Time :");
        label3.setBounds(500, 20, 150, 20);
        label3.setFont(f1);

        totaltimelabel = new JLabel("10min");
        totaltimelabel.setBounds(600, 20, 100, 20);
        totaltimelabel.setFont(f1);

        //Time Taken label
        timetakenlabel = new JLabel("Time Taken :");
        timetakenlabel.setBounds(500, 40, 150, 40);
        timetakenlabel.setFont(f1);

        //timetakenlabe2 for min
        timetakenlabel2 = new JLabel("00");
        timetakenlabel2.setBounds(600, 40, 50, 40);
        timetakenlabel2.setFont(f1);

        //timetakenlabe3 for sec
        timetakenlabel3 = new JLabel("01");
        timetakenlabel3.setBounds(630, 40, 50, 40);
        timetakenlabel3.setFont(f1);

        upperpanel.add(label1);
        upperpanel.add(label2);
        upperpanel.add(label3);
        upperpanel.add(totaltimelabel);
        upperpanel.add(timetakenlabel);
        upperpanel.add(timetakenlabel2);
        upperpanel.add(timetakenlabel3);

        //ID Number label
        label4 = new JLabel("ID :");
        label4.setBounds(20, 20, 170, 50);
        label4.setFont(f1);
        label4.setForeground(Color.WHITE);

        label5 = new JLabel("20211126");
        label5.setBounds(170, 20, 100, 50);
        label5.setFont(f1);
        label5.setForeground(Color.WHITE);

        //Name label
        label6 = new JLabel("Name :");
        label6.setBounds(20, 60, 100, 50);
        label6.setFont(f1);
        label6.setForeground(Color.WHITE);

        label7 = new JLabel("Ishrat Jahan Meem");
        label7.setBounds(100, 60, 170, 50);
        label7.setFont(f1);
        label7.setForeground(Color.WHITE);

        //Total Question lable
        label8 = new JLabel("Total Question:");
        label8.setBounds(20, 100, 150, 50);
        label8.setFont(f1);
        label8.setForeground(Color.WHITE);

        label9 = new JLabel("10");
        label9.setBounds(170, 100, 170, 50);
        label9.setFont(f1);
        label9.setForeground(Color.WHITE);

        //Question Number lable
        label10 = new JLabel("Question Number:");
        label10.setBounds(20, 140, 170, 50);
        label10.setFont(f1);
        label10.setForeground(Color.WHITE);

        label11 = new JLabel("00");
        label11.setBounds(170, 140, 150, 50);
        label11.setFont(f1);
        label11.setForeground(Color.WHITE);

        
        //Mark Label
        marklabel = new JLabel("Marks :");
        marklabel.setBounds(20, 180, 150, 50);
        marklabel.setFont(f1);
        marklabel.setForeground(Color.WHITE);

        marklabel2 = new JLabel("00");
        marklabel2.setBounds(170, 180, 150, 50);
       marklabel2.setFont(f1);
        marklabel2.setForeground(Color.WHITE);
        
        lowerpanel.add(label4);
        lowerpanel.add(label5);
        lowerpanel.add(label6);
        lowerpanel.add(label7);
        lowerpanel.add(label8);
        lowerpanel.add(label9);
        lowerpanel.add(label10);
        lowerpanel.add(label11);
        lowerpanel.add(marklabel);
        lowerpanel.add(marklabel2);

        //Label of Question
        questlabel = new JLabel("Question Demo");
        questlabel.setBounds(350, 120, 360, 50);
        questlabel.setFont(f1);
        c.add(questlabel);

        //Radio Button
        opt1radio = new JRadioButton("Option1");
        opt1radio.setBounds(350, 180, 160, 50);
        opt1radio.setFont(f1);
        c.add(opt1radio);

        opt2radio = new JRadioButton("Option2");
        opt2radio.setBounds(350, 220, 160, 50);
        opt2radio.setFont(f1);
        c.add(opt2radio);

        opt3radio = new JRadioButton("Option3");
        opt3radio.setBounds(350, 260, 160, 50);
        opt3radio.setFont(f1);
        c.add(opt3radio);

        opt4radio = new JRadioButton("Option4");
        opt4radio.setBounds(350, 300, 160, 50);
        opt4radio.setFont(f1);
        c.add(opt4radio);

        //Next Button
        nextbutton = new JButton("NEXT");
        nextbutton.setIcon(nextimg);
        nextbutton.setBounds(350, 400, 150, 30);
        nextbutton.setBackground(Color.white);
        c.add(nextbutton);

        //Submit Button
        submitbutton = new JButton("SUBMIT");
        submitbutton.setIcon(submitimg);
        submitbutton.setBounds(650, 400, 150, 30);
        submitbutton.setBackground(Color.white);
        c.add(submitbutton);

        // Background
        background = new JLabel();
        background.setSize(1366, 768);
        background.setIcon(backgroudimg);
        c.add(background);

        //Next Button 
        nextbutton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
               answerCheck();
               question();
            }              
       });  
        
         //Submit Button 
        submitbutton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
               int a=JOptionPane.showConfirmDialog(null,"Do you want to submit the answer","Select",JOptionPane.YES_NO_OPTION);
               if(a==0)
               {
                   answerCheck();
                   submit();
               }
            }              
       });     
        
        //Option1 radio Button action 
         opt1radio.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
               if(opt1radio.isSelected())
               {
                   opt2radio.setSelected(false);
                   opt3radio.setSelected(false);
                   opt4radio.setSelected(false);
               }
            }              
       });
         
         
          //Option2 radio Button action 
         opt2radio.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
               if(opt2radio.isSelected())
               {
                   opt1radio.setSelected(false);
                   opt3radio.setSelected(false);
                   opt4radio.setSelected(false);
               }
            }              
       });
         
         
          //Option1 radio Button action 
         opt3radio.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
               if(opt3radio.isSelected())
               {
                   opt2radio.setSelected(false);
                   opt1radio.setSelected(false);
                   opt4radio.setSelected(false);
               }
            }              
       });
         
          //Option1 radio Button action 
         opt4radio.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
               if(opt4radio.isSelected())
               {
                   opt2radio.setSelected(false);
                   opt3radio.setSelected(false);
                   opt1radio.setSelected(false);
               }
            }              
       });
    }
    
    

    public static void main(String[] args) {

        ExaminationPage frame = new ExaminationPage();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        //frame.setUndecorated(true);
        frame.setResizable(false);
    }
}
