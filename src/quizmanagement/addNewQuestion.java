package quizmanagement;

import java.sql.*;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import project.connectionProvider;
import project.connectionProvider1;

public class addNewQuestion extends JFrame {

    private Container c;
    private JButton savebutton, clearbutton, closebutton;
    private JLabel background, label1, label2,label3, nolabel, qnolabel, qlabel, opt1label, opt2label, opt3label, opt4label, anslabel;
    private Font f1, f2;
    private ImageIcon cornerimg, saveimg, clearimg, closeimg, adminhomebackgroudimg;

    private JTextField qtext, opt1text, opt2text, opt3text, opt4text, anstext;

    public addNewQuestion() {
        initComponents();

        try {
            //Counting the Question Number from Database
            Connection conn = connectionProvider.getCon();
            Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = statement.executeQuery("SELECT COUNT(id) FROM question");
            if (rs.first()) {
                int id = rs.getInt(1);
                id = id + 1;
                String str = String.valueOf(id);
                nolabel.setText(str);
            } else {
                nolabel.setText("1");
            }
        } catch (SQLException e) {
            //JFrame jf = new JFrame();
            //jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void initComponents() {
        this.setSize(860, 600);
        this.setLocationRelativeTo(null);
        this.setTitle("Question Page");

//Frame in Container c
        c = this.getContentPane();
        c.setLayout(null);

        f1 = new Font("Tahoma", Font.BOLD, 14);
        f2 = new Font("Tahoma", Font.BOLD, 20);

        //Inserting Images
        cornerimg = new ImageIcon(getClass().getResource("/img/add new question.png"));
        saveimg = new ImageIcon(getClass().getResource("/img/save.png"));
        closeimg = new ImageIcon(getClass().getResource("/img/Close.png"));
        clearimg = new ImageIcon(getClass().getResource("/img/clear.png"));
        adminhomebackgroudimg = new ImageIcon(getClass().getResource("/img/logIn Background.jpg"));

        
        //Headline
        label1 = new JLabel();
        label1.setIcon(cornerimg);
        label1.setBounds(20, 10, 100, 100);
        c.add(label1);

        label2 = new JLabel("Add New Questions");
        label2.setBounds(100, 10, 200, 100);
        label2.setFont(f2);
        c.add(label2);
        
         label3 = new JLabel("(add exactly 10 questions)");
        label3.setBounds(320, 12, 200, 100);
        c.add(label3);

        //Close Button
        closebutton = new JButton();
        closebutton.setIcon(closeimg);
        closebutton.setBounds(750, 20, 60, 60);
        closebutton.setBackground(Color.white);
        c.add(closebutton);

        //Question NO
        qnolabel = new JLabel("Qusetion No : ");
        qnolabel.setBounds(100, 100, 150, 40);
        qnolabel.setFont(f1);
        c.add(qnolabel);

        //Question Number
        nolabel = new JLabel();
        nolabel.setBounds(250, 100, 100, 40);
        nolabel.setFont(f1);
        c.add(nolabel);

        //Question 
        qlabel = new JLabel("Question : ");
        qlabel.setBounds(100, 150, 150, 40);
        qlabel.setFont(f1);
        c.add(qlabel);

        qtext = new JTextField();
        qtext.setBounds(250, 150, 500, 40);
        qtext.setFont(f1);
        c.add(qtext);

         //Option1
        opt1label = new JLabel("Option1 :");
        opt1label.setBounds(100, 200, 150, 40);
        opt1label.setFont(f1);
        c.add(opt1label);

        opt1text = new JTextField();
        opt1text.setBounds(250, 200, 500, 40);
        opt1text.setFont(f1);
        c.add(opt1text);

        //Option2
        opt2label = new JLabel("Option2 :");
        opt2label.setBounds(100, 250, 150, 40);
        opt2label.setFont(f1);
        c.add(opt2label);

        opt2text = new JTextField();
        opt2text.setBounds(250, 250, 500, 40);
        opt2text.setFont(f1);
        c.add(opt2text);

        //Option3
        opt3label = new JLabel("Option3 :");
        opt3label.setBounds(100, 300, 150, 40);
        opt3label.setFont(f1);
        c.add(opt3label);

        opt3text = new JTextField();
        opt3text.setBounds(250, 300, 500, 40);
        opt3text.setFont(f1);
        c.add(opt3text);

        //Option4
        opt4label = new JLabel("Option4 :");
        opt4label.setBounds(100, 350, 150, 40);
        opt4label.setFont(f1);
        c.add(opt4label);

        opt4text = new JTextField();
        opt4text.setBounds(250, 350, 500, 40);
        opt4text.setFont(f1);
        c.add(opt4text);

        //Answer
        anslabel = new JLabel("Answer :");
        anslabel.setBounds(100, 400, 150, 40);
        anslabel.setFont(f1);
        c.add(anslabel);

        anstext = new JTextField();
        anstext.setBounds(250, 400, 500, 40);
        anstext.setFont(f1);
        c.add(anstext);

        //Save Button
        savebutton = new JButton("SAVE");
        savebutton.setIcon(saveimg);
        savebutton.setBounds(250, 460, 100, 30);
        c.add(savebutton);

        //Clear Button
        clearbutton = new JButton("CLEAR");
        clearbutton.setIcon(clearimg);
        clearbutton.setBounds(400, 460, 100, 30);
        c.add(clearbutton);

        //Admin Home Background
        background = new JLabel();
        background.setSize(1366, 768);
        background.setIcon(adminhomebackgroudimg);
        c.add(background);

        //Save the New Question in the Database
        savebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String id = nolabel.getText();
                String question = qtext.getText();
                String opt1 = opt1text.getText();
                String opt2 = opt2text.getText();
                String opt3 = opt3text.getText();
                String opt4 = opt4text.getText();
                String answer = anstext.getText();

                try {
                    Connection con = connectionProvider.getCon();
                    PreparedStatement ps = con.prepareStatement("INSERT INTO question VALUES (?,?,?,?,?,?,?)");
                    ps.setString(1, id);
                    ps.setString(2, question);
                    ps.setString(3, opt1);
                    ps.setString(4, opt2);
                    ps.setString(5, opt3);
                    ps.setString(6, opt4);
                    ps.setString(7, answer);
                    ps.executeUpdate();
                    JFrame jf = new JFrame();
                    jf.setAlwaysOnTop(true);
                    JOptionPane.showMessageDialog(jf, "Successfully Updated");
                    setVisible(false);
                    new addNewQuestion().setVisible(true);
                } catch (HeadlessException | SecurityException | SQLException ex) {
                    JFrame jf = new JFrame();
                    jf.setAlwaysOnTop(true);
                    JOptionPane.showMessageDialog(jf, ex);
                }
            }
        });

        //clear button action
        clearbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                qtext.setText("");
                opt1text.setText("");
                opt2text.setText("");
                opt3text.setText("");
                opt4text.setText("");
                anstext.setText("");
            }
        });
        
        
        
        //closebutton action
        closebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminHome.open=0;
                setVisible(false);
            }
        });

    }

    public static void main(String[] args) {

        addNewQuestion frame = new addNewQuestion();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
       // frame.setUndecorated(true);
        frame.setResizable(false);
    }

}
