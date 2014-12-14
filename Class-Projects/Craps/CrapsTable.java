/*  1:   */ import java.awt.Color;
/*  2:   */ import java.awt.Graphics;
/*  3:   */ import java.awt.event.ActionEvent;
/*  4:   */ import java.awt.event.ActionListener;
/*  5:   */ import javax.swing.JPanel;
/*  6:   */ import javax.swing.Timer;
/*  7:   */ import javax.swing.border.LineBorder;
/*  8:   */ 
/*  9:   */ public class CrapsTable
/* 10:   */   extends JPanel
/* 11:   */   implements ActionListener
/* 12:   */ {
/* 13:   */   private RollingDie die1;
/* 14:   */   private RollingDie die2;
/* 15:12 */   private final int delay = 20;
/* 16:   */   private Timer clock;
/* 17:   */   private CrapsGame game;
/* 18:   */   private DisplayPanel display;
/* 19:   */   
/* 20:   */   public CrapsTable(DisplayPanel displ)
/* 21:   */   {
/* 22:20 */     setBackground(Color.green);
/* 23:21 */     setBorder(new LineBorder(Color.ORANGE.darker(), 3));
/* 24:22 */     this.display = displ;
/* 25:23 */     this.game = new CrapsGame();
/* 26:24 */     this.die1 = new RollingDie();
/* 27:25 */     this.die2 = new RollingDie();
/* 28:26 */     this.clock = new Timer(20, this);
/* 29:   */   }
/* 30:   */   
/* 31:   */   public void rollDice()
/* 32:   */   {
/* 33:33 */     RollingDie.setBounds(3, getWidth() - 3, 3, getHeight() - 3);
/* 34:34 */     this.die1.roll();
/* 35:35 */     this.die2.roll();
/* 36:36 */     this.clock.start();
/* 37:   */   }
/* 38:   */   
/* 39:   */   public void actionPerformed(ActionEvent e)
/* 40:   */   {
/* 41:42 */     if (diceAreRolling())
/* 42:   */     {
/* 43:44 */       if (!this.clock.isRunning()) {
/* 44:45 */         this.clock.restart();
/* 45:   */       }
/* 46:46 */       if (this.die1.isRolling()) {
/* 47:47 */         this.die1.avoidCollision(this.die2);
/* 48:48 */       } else if (this.die2.isRolling()) {
/* 49:49 */         this.die2.avoidCollision(this.die1);
/* 50:   */       }
/* 51:   */     }
/* 52:   */     else
/* 53:   */     {
/* 54:53 */       this.clock.stop();
/* 55:54 */       int total = this.die1.getNumDots() + this.die2.getNumDots();
/* 56:55 */       int result = this.game.processRoll(total);
/* 57:56 */       int point = this.game.getPoint();
/* 58:57 */       this.display.update(result, point);
/* 59:   */     }
/* 60:60 */     repaint();
/* 61:   */   }
/* 62:   */   
/* 63:   */   public boolean diceAreRolling()
/* 64:   */   {
/* 65:67 */     return (this.die1.isRolling()) || (this.die2.isRolling());
/* 66:   */   }
/* 67:   */   
/* 68:   */   public void paintComponent(Graphics g)
/* 69:   */   {
/* 70:73 */     super.paintComponent(g);
/* 71:74 */     this.die1.draw(g);
/* 72:75 */     this.die2.draw(g);
/* 73:   */   }
/* 74:   */ }



/* Location:           O:\APCS\StudentFiles\Ch07\Craps\Craps.jar

 * Qualified Name:     CrapsTable

 * JD-Core Version:    0.7.0.1

 */
