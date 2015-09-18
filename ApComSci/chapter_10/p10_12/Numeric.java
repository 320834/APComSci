package p10_12;

/**
   A class for useful numeric methods.
*/
public class Numeric
{  
   /**
      Tests whether two floating-point numbers are.
      equal, except for a roundoff error
      @param x a floating-point number
      @param y a floating-point number
      @return true if x and y are approximately equal
   */
   public static boolean approxEqual(double x, double y)
   {  
      final double EPSILON = 1E-12;
      return Math.abs(x - y) <= EPSILON;
   }
}
