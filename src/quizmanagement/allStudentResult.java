package quizmanagement;

import java.sql.*;
import project.connectionProvider;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class allStudentResult extends JFrame {

    private Container c;
    private JButton  closebutton;
    private JLabel background, label1, label2, filterlabel, qnolabel, qlabel, opt1label, opt2label, opt3label, opt4label, anslabel;
    private Font f1, f2;
    private ImageIcon cornerimg, saveimg, clearimg, closeimg, backgroudimg;
    private JTextField filtertext, opt1text, opt2text, opt3text, opt4text, anstext;
    private JTable table;
    private JScrollPane scroll;
    private DefaultTableModel model;
    private String[] column = {"ID", "Question", "Option1", "Option2", "Option3", "Option4", "Answer"};
    private String[] rows = new String[7];

    public allStudentResult() {
        initComponents();

        try {
            Connection conn = connectionProvider.getCon();
            Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = statement.executeQuery("SELECT * FROM studentdetail");
           // table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void initComponents() {
        this.setSize(860, 600);
        this.setLocationRelativeTo(null);
        this.setTitle("All Result Page");

        //Frame in Container c
        c = this.getContentPane();
        c.setLayout(null);

        f1 = new Font("Tahoma", Font.BOLD, 14);
        f2 = new Font("Tahoma", Font.BOLD, 20);

        //Inserting Images
        cornerimg = new ImageIcon(getClass().getResource("/img/all student result.png"));
        saveimg = new ImageIcon(getClass().getResource("/img/save.png"));
        closeimg = new ImageIcon(getClass().getResource("/img/Close.png"));
        clearimg = new ImageIcon(getClass().getResource("/img/clear.png"));
        backgroudimg = new ImageIcon(getClass().getResource("/img/logIn Background.jpg"));

        //Result img
        label1 = new JLabel();
        label1.setIcon(cornerimg);
        label1.setBounds(20, 10, 100, 100);
        c.add(label1);

        //All Student Result label
        label2 = new JLabel("All Student Results");
        label2.setBounds(100, 10, 200, 100);
        label2.setFont(f2);
        c.add(label2);

        //Filter label
        filterlabel = new JLabel("Filter By Marks");
        filterlabel.setBounds(50, 90, 200, 100);
        filterlabel.setFont(f1);
        c.add(filterlabel);

        //Filter Text Field
        filtertext = new JTextField();
        filtertext.setBounds(180, 130, 100, 30);
        filtertext.setFont(f1);
        c.add(filtertext);

        //Table
        table = new JTable();

        model = new DefaultTableModel();
        model.setColumnIdentifiers(column);
        table.setModel(model);
        table.setFont(f1);
        table.setRowHeight(20);
        scroll = new JScrollPane(table);
        scroll.setBounds(20, 180, 800, 300);
        c.add(scroll);

        //Close Button
        closebutton = new JButton();
        closebutton.setIcon(closeimg);
        closebutton.setBounds(780, 20, 50, 50);
        c.add(closebutton);

        //Background
        background = new JLabel();
        background.setSize(860, 600);
        background.setIcon(backgroudimg);
        c.add(background);

        //closebutton action
        closebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminHome.open = 0;
                setVisible(false);

            }
        });

        //Filter text
        filtertext.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent evt) {

            }

            @Override
            public void keyPressed(KeyEvent evt) {

            }

            @Override
            public void keyReleased(KeyEvent evt) {
                int marks;
                if (filtertext.getText().equals("")) {
                    marks = 0;
                } else {
                    marks = Integer.parseInt(filtertext.getText());
                    try {
                        Connection conn = connectionProvider.getCon();
                        Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                        ResultSet rs = statement.executeQuery("SELECT * FROM studentdetail WHERE marks >="+marks+"");
                        table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
                        table.setModel(DbUtils.resultSetToTableModel(rs));
                    } catch (Exception e) {
                        
                        JFrame jf=new JFrame();
                        jf.setAlwaysOnTop(true);
                        JOptionPane.showMessageDialog(jf, e);
                    }
                }
            }
        });

    }

    public static void main(String[] args) {

        allStudentResult frame = new allStudentResult();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        //frame.setUndecorated(true);
        frame.setResizable(false);
        frame.setAlwaysOnTop(true);
    }

}
