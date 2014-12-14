/**
* HowBig tests the largest integer that can be stored in an int.
*
* @author Chris Thiel
* @version 1.0
*/
public class HowBig
{

 /**
  * powerOfTwo returns a power of 2
  *
  * @param  x   the exponent of 2
  * @return     2^(x)
  */
static int i = 7;  //put input here
static int x = i;  //puts input into x
	
public static int powerOfTwo(int x)
{
   if (x==0) return 1;
   return 2*powerOfTwo(x-1);
}

public static void main(String[] args)
{
	 System.out.println( "2^" + i + "- 1" + " = " + powerOfTwo(x));       
	//System.out.println( "2^" + x + " =" + powerOfTwo(x)); 
}
}
