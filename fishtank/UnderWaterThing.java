package fishtank;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

/**
 * UnderWater things.
 */
public abstract class UnderWaterThing {

  /** The font used to draw instances of this class. */
  protected static Font FONT = new Font("Monospaced", Font.PLAIN, 10);
  /** This UnderWaterThing's first coordinate. */
  protected int row;
  /** This UnderWaterThing's second coordinate. */
  protected int col;
  /** The color of this UnderWaterThing. */
  protected Color colour;


  /**
   * UnderWater thing move in different ways.
   */
  public abstract void move();

  /**
   * Draws this fish tank item.
   * 
   * @param graphics the graphics context in which to draw this item.
   */
  public abstract void draw(Graphics graphics);

  /**
   * Set this item's location.
   * 
   * @param rowCoor the first coordinate.
   * @param colCoor the second coordinate.
   */
  public void setLocation(int rowCoor, int colCoor) {
    row = rowCoor;
    col = colCoor;
  }

  /**
   * Draws the given string in the given graphics context at at the given cursor location.
   *
   * @param graphics the graphics context in which to draw the string.
   * @param str the string to draw.
   * @param rowCoor the x-coordinate of the string's cursor location.
   * @param colCoor the y-coordinate of the string's cursor location.
   */
  public void drawString(Graphics graphics, String str, int rowCoor, int colCoor) {
    graphics.setColor(colour);
    graphics.setFont(FONT);
    FontMetrics fm = graphics.getFontMetrics(FONT);
    graphics.drawString(str, rowCoor * fm.charWidth('W'), colCoor * fm.getAscent());
  }

}
