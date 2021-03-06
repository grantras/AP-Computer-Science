/*
Written by Joe Sweeney (Jeteroll), Grant Rassumusen (grantras) and Cooper Pellaton (cooperpell) in November 2014.
*/

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

class SFrame extends JFrame implements ActionListener{
  
  protected JButton b1, b2;
    
  public SFrame(){
    super("Title");
    b1 = new JButton("test");
    b2 = new JButton("test2");
    
    setLayout(new FlowLayout());
    add(b1);
    add(b2);
    
    b1.addActionListener(this);
    b1.setActionCommand("test");
    b2.addActionListener(this);
    b2.setActionCommand("test2");
  }
  
  public void actionPerformed(ActionEvent e){
    if("test".equals(e.getActionCommand())){
      System.out.println("test");
    }
    else if("test2".equals(e.getActionCommand())){
      System.out.println("test2");
    }
  }
}
