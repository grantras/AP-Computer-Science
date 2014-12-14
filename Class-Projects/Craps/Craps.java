/*  1:   */ import java.awt.BorderLayout;
/*  2:   */ import java.awt.Container;
/*  3:   */ import javax.swing.JFrame;
/*  4:   */ import javax.swing.JPanel;
/*  5:   */ import javax.swing.border.EmptyBorder;
/*  6:   */ 
/*  7:   */ public class Craps
/*  8:   */   extends JFrame
/*  9:   */ {
/* 10:   */   public Craps()
/* 11:   */   {
/* 12:10 */     super("Craps");
/* 13:   */     
/* 14:12 */     DisplayPanel display = new DisplayPanel();
/* 15:13 */     CrapsTable table = new CrapsTable(display);
/* 16:14 */     ControlPanel controls = new ControlPanel(table);
/* 17:   */     
/* 18:16 */     JPanel panel = new JPanel();
/* 19:17 */     panel.setLayout(new BorderLayout());
/* 20:18 */     panel.setBorder(new EmptyBorder(0, 5, 0, 5));
/* 21:19 */     panel.add(display, "North");
/* 22:20 */     panel.add(table, "Center");
/* 23:21 */     panel.add(controls, "South");
/* 24:   */     
/* 25:23 */     Container c = getContentPane();
/* 26:24 */     c.add(panel, "Center");
/* 27:   */   }
/* 28:   */   
/* 29:   */   public static void main(String[] args)
/* 30:   */   {
/* 31:29 */     Craps window = new Craps();
/* 32:30 */     window.setBounds(100, 100, 320, 240);
/* 33:31 */     window.setDefaultCloseOperation(3);
/* 34:32 */     window.setVisible(true);
/* 35:   */   }
/* 36:   */ }



/* Location:           O:\APCS\StudentFiles\Ch07\Craps\Craps.jar

 * Qualified Name:     Craps

 * JD-Core Version:    0.7.0.1

 */
