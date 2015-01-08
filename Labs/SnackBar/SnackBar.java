import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
 
public class SnackBar
  extends JFrame
  implements ActionListener
  {
   private static final String MY_PASSWORD = "jinx";
   private VendingMachine machine1;
   private VendingMachine machine2;
   private VendingMachine machine3;
   
   public SnackBar()
   {
     super("Snack Bar");
     
     Color brandColor1 = new Color(130, 30, 10);
     Color brandColor2 = new Color(255, 180, 0);
     Color brandColor3 = new Color(90, 180, 0);
     
 
     ImageIcon coin = new ImageIcon("coin.gif");
     
     this.machine1 = new VendingMachine("Java", brandColor1, 45, coin);
     this.machine2 = new VendingMachine("JApple", brandColor2, 50, coin);
     this.machine3 = new VendingMachine("Jinx", brandColor3, 35, coin);
     
     Box wall = Box.createHorizontalBox();
     wall.add(Box.createHorizontalStrut(5));
     wall.add(this.machine1);
     wall.add(Box.createHorizontalStrut(5));
     wall.add(this.machine2);
     wall.add(Box.createHorizontalStrut(5));
     wall.add(this.machine3);
     wall.add(Box.createHorizontalStrut(5));
     
     JPanel service = new JPanel();
     service.add(new JLabel(" Service login: "));
     JPasswordField password = new JPasswordField("", 5);
     password.addActionListener(this);
     service.add(password);
     
     Container c = getContentPane();
     c.setBackground(Color.GRAY);
     c.add(wall, "Center");
     c.add(service, "South");
   }
   
   public void actionPerformed(ActionEvent e)
   {
     JPasswordField password = (JPasswordField)e.getSource();
     String word = new String(password.getPassword());
     password.setText("");
     if ("jinx".equals(word))
     {
       this.machine1.reload();
       this.machine2.reload();
       this.machine3.reload();
       JOptionPane.showMessageDialog(null, "Machines reloaded", "Service", 1);
     }
     else
     {
       JOptionPane.showMessageDialog(null, "Login failed", "Service", 0);
     }
   }
   
   public static void main(String[] args)
   {
     SnackBar window = new SnackBar();
     window.setBounds(50, 50, 520, 310);
     window.setDefaultCloseOperation(3);
     window.setResizable(false);
     window.setVisible(true);
   }
 }
