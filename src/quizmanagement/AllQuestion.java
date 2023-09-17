
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class AllQuestion extends JFrame{
    
     
    private Container c;
    private JButton closebutton;
    private JLabel background, label1, label2;
    private Font f1, f2;
    private ImageIcon allquestionimg,closeimg, backgroudimg;
    //private JTextField  qtext, opt1text, opt2text, opt3text, opt4text, anstext,searchtext;
    private JTable table;
    private JScrollPane scroll;
    private DefaultTableModel model;
   private String[] column={"ID","Question","Option1","Option2","Option3","Option4","Answer"};
   private String[] rows=new String[7];
   
   
   
    public AllQuestion() {
        initComponents();
        
        
        try{
        
                    Connection conn=connectionProvider.getCon();
                    Statement statement=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    ResultSet rs=statement.executeQuery("SELECT * FROM question");
                   
                    table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        
    }

    private void initComponents() {
        this.setSize(860, 600);
        this.setLocationRelativeTo(null);
        this.setTitle("All Question Page");

        //Frame in Container c
        c = this.getContentPane();
        c.setLayout(null);

        f1 = new Font("Tahoma", Font.BOLD, 14);
        f2 = new Font("Tahoma", Font.BOLD, 20);

        //Inserting Images
        allquestionimg = new ImageIcon(getClass().getResource("/img/all questions.png"));      
        closeimg = new ImageIcon(getClass().getResource("/img/Close.png"));
        backgroudimg = new ImageIcon(getClass().getResource("/img/logIn Background.jpg"));
        

        //Headline 
        
        label1 = new JLabel();
        label1.setIcon(allquestionimg);
        label1.setBounds(30, 10, 100, 100);
        c.add(label1);
      
        label2 = new JLabel("All Questions");
        label2.setBounds(100, 10, 200, 100);
        label2.setFont(f2);
        c.add(label2);
        
        //Close Button
        
        closebutton=new JButton();
        closebutton.setIcon(closeimg);
       closebutton.setBounds(750, 20, 60, 60);
       closebutton.setBackground(Color.white);
        c.add(closebutton);
        
        
        //Table
        
        table=new JTable();
        
        model =new DefaultTableModel();
        model.setColumnIdentifiers(column);
        table.setModel(model);
        //table.setFont(f1);
        table.setRowHeight(20);
        scroll=new JScrollPane(table);
        scroll.setBounds(20,150,800,300);
        c.add(scroll);
        
        
        // Background
        background = new JLabel();
        background.setSize(1366, 768);
        background.setIcon(backgroudimg);
        c.add(background);
        
        
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

        AllQuestion frame = new AllQuestion();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        //frame.setUndecorated(true);
        frame.setResizable(false);
    }
    
}
