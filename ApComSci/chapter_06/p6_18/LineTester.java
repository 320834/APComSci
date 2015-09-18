package p6_18;

import java.awt.geom.Point2D;

public class LineTester
{
	public static void main(String[] args)
	{
		// test with easy input: y = 5x + 6
		Line test1Line1 = new Line(new Point2D.Double(0,6), 5);
		Line test1Line2 = new Line(new Point2D.Double(-10,-44), new Point2D.Double(10,56));
		Line test1Line3 = new Line("y = 5x + 6");
		Line test1Line4 = new Line("y = 5x + 6", false);
		System.out.println("--Start test 1--");
		test(test1Line1, test1Line2, test1Line3, test1Line4);
		System.out.println("-- End test 1 --");
		
		// test with harder input 1: y = -7x + -10
		Line test2Line1 = new Line(new Point2D.Double(0,-10), -7);
		Line test2Line2 = new Line(new Point2D.Double(-10,60), new Point2D.Double(10,-80));
		Line test2Line3 = new Line("y = -7x + -10");
		Line test2Line4 = new Line("y = -7x + -10", false);
		System.out.println("\n--Start test 2--");
		test(test2Line1, test2Line2, test2Line3, test2Line4);
		System.out.println("-- End test 2 --");
		
		// test with harder input 2: y = 5.2x + 3.1
		Line test3Line1 = new Line(new Point2D.Double(0,3.1), 5.2);
		Line test3Line2 = new Line(new Point2D.Double(-10,-48.9), new Point2D.Double(10,55.1));
		Line test3Line3 = new Line("y = 5.2x + 3.1");
		Line test3Line4 = new Line("y = 5.2x + 3.1", false);
		System.out.println("\n--Start test 3--");
		test(test3Line1, test3Line2, test3Line3, test3Line4);
		System.out.println("-- End test 3 --");
		
		// test with vertical inputs: x = 15, x = 15.0, x = -14, x = -14.0
		Line test4Line1 = new Line("x = 15", true);
		Line test4Line2 = new Line("x = 15.0", true);
		Line test4Line3 = new Line("x = -14", true);
		Line test4Line4 = new Line("x = -14.0", true);
		System.out.println("\n--Start test 4--");
		test(test4Line1, test4Line2, test4Line3, test4Line4);
		System.out.println("-- End test 4 --");
		
		// test intersection and parallel detection (with simplest constructor)
		Line parallel1 = new Line(new Point2D.Double(0,6), 5);
		Line parallel2 = new Line(new Point2D.Double(-10,6), 5);
		Line intersecting = new Line(new Point2D.Double(-5,5), -3);
		System.out.println("\n--Start test 5--");
		System.out.println("parallel1.intersects(intersecting): " + parallel1.intersects(intersecting));
		System.out.println("parallel1.intersects(parallel2)   : " + parallel1.intersects(parallel2));
		System.out.println("parallel1.isParallel(parallel2)   : " + parallel1.isParallel(parallel2));
		System.out.println("intersecting.isParallel(parallel1): " + intersecting.isParallel(parallel1));
		System.out.println("-- End test 5 --");
	}
	
	private static void test(Line one, Line two, Line three, Line four)
	{
		System.out.println("one  : " + one);
		System.out.println("two  : " + two);
		System.out.println("three: " + three);
		System.out.println("four : " + four);
		System.out.println("one.equals(two)   : " + one.equals(two));
		System.out.println("two.equals(three) : " + two.equals(three));
		System.out.println("three.equals(four): " + three.equals(four));
	}
}
