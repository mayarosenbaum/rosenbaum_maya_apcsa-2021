import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }

  public void negate() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(255 - pixelObj.getBlue());
        pixelObj.setRed(255 - pixelObj.getRed());
        pixelObj.setGreen(255 - pixelObj.getGreen());
      }
    }
  }

  public void grayscale() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        int avg = (pixelObj.getBlue() + pixelObj.getRed() + pixelObj.getGreen())/3;
        pixelObj.setBlue(avg);
        pixelObj.setRed(avg);
        pixelObj.setGreen(avg);
      }
    }
  }

  public void fixUnderwater() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        int temp = pixelObj.getRed() * 3;
        pixelObj.setRed(temp);
      }
    }
  }

  public void grayscaleAverage() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        int avg = (pixelObj.getBlue() + pixelObj.getRed() + pixelObj.getGreen())/3;
        pixelObj.setBlue(avg);
        pixelObj.setRed(avg);
        pixelObj.setGreen(avg);
      }
    }
  }

  public void grayscaleLightness() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        int avg = (Math.max(Math.max(pixelObj.getBlue(), pixelObj.getRed()), pixelObj.getGreen()) + Math.min(Math.min(pixelObj.getBlue(), pixelObj.getRed()), pixelObj.getGreen()))/2;
        pixelObj.setBlue(avg);
        pixelObj.setRed(avg);
        pixelObj.setGreen(avg);
      }
    }
  }

  public void grayscaleLuminosoty() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        int avg = ((int)(pixelObj.getBlue()*0.07) + (int)(pixelObj.getRed()*0.21) + (int)(pixelObj.getGreen()*0.72))/3;
        pixelObj.setBlue(avg);
        pixelObj.setRed(avg);
        pixelObj.setGreen(avg);
      }
    }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }

  public void mirrorVerticalRightToLeft() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = width/2; col < pixels[0].length; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }

  public void mirrorHorizontal() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int col = 0; col < width; col++) {
      for (int row = 0; row < pixels.length/2; row++) {
        leftPixel = pixels[row][col];
        rightPixel = pixels[pixels.length - 1 - row][col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }

  public void mirrorHorizontalBotToTop() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int col = 0; col < width; col++) {
      for (int row = 0; row < pixels.length/2; row++) {
        leftPixel = pixels[row][col];
        rightPixel = pixels[pixels.length - 1 - row][col];
        leftPixel.setColor(rightPixel.getColor());
      }
    } 
  }

  public void mirrorDiagonal() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int min = Math.min(pixels.length, pixels[0].length);
    for (int col = 0; col < min; col++) {
      for (int row = 0; row < min; row++) {
        leftPixel = pixels[row][col];
        rightPixel = pixels[col][row];
        if (col >= row) {
          leftPixel.setColor(rightPixel.getColor());
        }
      }
    } 
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple() {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    // 27, 97 and 13, mirrorPoint
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  public void mirrorArms() {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    
    for (int row = 157; row < 193; row++) {
      for (int col = 100; col < 171; col++) {
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row + 78][col - 7];
        rightPixel.setColor(leftPixel.getColor());
      }
    }

    for (int row = 171; row < 197; row++) {
      for (int col = 239; col < 295; col++) {
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row + 78][col + 6];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }

  public void mirrorGull() {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    
    for (int row = 233; row < 323; row++) {
      for (int col = 234; col < 347; col++) {
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row + 14][col + 130];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }

  public void mirrorRectangle(int x1, int y1, int x2, int y2, boolean vertical) {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int length = x2 - x1 + 1;
    int width = y2 - y1 + 1;
    Pixel[][] pixels = this.getPixels2D();
    
    for (int row = y1; row < y2+1; row++) {
      for (int col = x1; col < x2+1; col++) {
        leftPixel = pixels[row][col];
        if (vertical) {
          rightPixel = pixels[row][2 * x2 + 1 - col];
        } else { 
          rightPixel = pixels[2 * y2 + 1 - row][col];
        }
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }

  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, int startRow, int startCol) {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; fromRow < fromPixels.length && toRow < toPixels.length; fromRow++, toRow++) {
      for (int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length && toCol < toPixels[0].length; fromCol++, toCol++) {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  public void copyGeneral(Picture fromPic, int startRow, int startCol, int endRow, int endCol) {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; fromRow < fromPixels.length && toRow < toPixels.length && toRow < endRow; fromRow++, toRow++) {
      for (int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length && toCol < toPixels[0].length; fromCol++, toCol++) {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }

  public void createMyCollage() {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,0,0);
    Picture flowerNegate = new Picture(flower2);
    flowerNegate.negate();
    this.copy(flowerNegate,0,100);
    Picture flowerGray = new Picture(flower2);
    flowerGray.grayscale();
    flowerGray.mirrorHorizontal();
    this.copy(flowerGray,200,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist) {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }

  public void edgeDetection2(int edgeDist) {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length - 1; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row+1][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }

  public void chromakey(Picture fromPic) {
    Pixel origPixel = null;
    Pixel newPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    Color newColor = null;
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        origPixel = pixels[row][col];
        newPixel = fromPixels[row][col];
        newColor = newPixel.getColor();
        if (origPixel.getBlue() > origPixel.getRed()) {
          origPixel.setColor(newColor);
        }
      }
    }
  }

  public void drawRectangle(int x, int y, int w, int h, Color c) {
    Pixel origPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    for (int col = x; col < x + w; col++) {
      origPixel = pixels[y][col];
      origPixel.setColor(c);
      origPixel = pixels[y+h][col];
      origPixel.setColor(c);
    }
    for (int row = y; row < y + h; row++) {
      origPixel = pixels[row][x];
      origPixel.setColor(c);
      origPixel = pixels[row][x+w];
      origPixel.setColor(c);
    }
  }
  
  public void blur(int x, int y, int w, int h) {
		Color newColor = null;
		int r = 0;
		int b = 0;
		int g = 0;
		Pixel[][] pixels = this.getPixels2D();
		for (int row = y; row < y + h; row++) {
			for (int col = x; col < x + w; col++) {
				r = 0;
				b = 0;
				g = 0;
				for (int i = y - 1; i <= y + 1; y++) {
					for (int j = x - 1; j <= x + 1; j++) {
						if (i >= 0 && j >= 0 && pixels[i][j] != null) {
							r += pixels[i][j].getRed();
							b += pixels[i][j].getBlue();
							g += pixels[i][j].getGreen();
						}
					}
				}
				newColor = new Color(r/9, b/9, g/9);
				pixels[y][x].setColor(newColor);
			}
		}
  }


	  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
