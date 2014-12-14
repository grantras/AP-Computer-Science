/*  1:   */ public class CrapsGame
/*  2:   */ {
/*  3: 5 */   private int point = 0;
/*  4:   */   
/*  5:   */   public int processRoll(int total)
/*  6:   */   {
/*  7:   */     int result;
/*  8:19 */     if (this.point == 0)
/*  9:   */     {
/* 10:   */       //int result;
/* 11:21 */       if ((total == 7) || (total == 11))
/* 12:   */       {
/* 13:22 */         result = 1;
/* 14:   */       }
/* 15:   */       else
/* 16:   */       {
/* 17:   */         //int result;
/* 18:23 */         if ((total == 2) || (total == 3) || (total == 12))
/* 19:   */         {
/* 20:24 */           result = -1;
/* 21:   */         }
/* 22:   */         else
/* 23:   */         {
/* 24:27 */           result = 0;
/* 25:28 */           this.point = total;
/* 26:   */         }
/* 27:   */       }
/* 28:   */     }
/* 29:33 */     else if (total == this.point)
/* 30:   */     {
/* 31:35 */       result = 1;
/* 32:36 */       this.point = 0;
/* 33:   */     }
/* 34:38 */     else if (total == 7)
/* 35:   */     {
/* 36:40 */       result = -1;
/* 37:41 */       this.point = 0;
/* 38:   */     }
/* 39:   */     else
/* 40:   */     {
/* 41:44 */       result = 0;
/* 42:   */     }
/* 43:46 */     return result;
/* 44:   */   }
/* 45:   */   
/* 46:   */   public int getPoint()
/* 47:   */   {
/* 48:54 */     return this.point;
/* 49:   */   }
/* 50:   */ }



/* Location:           O:\APCS\StudentFiles\Ch07\Craps\Craps.jar

 * Qualified Name:     CrapsGame

 * JD-Core Version:    0.7.0.1

 */
