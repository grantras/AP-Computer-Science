/*  1:   */ import java.io.PrintStream;
/*  2:   */ 
/*  3:   */ public class DieTest
/*  4:   */ {
/*  5:   */   public static void main(String[] args)
/*  6:   */   {
/*  7: 5 */     Die die = new Die();
/*  8: 6 */     die.roll();
/*  9: 7 */     System.out.println(die.getNumDots());
/* 10: 8 */     die.roll();
/* 11: 9 */     System.out.println(die.getNumDots());
/* 12:10 */     die.roll();
/* 13:11 */     System.out.println(die.getNumDots());
/* 14:   */   }
/* 15:   */ }



/* Location:           O:\APCS\StudentFiles\Ch07\Craps\Craps.jar

 * Qualified Name:     DieTest

 * JD-Core Version:    0.7.0.1

 */
