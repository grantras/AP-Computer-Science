/*  1:   */ import java.awt.event.ActionEvent;
/*  2:   */ import java.awt.event.ActionListener;
/*  3:   */ import javax.swing.JButton;
/*  4:   */ import javax.swing.JPanel;
/*  5:   */ 
/*  6:   */ public class ControlPanel
/*  7:   */   extends JPanel
/*  8:   */   implements ActionListener
/*  9:   */ {
/* 10:   */   private CrapsTable table;
/* 11:   */   
/* 12:   */   public ControlPanel(CrapsTable t)
/* 13:   */   {
/* 14:14 */     this.table = t;
/* 15:15 */     JButton rollButton = new JButton("Roll");
/* 16:16 */     rollButton.addActionListener(this);
/* 17:17 */     add(rollButton);
/* 18:   */   }
/* 19:   */   
/* 20:   */   public void actionPerformed(ActionEvent e)
/* 21:   */   {
/* 22:23 */     if (!this.table.diceAreRolling()) {
/* 23:24 */       this.table.rollDice();
/* 24:   */     }
/* 25:   */   }
/* 26:   */ }



/* Location:           O:\APCS\StudentFiles\Ch07\Craps\Craps.jar

 * Qualified Name:     ControlPanel

 * JD-Core Version:    0.7.0.1

 */
