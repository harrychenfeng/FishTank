package fishtank;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Seaweed.
 */
public class Seaweed extends UnderWaterThing {

  /** The number of weed segments. */
  protected int numSegments;

  /** Indicates whether the bottom segment is leaning right. */
  protected boolean leanRight;


  /**
   * Constructs a new seaweed item, given a specific number of weed segments.
   *
   * @param tall the number of segments this seaweed is tall.
   */
  public Seaweed(int tall) {
    this.numSegments = tall;
    colour = Color.green.darker().darker();
    FishTank.fishList.add(this);
  }


  /**
   * Draws this fish tank item.
   *
   * @param graphics the graphics context in which to draw this item.
   */
  public void draw(Graphics graphics) {

    for (int i = 0; i < numSegments; i++) { // Draw a "/" seaweed segment: even numbered and leaning
      // to the right.
      if ((i % 2 == 0) == true) {
        if (leanRight) {
          drawString(graphics, "/", row, (-i + col));
        } else {
          drawString(graphics, "\\", row, (-i + col));
        }
      }

      if ((i % 2 == 1) == true) {
        if (leanRight) {
          drawString(graphics, "\\", row, (-i + col));
        }
      }
    }
  }


  /**
   * Causes this item to take its turn in the fish-tank simulation.
   */
  public void move() {
    leanRight = !leanRight;
  }

}
