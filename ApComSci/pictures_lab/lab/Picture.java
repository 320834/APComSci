package lab;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture. This class inherits from SimplePicture and
 * allows the student to add functionality to the Picture class.
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
@SuppressWarnings("unused")
public class Picture extends SimplePicture {
	// /////////////////// constructors //////////////////////////////////

	/**
	 * Constructor that takes no arguments
	 */
	public Picture() {
		/*
		 * not needed but use it to show students the implicit call to super()
		 * child constructors always call a parent constructor
		 */
		super();
	}

	/**
	 * Constructor that takes a file name and creates the picture
	 * 
	 * @param fileName
	 *            the name of the file to create the picture from
	 */
	public Picture(String fileName) {
		// let the parent class handle this fileName
		super(fileName);
	}

	/**
	 * Constructor that takes the width and height
	 * 
	 * @param height
	 *            the height of the desired picture
	 * @param width
	 *            the width of the desired picture
	 */
	public Picture(int height, int width) {
		// let the parent class handle this width and height
		super(width, height);
	}

	/**
	 * Constructor that takes a picture and creates a copy of that picture
	 * 
	 * @param copyPicture
	 *            the picture to copy
	 */
	public Picture(Picture copyPicture) {
		// let the parent class do the copy
		super(copyPicture);
	}

	/**
	 * Constructor that takes a buffered image
	 * 
	 * @param image
	 *            the buffered image to use
	 */
	public Picture(BufferedImage image) {
		super(image);
	}

	// //////////////////// methods ///////////////////////////////////////

	/**
	 * Method to return a string with information about this picture.
	 * 
	 * @return a string with information about the picture such as fileName,
	 *         height and width.
	 */
	public String toString() {
		String output = "Picture, filename " + getFileName() + " height "
				+ getHeight() + " width " + getWidth();
		return output;

	}

	private void evenIt() {
		Pixel[][] pixels = getPixels2D();

		for (int r = 0; r < pixels.length; r++) {
			for (int c = 0; c < pixels[0].length; c++)
				if (pixels[r][c].getRed() % 2 != 0)
					pixels[r][c].setRed(pixels[r][c].getRed() - 1);
		}
	}

	public void encode(Picture secret) {
		evenIt();
		Pixel[][] pixels = this.getPixels2D();
		Pixel[][] secretPixels = secret.getPixels2D();

		for (int r = 0; r < Math.min(pixels.length, secretPixels.length); r++) {
			for (int c = 0; c < Math.min(pixels[0].length,
				secretPixels[0].length); c++) {
				Pixel realPixelObj = pixels[r][c];
				Pixel messageObj = secretPixels[r][c];

				if (messageObj.getRed() > 200 && messageObj.getGreen() > 200
						&& messageObj.getBlue() > 200) {
					if (realPixelObj.getRed() % 2 == 0)
						realPixelObj.setRed(realPixelObj.getRed() - 1);
				}
			}
		}
	}

