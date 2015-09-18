package p11_1;

import java.util.Random;

/**
   This class models a die that, when cast, lands on a random
   face.
*/
public class Die implements Measurable
{
   /**
      Constructs a die with a given number of sides.
      @param s the number of sides, e.g. 6 for a normal die
   */
   public Die(int s)
   {
      sides = s;
      generator = new Random();
   }

   /**
      Simulates a throw of the die
      @return the face of the die 
   */
   public int cast()
   {
	  value = 1 + generator.nextInt(sides);
	  return value;
   }
   
   public double getMeasure(){
	   return value;
   }
   private Random generator;
   private int sides, value = 0;
}
