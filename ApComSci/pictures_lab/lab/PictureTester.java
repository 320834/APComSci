package lab;

import java.awt.Color;

/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  public static void testCopy()
  {
	    Picture beach = new Picture("beach.jpg"), cat = new Picture("caterpillar.jpg");
	    beach.explore();
	    beach.copy(cat, 5, 5);
	    beach.explore();
  }

  public static void testCopyOverload()
  {
	    Picture beach = new Picture("beach.jpg"), cat = new Picture("caterpillar.jpg");
	    beach.explore();
	    cat.negate();
	    cat.mirrorHorizontal();
	    beach.copy(cat, 50, 50, 10, 50, 20, 329);
	    beach.explore();
  }

  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  public static void testMirrorVerticalRightToLeft()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVerticalRightToLeft();
    caterpillar.explore();
  }
  
  public static void testMirrorHorizontal()
  {
    Picture caterpillar = new Picture("redMotorcycle.jpg");
    caterpillar.explore();
    caterpillar.mirrorHorizontal();
    caterpillar.explore();
  }

  public static void testMirrorHorizontalBotToTop()
  {
    Picture caterpillar = new Picture("redMotorcycle.jpg");
    caterpillar.explore();
    caterpillar.mirrorHorizontalBotToTop();
    caterpillar.explore();
  }

  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  public static void testMirrorGull()
  {
    Picture temple = new Picture("seagull.jpg");
    temple.explore();
    temple.mirrorGull();
    temple.explore();
  }

  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  public static void testKeepOnlyBlue(){
	    Picture beach = new Picture("beach.jpg");
	    beach.explore();
	    beach.keepOnlyBlue();
	    beach.explore();
  }
  
  public static void testKeepOnlyRed(){
	    Picture beach = new Picture("beach.jpg");
	    beach.explore();
	    beach.keepOnlyRed();
	    beach.explore();
  }
  
  public static void testKeepOnlyGreen(){
	    Picture beach = new Picture("beach.jpg");
	    beach.explore();
	    beach.keepOnlyGreen();
	    beach.explore();
  }
  
  public static void testNegate(){
	    Picture beach = new Picture("beach.jpg");
	    beach.explore();
	    beach.negate();
	    beach.explore();
  }
  
  public static void testGrayscale(){
	    Picture beach = new Picture("beach.jpg");
	    beach.explore();
	    beach.grayscale();
	    beach.explore();
  }
  
  public static void testFixUnderwater(){
	    Picture beach = new Picture("water.jpg");
	    beach.explore();
	    beach.fixUnderwater();
	    beach.explore();
  }
  
  public static void testMirrorArms(){
	  Picture snow = new Picture("snowman.jpg");
	  snow.explore();
	  snow.mirrorArms();
	  snow.explore();
  }
  
  public static void steganography(){
	  Picture beach = new Picture("beach.jpg");
	  Picture message = new Picture("reflectedlightontext.png");
      beach.explore();
	  beach.encode(message);
	  beach.explore();
	  beach.decode();
	  beach.explore();
  }
  
  public static void steganography2(){
	  Picture cycle = new Picture("backg.jpg");
	  Picture message = new Picture("mum.jpg");
      cycle.explore();
      cycle.encode(message);
      cycle.explore();
      cycle.decode();
      cycle.explore();
  }
  
  public static void chromakey(){
	  Picture front = new Picture("man.jpg");
	  Picture back = new Picture("back.jpg");
	  Color chromakeyColour = new Color(135,247,137);
	  
	  front.explore();
	  back.explore();
	  front.chromakey(back, chromakeyColour);
	  front.explore();
  }
  
  public static void averegizer(){
	  Picture beach = new Picture("beach.jpg");
	  beach.explore();
	  beach.averagizer();
	  beach.explore();
  }
    
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
//    testZeroBlue();
//    testKeepOnlyBlue();
//    testKeepOnlyRed();
//    testKeepOnlyGreen();
//    testNegate();
//    testGrayscale();
//    testFixUnderwater();
//    testMirrorVertical();
//	  testMirrorVerticalRightToLeft();
//	  testMirrorHorizontal();
//	  testMirrorHorizontalBotToTop();
//    testMirrorTemple();
//    testMirrorArms();
//    testMirrorGull();
    //testMirrorDiagonal();
//    testCollage();
//    testCopy();
//	  testCopyOverload();
 //   testEdgeDetection();
    //testEdgeDetection2x	();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
//    testGetAverageForColumn(0);
//	  steganography();
//	  steganography2();
//	  chromakey();
	  averegizer();
  }
}