	public void decode() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				if (pixelObj.getRed() % 2 == 0) {
					pixelObj.setRed(0);
					pixelObj.setBlue(0);
					pixelObj.setGreen(0);
				} else {
					pixelObj.setRed(255);
					pixelObj.setBlue(255);
					pixelObj.setGreen(255);
				}
			}
		}
	}

	public void chromakey(Picture background, Color colour) {
		Pixel[][] pixels = this.getPixels2D();
		Pixel[][] bgPixels = background.getPixels2D();

		for (int r = 0; r < Math.min(pixels.length, bgPixels.length); r++) {
			for (int c = 0; c < Math.min(pixels[0].length, bgPixels[0].length); c++) {
				Pixel pix = pixels[r][c];
				Pixel bgpix = bgPixels[r][c];
				int redDifference = Math.abs(pix.getRed() - colour.getRed());
				int blueDifference = Math.abs(pix.getBlue() - colour.getBlue());
				int greenDifference = Math.abs(pix.getGreen()
						- colour.getGreen());

				if (redDifference < 40 && blueDifference < 40
						&& greenDifference < 40)
					pix.setColor(bgpix.getColor());
			}
		}
	}

	public void averagizer() {
		Pixel[][] pixels = this.getPixels2D();
		for (int row = 0; row < pixels.length - 10; row++) {
			for (int col = 0; col < pixels[0].length - 10; col++) {
				int redAvg = 0, blueAvg = 0, greenAvg = 0;
				for (int j = row; j < row + 10; j++) {
					for (int i = col; i < col + 10; i++) {
						redAvg += pixels[j][i].getRed();
						blueAvg += pixels[j][i].getBlue();
						greenAvg += pixels[j][i].getGreen();
					}
				}
				redAvg /= 100;
				blueAvg /= 100;
				greenAvg /= 100;
				Color set = new Color(redAvg, greenAvg, blueAvg);
				pixels[row][col].setColor(set);
			}
		}
		mirrorVertical();
		mirrorHorizontal();
	}

	/** Method to set the blue to 0 */
	public void zeroBlue() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setBlue(0);
			}
		}
	}

	public void keepOnlyBlue() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setRed(0);
				pixelObj.setGreen(0);
			}
		}
	}

	public void keepOnlyGreen() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setRed(0);
				pixelObj.setBlue(0);
			}
		}
	}

	public void keepOnlyRed() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setBlue(0);
				pixelObj.setGreen(0);
			}
		}
	}

	public void grayscale() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				int avg = (pixelObj.getRed() + pixelObj.getBlue() + pixelObj
						.getGreen()) / 3;
				pixelObj.setBlue(avg);
				pixelObj.setGreen(avg);
				pixelObj.setRed(avg);
			}
		}
	}

	public void fixUnderwater() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				if (pixelObj.getBlue() > 160 && pixelObj.getRed() < 30
						&& pixelObj.getGreen() > 150) {
					pixelObj.setBlue(pixelObj.getBlue() + 50);
				} else {
					pixelObj.setGreen(0);
					pixelObj.setBlue(0);
					pixelObj.setRed(0);
				}
			}
		}
	}

	public void negate() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setRed(255 - pixelObj.getRed());
				pixelObj.setGreen(255 - pixelObj.getGreen());
				pixelObj.setBlue(255 - pixelObj.getBlue());
			}
		}
	}

	/**
	 * Method that mirrors the picture around a vertical mirror in the center of
	 * the picture from left to right
	 */
	public void mirrorVertical() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < width / 2; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	public void mirrorHorizontal() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel topPixel = null;
		Pixel botPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length / 2; row++) {
			for (int col = 0; col < width; col++) {
				topPixel = pixels[row][col];
				botPixel = pixels[pixels.length - 1 - row][col];
				botPixel.setColor(topPixel.getColor());
			}
		}
	}

	public void mirrorHorizontalBotToTop() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel botPixel = null;
		Pixel topPixel = null;
		int width = pixels[0].length;
		for (int row = pixels.length / 2; row < pixels.length; row++) {
			for (int col = 0; col < width; col++) {
				botPixel = pixels[row][col];
				topPixel = pixels[pixels.length - 1 - row][col];
				topPixel.setColor(botPixel.getColor());
			}
		}
	}

	public void mirrorVerticalRightToLeft() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = width / 2; col < width; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	/** Mirror just part of a picture of a temple */
	public void mirrorTemple() {
		int mirrorPoint = 276, count = 0;
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel[][] pixels = this.getPixels2D();

		// loop through the rows
		for (int row = 27; row < 97; row++) {
			// loop from 13 to just before the mirror point
			for (int col = 13; col < mirrorPoint; col++) {

				leftPixel = pixels[row][col];
				rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
				rightPixel.setColor(leftPixel.getColor());
				count++;
			}
		}
		System.out.println(count);
	}

	public void mirrorArms() {
		int mirrorPoint = 195, count = 0;
		Pixel topPixel = null;
		Pixel botPixel = null;
		Pixel[][] pixels = this.getPixels2D();

		// loop through the rows
		for (int row = 162; row < mirrorPoint; row++) {
			// loop from 13 to just before the mirror point
			for (int col = 100; col < 293; col++) {

				topPixel = pixels[row][col];
				botPixel = pixels[mirrorPoint - row + mirrorPoint][col];
				botPixel.setColor(topPixel.getColor());
				count++;
			}
		}
		System.out.println(count);
	}

	public void mirrorGull() {
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel[][] pixels = this.getPixels2D();

		// loop through the rows
		for (int row = 234; row < 320; row++) {
			// loop from 13 to just before the mirror point
			for (int col = 235; col < 345; col++) {

				leftPixel = pixels[row][col];
				rightPixel = pixels[row][455 - (345 - col)];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	/**
	 * copy from the passed fromPic to the specified startRow and startCol in
	 * the current picture
	 * 
	 * @param fromPic
	 *            the picture to copy from
	 * @param startRow
	 *            the start row to copy to
	 * @param startCol
	 *            the start col to copy to
	 */
	public void copy(Picture fromPic, int startRow, int startCol) {
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = 0, toRow = startRow; fromRow < fromPixels.length
				&& toRow < toPixels.length; fromRow++, toRow++) {
			for (int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length
					&& toCol < toPixels[0].length; fromCol++, toCol++) {
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol];
				toPixel.setColor(fromPixel.getColor());
			}
		}
	}

	public void copy(Picture fromPic, int startRow, int startCol,
			int fromStartRow, int fromEndRow, int fromStartCol, int fromEndCol) {
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = fromStartRow, toRow = startRow; fromRow < fromEndRow
				&& toRow < toPixels.length; fromRow++, toRow++) {
			for (int fromCol = fromStartCol, toCol = startCol; fromCol < fromEndCol
					&& toCol < toPixels[0].length; fromCol++, toCol++) {
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol];
				toPixel.setColor(fromPixel.getColor());
			}
		}
	}

	/** Method to create a collage of several pictures */
	public void createCollage() {
		Picture flower1 = new Picture("flower1.jpg");
		Picture flower2 = new Picture("flower2.jpg");
		this.copy(flower1, 0, 0);
		this.copy(flower2, 100, 0);
		this.copy(flower1, 200, 0);
		Picture flowerNoBlue = new Picture(flower2);
		flowerNoBlue.zeroBlue();
		this.copy(flowerNoBlue, 300, 0);
		this.copy(flower1, 400, 0);
		this.copy(flower2, 500, 0);
		this.mirrorVertical();
		this.write("collage.jpg");
	}

	public Picture myCollage() {
		Picture cat = new Picture("caterpillar.jpg");
		Picture cat2 = new Picture("caterpillar.jpg");
		cat.negate();
		cat2.keepOnlyRed();
		this.copy(cat, 0, 0);
		this.copy(cat2, 100, 0);
		this.copy(cat, 200, 0);
		this.mirrorVertical();
		this.write("collage.jpg");
		return new Picture("collage.jpg");
	}

	/**
	 * Method to show large changes in color
	 * 
	 * @param edgeDist
	 *            the distance for finding edges
	 */
	public void edgeDetection(int edgeDist) {
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel topPixel = null;
		Pixel botPixel = null;
		Pixel[][] pixels = this.getPixels2D();
		Color rightColor = null, botColor = null;
		for (int row = 0; row < pixels.length - 1; row++) {
			for (int col = 0; col < pixels[0].length - 1; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][col + 1];
				rightColor = rightPixel.getColor();
				topPixel = pixels[row][col];
				botPixel = pixels[row + 1][col];
				botColor = botPixel.getColor();
				if (leftPixel.colorDistance(rightColor) > edgeDist
						|| topPixel.colorDistance(botColor) > edgeDist)
					leftPixel.setColor(Color.BLACK);
				else
					leftPixel.setColor(Color.WHITE);
			}
		}
	}

	/*
	 * Main method for testing - each class in Java can have a main method
	 */
	public static void main(String[] args) {
		Picture beach = new Picture("beach.jpg");
		beach.explore();
		beach.zeroBlue();
		beach.explore();
	}

} // this } is the end of class Picture, put all new methods before this
