/*   1:    */ import java.awt.Color;
/*   2:    */ import java.awt.Graphics;
/*   3:    */ 
/*   4:    */ public class RollingDie
/*   5:    */   extends Die
/*   6:    */ {
/*   7:    */   private static final double slowdown = 0.97D;
/*   8:    */   private static final double speedFactor = 0.04D;
/*   9:    */   private static final double speedLimit = 2.0D;
/*  10:    */   private static int tableLeft;
/*  11:    */   private static int tableRight;
/*  12:    */   private static int tableTop;
/*  13:    */   private static int tableBottom;
/*  14: 14 */   private final int dieSize = 24;
/*  15:    */   private int xCenter;
/*  16:    */   private int yCenter;
/*  17:    */   private double xSpeed;
/*  18:    */   private double ySpeed;
/*  19:    */   
/*  20:    */   public static void setBounds(int left, int right, int top, int bottom)
/*  21:    */   {
/*  22: 21 */     tableLeft = left;
/*  23: 22 */     tableRight = right;
/*  24: 23 */     tableTop = top;
/*  25: 24 */     tableBottom = bottom;
/*  26:    */   }
/*  27:    */   
/*  28:    */   public RollingDie()
/*  29:    */   {
/*  30: 30 */     this.xCenter = -1;
/*  31: 31 */     this.yCenter = -1;
/*  32:    */   }
/*  33:    */   
/*  34:    */   public void roll()
/*  35:    */   {
/*  36: 37 */     super.roll();
/*  37: 38 */     int width = tableRight - tableLeft;
/*  38: 39 */     int height = tableBottom - tableTop;
/*  39: 40 */     this.xCenter = tableLeft;
/*  40: 41 */     this.yCenter = (tableTop + height / 2);
/*  41: 42 */     this.xSpeed = (width * (Math.random() + 1.0D) * 0.04D);
/*  42: 43 */     this.ySpeed = (height * (Math.random() - 0.5D) * 2.0D * 0.04D);
/*  43:    */   }
/*  44:    */   
/*  45:    */   public boolean isRolling()
/*  46:    */   {
/*  47: 50 */     return (this.xSpeed > 2.0D) || (this.xSpeed < -2.0D) || 
/*  48: 51 */       (this.ySpeed > 2.0D) || (this.ySpeed < -2.0D);
/*  49:    */   }
/*  50:    */   
/*  51:    */   public void avoidCollision(RollingDie other)
/*  52:    */   {
/*  53: 58 */     if (other == this) {
/*  54: 59 */       return;
/*  55:    */     }
/*  56: 61 */     while ((Math.abs(this.xCenter - other.xCenter) < 24) && (
/*  57: 62 */       Math.abs(this.yCenter - other.yCenter) < 24)) {
/*  58: 63 */       move();
/*  59:    */     }
/*  60:    */   }
/*  61:    */   
/*  62:    */   private void move()
/*  63:    */   {
/*  64: 70 */     this.xCenter = ((int)(this.xCenter + this.xSpeed));
/*  65: 71 */     this.yCenter = ((int)(this.yCenter + this.ySpeed));
/*  66:    */     
/*  67: 73 */     int radius = 12;
/*  68: 75 */     if (this.xCenter < tableLeft + radius)
/*  69:    */     {
/*  70: 77 */       this.xCenter = (tableLeft + radius);
/*  71: 78 */       this.xSpeed = (-this.xSpeed);
/*  72:    */     }
/*  73: 81 */     if (this.xCenter > tableRight - radius)
/*  74:    */     {
/*  75: 83 */       this.xCenter = (tableRight - radius);
/*  76: 84 */       this.xSpeed = (-this.xSpeed);
/*  77:    */     }
/*  78: 87 */     if (this.yCenter < tableTop + radius)
/*  79:    */     {
/*  80: 89 */       this.yCenter = (tableTop + radius);
/*  81: 90 */       this.ySpeed = (-this.ySpeed);
/*  82:    */     }
/*  83: 93 */     if (this.yCenter > tableBottom - radius)
/*  84:    */     {
/*  85: 95 */       this.yCenter = (tableBottom - radius);
/*  86: 96 */       this.ySpeed = (-this.ySpeed);
/*  87:    */     }
/*  88:    */   }
/*  89:    */   
/*  90:    */   public void draw(Graphics g)
/*  91:    */   {
/*  92:104 */     if ((this.xCenter < 0) || (this.yCenter < 0)) {
/*  93:105 */       return;
/*  94:    */     }
/*  95:106 */     if (isRolling())
/*  96:    */     {
/*  97:108 */       move();
/*  98:109 */       drawRolling(g);
/*  99:110 */       this.xSpeed *= 0.97D;
/* 100:111 */       this.ySpeed *= 0.97D;
/* 101:    */     }
/* 102:    */     else
/* 103:    */     {
/* 104:115 */       drawStopped(g);
/* 105:    */     }
/* 106:    */   }
/* 107:    */   
/* 108:    */   private void drawRolling(Graphics g)
/* 109:    */   {
/* 110:122 */     int x = this.xCenter - 12 + (int)(3.0D * Math.random()) - 1;
/* 111:123 */     int y = this.yCenter - 12 + (int)(3.0D * Math.random()) - 1;
/* 112:124 */     g.setColor(Color.RED);
/* 113:126 */     if (x % 2 != 0) {
/* 114:127 */       g.fillRoundRect(x, y, 24, 24, 6, 6);
/* 115:    */     } else {
/* 116:129 */       g.fillOval(x - 2, y - 2, 28, 28);
/* 117:    */     }
/* 118:131 */     Die die = new Die();
/* 119:132 */     die.roll();
/* 120:133 */     drawDots(g, x, y, die.getNumDots());
/* 121:    */   }
/* 122:    */   
/* 123:    */   private void drawStopped(Graphics g)
/* 124:    */   {
/* 125:139 */     int x = this.xCenter - 12;
/* 126:140 */     int y = this.yCenter - 12;
/* 127:141 */     g.setColor(Color.RED);
/* 128:142 */     g.fillRoundRect(x, y, 24, 24, 6, 6);
/* 129:143 */     drawDots(g, x, y, getNumDots());
/* 130:    */   }
/* 131:    */   
/* 132:    */   private void drawDots(Graphics g, int x, int y, int numDots)
/* 133:    */   {
/* 134:149 */     g.setColor(Color.WHITE);
/* 135:    */     
/* 136:151 */     int dotSize = 6;
/* 137:152 */     int step = 3;
/* 138:153 */     int x1 = x + step - 1;
/* 139:154 */     int x2 = x + 3 * step;
/* 140:155 */     int x3 = x + 5 * step + 1;
/* 141:156 */     int y1 = y + step - 1;
/* 142:157 */     int y2 = y + 3 * step;
/* 143:158 */     int y3 = y + 5 * step + 1;
/* 144:160 */     switch (numDots)
/* 145:    */     {
/* 146:    */     case 1: 
/* 147:163 */       g.fillOval(x2, y2, dotSize, dotSize);
/* 148:164 */       break;
/* 149:    */     case 2: 
/* 150:167 */       g.fillOval(x1, y1, dotSize, dotSize);
/* 151:168 */       g.fillOval(x3, y3, dotSize, dotSize);
/* 152:169 */       break;
/* 153:    */     case 3: 
/* 154:172 */       g.fillOval(x1, y1, dotSize, dotSize);
/* 155:173 */       g.fillOval(x2, y2, dotSize, dotSize);
/* 156:174 */       g.fillOval(x3, y3, dotSize, dotSize);
/* 157:175 */       break;
/* 158:    */     case 4: 
/* 159:178 */       g.fillOval(x1, y1, dotSize, dotSize);
/* 160:179 */       g.fillOval(x3, y1, dotSize, dotSize);
/* 161:180 */       g.fillOval(x1, y3, dotSize, dotSize);
/* 162:181 */       g.fillOval(x3, y3, dotSize, dotSize);
/* 163:182 */       break;
/* 164:    */     case 5: 
/* 165:185 */       g.fillOval(x1, y1, dotSize, dotSize);
/* 166:186 */       g.fillOval(x3, y1, dotSize, dotSize);
/* 167:187 */       g.fillOval(x2, y2, dotSize, dotSize);
/* 168:188 */       g.fillOval(x1, y3, dotSize, dotSize);
/* 169:189 */       g.fillOval(x3, y3, dotSize, dotSize);
/* 170:190 */       g.fillOval(x2, y2, dotSize, dotSize);
/* 171:191 */       break;
/* 172:    */     case 6: 
/* 173:194 */       g.fillOval(x1, y1, dotSize, dotSize);
/* 174:195 */       g.fillOval(x1, y2, dotSize, dotSize);
/* 175:196 */       g.fillOval(x1, y3, dotSize, dotSize);
/* 176:197 */       g.fillOval(x3, y1, dotSize, dotSize);
/* 177:198 */       g.fillOval(x3, y2, dotSize, dotSize);
/* 178:199 */       g.fillOval(x3, y3, dotSize, dotSize);
/* 179:    */     }
/* 180:    */   }
/* 181:    */ }



/* Location:           O:\APCS\StudentFiles\Ch07\Craps\Craps.jar

 * Qualified Name:     RollingDie

 * JD-Core Version:    0.7.0.1

 */
