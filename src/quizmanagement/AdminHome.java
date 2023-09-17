package quizmanagement;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;


public class AdminHome extends JFrame {
    public static int open=0;

    private Container c;
  //  private JButton jButton1, jButton2, jButton3;
    private JLabel background;
    private Font f;
   private ImageIcon addimg, updateimg, allimg, deleteimg, resultimg, logoutimg, exitimg,adminhomebackgroudimg;
    private JMenuBar menubar;
    private JMenu addmenu,updatemenu,allmenu,deletemenu,resultmenu,logoutmenu,exitmenu;
   

    public AdminHome() {
        initComponents();
    }

    private void initComponents() {
        this.setSize(1260, 768);
        this.setLocationRelativeTo(null);
        this.setTitle("Admin Home Page");
        
//Frame in Container c
        c=this.getContentPane();
        c.setLayout(null);
        
        
        f = new Font("Tahoma", Font.BOLD, 14);
        
       
        menubar=new JMenuBar();
        this.setJMenuBar(menubar);
        
        //MenuItems
        addmenu=new JMenu("Add New Question");
         updatemenu=new JMenu("Update Question");
         allmenu=new JMenu("All Question");
         deletemenu=new JMenu("Delete Question");
         resultmenu=new JMenu("All Student Result");         
         logoutmenu=new JMenu("LogOut");            
         exitmenu=new JMenu("Exit");
         
     
         //Inserting Images
         addimg=new ImageIcon(getClass().getResource("/img/add new question.png"));
         updateimg=new ImageIcon(getClass().getResource("/img/Update Question.png"));
         allimg=new ImageIcon(getClass().getResource("/img/all questions.png"));
         deleteimg=new ImageIcon(getClass().getResource("/img/delete Question.png"));
         resultimg=new ImageIcon(getClass().getResource("/img/all student result.png"));
         logoutimg=new ImageIcon(getClass().getResource("/img/Logout.png"));
         exitimg=new ImageIcon(getClass().getResource("/img/Close.png"));
         adminhomebackgroudimg= new ImageIcon(getClass().getResource("/img/logIn Background.jpg"));
         
         //Add New Question Menu
        addmenu.setIcon(addimg);
        addmenu.setFont(f);
        addmenu.setSize(20,5);
        menubar.add(addmenu);
         
         //Update Question Menu
         updatemenu.setIcon(updateimg);
        updatemenu.setFont(f);
         menubar.add(updatemenu);
         
         //All Question Menu
         allmenu.setIcon(allimg);
         allmenu.setFont(f);
         menubar.add(allmenu);
         
         //Delete Question Menu
         deletemenu.setIcon(deleteimg);
        deletemenu.setFont(f);
         menubar.add(deletemenu);
         
         //Result Menu
         resultmenu.setIcon(resultimg);
        resultmenu.setFont(f);
         menubar.add(resultmenu);
         
         //LogOut Menu
         logoutmenu.setIcon(logoutimg);
        logoutmenu.setFont(f);
         menubar.add(logoutmenu);
         
         //Exit Menu
         exitmenu.setIcon(exitimg);
        exitmenu.setFont(f);
         menubar.add(exitmenu);
         
         //Admin Home Background
         background = new JLabel();
        background.setSize(1366, 768);
        background.setIcon(adminhomebackgroudimg);
       c.add(background);
       
       

       //Add Question Menu  Mouse Action
       addmenu.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(open==0)
                {
                    new addNewQuestion().setVisible(true);
                    open=1;
                }
                else
                {
                    JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, "Another frame is already open");
            
                  
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
               
            }

            @Override
            public void mouseExited(MouseEvent e) {
              
            }         
       }      
       );
       
       
       
       
       //Update Question Mouse Action
       updatemenu.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(open==0)
                {
                    new UpdateQuestion().setVisible(true);
                    open=1;
                }
                else
                {
                    JFrame jf = new JFrame();
            //jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, "Another frame is already open");

                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
               
            }

            @Override
            public void mouseExited(MouseEvent e) {
              
            }         
       }      
       );
       
       
       //Delete Question Action
       deletemenu.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(open==0)
                {
                    new DeleteQuestion().setVisible(true);
                    open=1;
                }
                else
                {
                    JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, "Another frame is already open");

                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
               
            }

            @Override
            public void mouseExited(MouseEvent e) {
              
            }         
       }      
       );
       
       //All Result Action
       resultmenu.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(open==0)
                {
                    new allStudentResult().setVisible(true);
                    open=1;
                }
                else
                {
                    JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, "Another frame is already open");

                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
               
            }

            @Override
            public void mouseExited(MouseEvent e) {
              
            }         
       }      
       );
       
       //LogOut Menu Action
       logoutmenu.addMouseListener(new MouseListener()
       {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            JFrame jf=new JFrame();
       jf.setAlwaysOnTop(true);
       int a=JOptionPane.showConfirmDialog(jf,"Do you want to Log Out!","LogOut",JOptionPane.YES_NO_OPTION);
       if(a==0)
       {
           setVisible(false);
           new LoginFrame().setVisible(true);
       }
   
        }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {    
            }
       });
       
       
       
       //All Question Action
       allmenu.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(open==0)
                {
                    new AllQuestion().setVisible(true);
                    open=1;
                }
                else
                {
                    JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, "Another frame is already open");

                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
               
            }

            @Override
            public void mouseExited(MouseEvent e) {
              
            }         
       }      
       );

       
       //Exit Menu Action
       exitmenu.addMouseListener(new MouseListener()
       {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            //JFrame jf=new JFrame();
       //jf.setAlwaysOnTop(true);
           // int a=JOptionPane.showConfirmDialog(jf,"Do you want to Log Out!","LogOut",JOptionPane.YES_NO_OPTION);
       int a=JOptionPane.showConfirmDialog(null,"Do you want to Exit!","Exit",JOptionPane.YES_NO_OPTION);
       if(a==0)
       {
           //System.exit(0);
           setVisible(false);
           new Index().setVisible(true);
       }
        }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
       });
       
       
       
       
       
    }

    //Main 
    public static void main(String[] args) {

        AdminHome frame = new AdminHome();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
      //  frame.setUndecorated(true);
        frame.setResizable(false);
    }

}
