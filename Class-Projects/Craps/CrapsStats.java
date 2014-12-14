/*  1:   */ import java.awt.Container;
/*  2:   */ import java.awt.FlowLayout;
/*  3:   */ import java.awt.event.ActionEvent;
/*  4:   */ import java.awt.event.ActionListener;
/*  5:   */ import javax.swing.JFrame;
/*  6:   */ import javax.swing.JLabel;
/*  7:   */ import javax.swing.JTextField;
/*  8:   */ 
/*  9:   */ public class CrapsStats
/* 10:   */   extends JFrame
/* 11:   */   implements ActionListener
/* 12:   */ {
/* 13:   */   private CrapsGame game;
/* 14:   */   private JTextField numberIn;
/* 15:   */   private JTextField statsOut;
/* 16:   */   
/* 17:   */   public CrapsStats()
/* 18:   */   {
/* 19:14 */     super("Craps test");
/* 20:   */     
/* 21:16 */     Container c = getContentPane();
/* 22:17 */     c.setLayout(new FlowLayout());
/* 23:   */     
/* 24:19 */     c.add(new JLabel("Number of games to run:"));
/* 25:   */     
/* 26:21 */     this.numberIn = new JTextField(5);
/* 27:22 */     this.numberIn.addActionListener(this);
/* 28:23 */     c.add(this.numberIn);
/* 29:   */     
/* 30:25 */     this.statsOut = new JTextField(18);
/* 31:26 */     this.statsOut.setEditable(false);
/* 32:27 */     c.add(this.statsOut);
/* 33:   */     
/* 34:29 */     this.game = new CrapsGame();
/* 35:   */   }
/* 36:   */   
/* 37:   */   public void actionPerformed(ActionEvent e)
/* 38:   */   {
/* 39:35 */     String s = this.numberIn.getText();
/* 40:36 */     int nGames = Integer.parseInt(s);
/* 41:37 */     int gameCount = 0;int winCount = 0;
/* 42:38 */     Die die1 = new Die();
/* 43:39 */     Die die2 = new Die();
/* 44:41 */     while (gameCount < nGames)
/* 45:   */     {
/* 46:43 */       die1.roll();
/* 47:44 */       die2.roll();
/* 48:45 */       int total = die1.getNumDots() + die2.getNumDots();
/* 49:46 */       int result = this.game.processRoll(total);
/* 50:47 */       if (result != 0) {
/* 51:48 */         gameCount++;
/* 52:   */       }
/* 53:49 */       if (result > 0) {
/* 54:50 */         winCount++;
/* 55:   */       }
/* 56:   */     }
/* 57:52 */     this.numberIn.setText("");
/* 58:53 */     this.statsOut.setText(" Games: " + gameCount + " Wins: " + winCount);
/* 59:   */   }
/* 60:   */   
/* 61:   */   public static void main(String[] args)
/* 62:   */   {
/* 63:58 */     CrapsStats window = new CrapsStats();
/* 64:59 */     window.setBounds(100, 100, 300, 100);
/* 65:60 */     window.setDefaultCloseOperation(3);
/* 66:61 */     window.setResizable(false);
/* 67:62 */     window.setVisible(true);
/* 68:   */   }
/* 69:   */ }



/* Location:           O:\APCS\StudentFiles\Ch07\Craps\Craps.jar

 * Qualified Name:     CrapsStats

 * JD-Core Version:    0.7.0.1

 */
