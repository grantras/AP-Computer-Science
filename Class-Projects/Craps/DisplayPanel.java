/*  1:   */ import java.awt.Color;
/*  2:   */ import java.awt.Font;
/*  3:   */ import java.awt.GridLayout;
/*  4:   */ import javax.swing.JLabel;
/*  5:   */ import javax.swing.JPanel;
/*  6:   */ import javax.swing.JTextField;
/*  7:   */ import javax.swing.border.EmptyBorder;
/*  8:   */ 
/*  9:   */ public class DisplayPanel
/* 10:   */   extends JPanel
/* 11:   */ {
/* 12:   */   private JTextField wonText;
/* 13:   */   private JTextField lostText;
/* 14:   */   private JTextField pointText;
/* 15:   */   private int wonCount;
/* 16:   */   private int lostCount;
/* 17:   */   
/* 18:   */   public DisplayPanel()
/* 19:   */   {
/* 20:15 */     super(new GridLayout(2, 3, 10, 0));
/* 21:16 */     setBorder(new EmptyBorder(0, 0, 5, 0));
/* 22:   */     
/* 23:18 */     add(new JLabel("    Won:"));
/* 24:19 */     add(new JLabel("    Lost:"));
/* 25:20 */     add(new JLabel("    Point:"));
/* 26:   */     
/* 27:22 */     Font displayFont = new Font("Monospaced", 1, 16);
/* 28:   */     
/* 29:24 */     this.wonText = new JTextField("  0", 5);
/* 30:25 */     this.wonText.setFont(displayFont);
/* 31:26 */     this.wonText.setEditable(false);
/* 32:27 */     this.wonText.setBackground(Color.WHITE);
/* 33:28 */     add(this.wonText);
/* 34:   */     
/* 35:30 */     this.lostText = new JTextField("  0", 5);
/* 36:31 */     this.lostText.setFont(displayFont);
/* 37:32 */     this.lostText.setEditable(false);
/* 38:33 */     this.lostText.setBackground(Color.WHITE);
/* 39:34 */     add(this.lostText);
/* 40:   */     
/* 41:36 */     this.pointText = new JTextField(5);
/* 42:37 */     this.pointText.setFont(displayFont);
/* 43:38 */     this.pointText.setEditable(false);
/* 44:39 */     this.pointText.setBackground(Color.DARK_GRAY);
/* 45:40 */     add(this.pointText);
/* 46:   */   }
/* 47:   */   
/* 48:   */   public void update(int result, int point)
/* 49:   */   {
/* 50:47 */     if (result > 0)
/* 51:   */     {
/* 52:49 */       this.wonCount += 1;
/* 53:50 */       this.wonText.setText("  " + this.wonCount);
/* 54:51 */       this.pointText.setText("");
/* 55:52 */       this.pointText.setBackground(Color.DARK_GRAY);
/* 56:   */     }
/* 57:54 */     else if (result < 0)
/* 58:   */     {
/* 59:56 */       this.lostCount += 1;
/* 60:57 */       this.lostText.setText("  " + this.lostCount);
/* 61:58 */       this.pointText.setText("");
/* 62:59 */       this.pointText.setBackground(Color.DARK_GRAY);
/* 63:   */     }
/* 64:   */     else
/* 65:   */     {
/* 66:63 */       this.pointText.setText("  " + point);
/* 67:64 */       this.pointText.setBackground(Color.YELLOW);
/* 68:   */     }
/* 69:   */   }
/* 70:   */ }



/* Location:           O:\APCS\StudentFiles\Ch07\Craps\Craps.jar

 * Qualified Name:     DisplayPanel

 * JD-Core Version:    0.7.0.1

 */
