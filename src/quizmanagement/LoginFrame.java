package quizmanagement;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame {

    private Container c;
    private JButton jButton1, jButton2;
    private JLabel jLabel1, jLabel2, jLabel3;
    private Font f;
    private ImageIcon loginimg, backimg, loginbackgroundimg;
    private JTextField usertextfield;
    private JPasswordField passwordfield;
    private JCheckBox showpassword;

    public LoginFrame() {
        initComponents();
    }

    private void initComponents() {
        this.setSize(1260, 768);
        this.setLocationRelativeTo(null);
        this.setTitle("Login Page");

        f = new Font("Tahoma", Font.BOLD, 14);

        loginimg = new ImageIcon(getClass().getResource("/img/login.png"));
        backimg = new ImageIcon(getClass().getResource("/img/Back.png"));
        loginbackgroundimg = new ImageIcon(getClass().getResource("/img/logIn Background.jpg"));

        c = this.getContentPane();
        c.setLayout(null);

        //User name label
        jLabel1 = new JLabel("User Name");
        jLabel1.setBounds(530, 100, 150, 40);
        jLabel1.setFont(f);
        c.add(jLabel1);

        
        //User name label
        usertextfield = new JTextField();
        usertextfield.setBounds(450, 150, 250, 30);
        c.add(usertextfield);

        //Password label
        jLabel2 = new JLabel("Password");
        jLabel2.setBounds(530, 200, 250, 40);
        jLabel2.setFont(f);
        c.add(jLabel2);

        //Pasword text
        passwordfield = new JPasswordField();
        passwordfield.setBounds(450, 250, 250, 30);
        passwordfield.setEchoChar(('*'));
        c.add(passwordfield);

        //showpasword checkbox 
        showpassword = new JCheckBox("Show Password");
        showpassword.setBounds(520, 300, 150, 40);
        showpassword.setOpaque(false);
        c.add(showpassword);

        //Login button
        jButton1 = new JButton("Login");
        jButton1.setFont(f);
        jButton1.setBounds(450, 370, 100, 30);
        jButton1.setBackground(Color.white);
        jButton1.setIcon(loginimg);
        c.add(jButton1);

        //Back button
        jButton2 = new JButton("Back");
        jButton2.setFont(f);
        jButton2.setBounds(600, 370, 100, 30);
        jButton2.setBackground(Color.white);
        jButton2.setIcon(backimg);
        c.add(jButton2);

        //Background
        jLabel3 = new JLabel();
        jLabel3.setSize(1366, 768);
        jLabel3.setIcon(loginbackgroundimg);
        c.add(jLabel3);

        //ShowPassword action
        showpassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showpassword.isSelected()) {
                    passwordfield.setEchoChar((char) 0);
                } else {
                    passwordfield.setEchoChar(('*'));

                }
            }
        }
        );

        
        //Login button Action
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String username = usertextfield.getText();
                String password = passwordfield.getText();

                if (username.equals("meem") && password.equals("123")) {
                    setVisible(false);
                    new AdminHome().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
                }
            }
        });
        
        //Back button Action

        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == jButton2) {
                    setVisible(false);
                    new Index().setVisible(true);
                }
            }
        });
    }

    public static void main(String[] args) {

        LoginFrame frame = new LoginFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
       //frame.setUndecorated(true);
        frame.setResizable(false);
    }
}
