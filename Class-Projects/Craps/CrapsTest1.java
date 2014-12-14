/*  1:   */ import java.awt.Color;
/*  2:   */ import java.awt.Container;
/*  3:   */ import java.awt.FlowLayout;
/*  4:   */ import java.awt.event.ActionEvent;
/*  5:   */ import java.awt.event.ActionListener;
/*  6:   */ import javax.swing.JFrame;
/*  7:   */ import javax.swing.JLabel;
/*  8:   */ import javax.swing.JScrollPane;
/*  9:   */ import javax.swing.JTextArea;
/* 10:   */ import javax.swing.JTextField;
/* 11:   */ 
/* 12:   */ public class CrapsTest1
/* 13:   */   extends JFrame
/* 14:   */   implements ActionListener
/* 15:   */ {
/* 16:   */   private CrapsGame game;
/* 17:   */   private JTextField input;
/* 18:   */   private JTextArea display;
/* 19:   */   
/* 20:   */   public CrapsTest1()
/* 21:   */   {
/* 22:15 */     super("Craps: Test 1");
/* 23:   */     
/* 24:17 */     Container c = getContentPane();
/* 25:18 */     c.setLayout(new FlowLayout());
/* 26:   */     
/* 27:20 */     c.add(new JLabel("Next roll:"));
/* 28:21 */     this.input = new JTextField(5);
/* 29:22 */     this.input.setBackground(Color.YELLOW);
/* 30:23 */     this.input.addActionListener(this);
/* 31:24 */     c.add(this.input);
/* 32:   */     
/* 33:26 */     this.display = new JTextArea(10, 20);
/* 34:27 */     this.display.setEditable(false);
/* 35:28 */     this.display.setBackground(Color.WHITE);
/* 36:29 */     c.add(new JScrollPane(this.display, 
/* 37:30 */       22, 
/* 38:31 */       31));
/* 39:   */     
/* 40:33 */     this.game = new CrapsGame();
/* 41:   */   }
/* 42:   */   
/* 43:   */   public void actionPerformed(ActionEvent e)
/* 44:   */   {
/* 45:40 */     String s = this.input.getText().trim();
/* 46:41 */     int total = Integer.parseInt(s);
/* 47:42 */     int result = this.game.processRoll(total);
/* 48:43 */     int point = this.game.getPoint();
/* 49:44 */     this.input.setText("");
/* 50:45 */     this.display.append(total + ":  Result = " + result + " Point = " + point + "\n");
/* 51:   */   }
/* 52:   */   
/* 53:   */   public static void main(String[] args)
/* 54:   */   {
/* 55:50 */     CrapsTest1 window = new CrapsTest1();
/* 56:51 */     window.setBounds(100, 100, 300, 240);
/* 57:52 */     window.setDefaultCloseOperation(3);
/* 58:53 */     window.setResizable(false);
/* 59:54 */     window.setVisible(true);
/* 60:   */   }
/* 61:   */ }



/* Location:           O:\APCS\StudentFiles\Ch07\Craps\Craps.jar

 * Qualified Name:     CrapsTest1

 * JD-Core Version:    0.7.0.1

 */
