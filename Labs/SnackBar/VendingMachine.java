import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VendingMachine
   extends JPanel
   implements ActionListener
   {
   private static final int FULL_STOCK = 5;
   private JButton deposit25c;
   private JButton deposit10c;
   private JButton deposit5c;
   private JButton go;
   private JTextField display;
   private Vendor vendor;
   boolean trayFull;
   Color brandColor;
   String brandName;
   
   public VendingMachine(String brand, Color color, int price, ImageIcon coin)
   {
   setBackground(Color.WHITE);
     this.brandColor = color;
     this.brandName = brand;
     
     JTextField banner = new JTextField("  " + this.brandName + "  " + price + "c  ");
     
     banner.setEditable(false);
     banner.setFont(new Font("Serif", 1, 14));
     banner.setHorizontalAlignment(0);
     
     this.deposit25c = new JButton(" 25 ", coin);
     this.deposit25c.addActionListener(this);
     this.deposit10c = new JButton(" 10 ", coin);
     this.deposit10c.addActionListener(this);
     this.deposit5c = new JButton("  5 ", coin);
     this.deposit5c.addActionListener(this);
     this.go = new JButton("   ");
     this.go.setBackground(Color.RED);
     this.go.addActionListener(this);
     JPanel buttons = new JPanel(new GridLayout(3, 1, 5, 0));
     buttons.setBackground(Color.BLUE);
     buttons.add(this.deposit25c);
     buttons.add(this.deposit10c);
     buttons.add(this.deposit5c);
     
     this.display = new JTextField("0  ");
     this.display.setFont(new Font("Monospaced", 1, 16));
     this.display.setBackground(Color.YELLOW);
     this.display.setEditable(false);
     this.display.setHorizontalAlignment(4);
     
     Box b1 = Box.createVerticalBox();
     b1.add(banner);
     b1.add(Box.createVerticalStrut(5));
     b1.add(this.display);
     b1.add(Box.createVerticalStrut(12));
     Box b2 = Box.createHorizontalBox();
     b2.add(Box.createHorizontalStrut(60));
     Box b3 = Box.createVerticalBox();
     b3.add(this.go);
     b3.add(Box.createVerticalStrut(8));
     b3.add(buttons);
     b2.add(b3);
     b1.add(b2);
     b1.add(Box.createVerticalStrut(5));
     add(b1);
     
     this.vendor = new Vendor(price, 5);
   }
   
   public void reload()
   {
     this.vendor.setStock(5);
     this.display.setText(" " + this.vendor.getDeposit() + "  ");
     repaint();
   }
   
   public void actionPerformed(ActionEvent e)
   {
     JButton b = (JButton)e.getSource();
     if (b == this.deposit25c)
     {
       this.vendor.addMoney(25);
     }
     else if (b == this.deposit10c)
     {
       this.vendor.addMoney(10);
     }
     else if (b == this.deposit5c)
     {
       this.vendor.addMoney(5);
     }
     else if (b == this.go)
     {
       this.trayFull = this.vendor.makeSale();
       int change = this.vendor.getChange();
       if (this.trayFull)
       {
         repaint();
         JOptionPane.showMessageDialog(null, "Enjoy your " + this.brandName + "\n" + " Change " + change + "c", "Enjoy " + this.brandName, -1);
         
 
         this.trayFull = false;
       }
       else if (change > 0)
      {
         JOptionPane.showMessageDialog(null, "Take " + change + "c back", "Money back", 0);
       }
     }
     if (this.vendor.getStock() > 0) {
       this.display.setText(" " + this.vendor.getDeposit() + "  ");
     } else {
       this.display.setText("Call service ");
     }
     repaint();
   }
   
   public void paintComponent(Graphics g)
   {
     super.paintComponent(g);
     
     int x0 = getWidth() / 12;
     int y0 = getHeight() / 2;
     int yStep = 14;
     
     g.setColor(Color.BLACK);
     g.drawRect(x0, y0, 28, 74);
     
     int y = y0 + 4;int x = x0 + 4;
     int stock = this.vendor.getStock();
     int count = 5;
     while (count > 0)
     {
       if (count <= stock) {
         drawCan(g, x, y);
       }
       y += 14;
       count--;
     }
     g.setColor(Color.BLUE);
     y += 14;
     g.drawRect(x0, y - 4, 28, 18);
     if (this.trayFull) {
       drawCan(g, x, y);
     }
   }
   
   private void drawCan(Graphics g, int x, int y)
   {
     g.setColor(this.brandColor);
     g.fillRoundRect(x, y, 20, 10, 4, 4);
     g.setColor(Color.WHITE);
     g.drawLine(x + 2, y + 4, x + 14, y + 4);
     g.drawLine(x + 2, y + 6, x + 14, y + 6);
   }
}
