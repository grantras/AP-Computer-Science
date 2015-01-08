 public class Vendor
 {
   private static double totalSales = 0.0D;
   private int myStock;
   private int myPrice;
   private int myDeposit;
   private int myChange;
 
   public static double getTotalSales()
   {
     double temp = totalSales;
     totalSales = 0.0D;
     return temp;
   }
   
   public Vendor(int price, int stock)
   {
     this.myPrice = price;
     this.myStock = stock;
     this.myDeposit = 0;
     this.myChange = 0;
   }
   
   public void setStock(int qty)
   {
     this.myStock = qty;
   }
   
   public int getStock()
   {
     return this.myStock;
   }
   
   public void addMoney(int cents)
   {
     if (this.myStock == 0) {
       return;
     }
     this.myDeposit += cents;
   }
   
   public int getDeposit()
   {
     return this.myDeposit;
   }
   
   public boolean makeSale()
   {
     if ((this.myStock == 0) || (this.myDeposit < this.myPrice))
     {
       this.myChange = this.myDeposit;
       this.myDeposit = 0;
       return false;
     }
     this.myStock -= 1;
     this.myChange = (this.myDeposit - this.myPrice);
     this.myDeposit = 0;
     totalSales += 0.01D * this.myPrice;
     return true;
   }
   
   public int getChange()
   {
     int temp = this.myChange;
     this.myChange = 0;
     return temp;
   }
 }
