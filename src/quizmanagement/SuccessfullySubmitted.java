
package quizmanagement;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SuccessfullySubmitted extends JFrame {
    
    
        private Container c;
    private JButton closebutton;
    private JLabel background, marklabel, successlabel;
    private Font f1, f2;
    private ImageIcon  closeimg, backgroudimg;

    private JTextField qtext, opt1text, opt2text, opt3text, opt4text, anstext;
    
    public SuccessfullySubmitted() 
    {
        initComponents();
    }
    
    public SuccessfullySubmitted(String marks) 
    {
        initComponents();
        String marks1="Marks Obtained :"+marks;
        marklabel.setText(marks1);
    }
    
    private void initComponents() {
        this.setSize(860, 600);
        this.setLocationRelativeTo(null);
        this.setTitle("Mark Page");

//Frame in Container c
        c = this.getContentPane();
        c.setLayout(null);

        f1= new Font("Tahoma", Font.BOLD, 34);
        f2= new Font("Tahoma", Font.BOLD, 26);
        

        //Inserting Images
        closeimg = new ImageIcon(getClass().getResource("/img/Close.png"));
        backgroudimg = new ImageIcon(getClass().getResource("/img/logIn Background.jpg"));

        //Mark label
        marklabel = new JLabel("Obtained Mark: 10");
        marklabel.setBounds(250, 150, 400, 100);
        marklabel.setFont(f1);
        c.add(marklabel);

        
        //Success Label
        successlabel = new JLabel("Successfully Updated");
        successlabel.setBounds(270, 200, 400, 100);
        successlabel.setFont(f2);
        c.add(successlabel);
        
        
        //Close Button
        closebutton=new JButton();
        closebutton.setIcon(closeimg);
        closebutton.setBounds(780,20,50,50);
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
                setVisible(false);
                new Index().setVisible(true);
            }
        });
        

        
    }
    
    
    public static void main(String[] args) {

        SuccessfullySubmitted frame = new SuccessfullySubmitted();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
       // frame.setUndecorated(true);
        frame.setResizable(false);
    }
    
}
