
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
import javax.swing.JTextArea;


public class ExamInstruction extends JFrame{
    public String id;

      private Container c;
    private JButton  startbutton;
    private JLabel background, label1, label2;
    private Font f1, f2;
    private ImageIcon  cornerimg, backgroudimg;
    private JTextArea textarea;

    public ExamInstruction(){
        initComponents();
    }
    
    public ExamInstruction(String ID){
        initComponents();
        //JOptionPane.showMessageDialog(null,ID);
        id=ID;
    }
    
    
    private void initComponents() {
        this.setSize(860, 600);
        this.setLocationRelativeTo(null);
        this.setTitle("Instructions ");

        //Frame in Container c
        c = this.getContentPane();
        c.setLayout(null);

        f1 = new Font("Tahoma", Font.BOLD, 14);
        f2 = new Font("Tahoma", Font.BOLD, 20);

        //Inserting Images
        cornerimg = new ImageIcon(getClass().getResource("/img/index student.png"));
        backgroudimg = new ImageIcon(getClass().getResource("/img/logIn Background.jpg"));
        
 
        //Headline 
        label1 = new JLabel();
        label1.setIcon(cornerimg);
        label1.setBounds(30, 10, 100, 100);
        c.add(label1);
      
        label2 = new JLabel("Instructions");
        label2.setBounds(100, 10, 200, 100);
        label2.setFont(f2);
        c.add(label2);
        
        //Instruction Text Area
        textarea=new JTextArea("  During the exam: \n\n" +
"1. The student may not use his or her textbook course note  \n\n" +
"2. Students must complete the questions\n\n" +
"3. Students must not stop the session and then return to it. \n\n" +
"4. It is especially important in the online environment where the system will  time out and not allow the student or you to reenter the exam.");
        textarea.setBounds(30,130,780,300);
        textarea.setFont(f2);
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setEditable(false);
        c.add(textarea);
           
        //start Button
        startbutton=new JButton("START QUIZ"); 
       startbutton.setBounds(330, 450, 150, 40);
       startbutton.setBackground(Color.white);
       startbutton.setFont(f1);
        c.add(startbutton);

         // Background
        background = new JLabel();
        background.setSize(1366, 768);
        background.setIcon(backgroudimg);
        c.add(background);
        

        //Start Button Action
        startbutton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                setVisible(false);
                new ExaminationPage(id).setVisible(true);
                
            }              
       });    
        
    }
     public static void main(String[] args) {

        ExamInstruction frame = new ExamInstruction();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
       // frame.setUndecorated(true);
        frame.setResizable(false);
    }
    
}
