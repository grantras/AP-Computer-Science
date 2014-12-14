/*  1:   */ public class Die
/*  2:   */ {
/*  3:   */   private int numDots;
/*  4:   */   
/*  5:   */   public void roll()
/*  6:   */   {
/*  7: 8 */     this.numDots = ((int)(6.0D * Math.random()) + 1);
/*  8:   */   }
/*  9:   */   
/* 10:   */   public int getNumDots()
/* 11:   */   {
/* 12:14 */     return this.numDots;
/* 13:   */   }
/* 14:   */ }



/* Location:           O:\APCS\StudentFiles\Ch07\Craps\Craps.jar

 * Qualified Name:     Die

 * JD-Core Version:    0.7.0.1

 */
