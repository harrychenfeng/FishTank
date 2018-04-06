package fishtank;

import java.awt.Color;
import java.awt.Graphics;

/**
 * A bubble.
 */
public class Bubble extends UnderWaterThing {

  /** How this bubble appears on the screen. */
  protected String appearance;


  /**
   * Constructs a new bubble.
   *
   */
  public Bubble() {
    colour = Color.gray.darker().darker().darker();
    // start off with . as the appearance
    appearance = ".";
    FishTank.fishList.add(this);
  }


  /**
   * Draws this fish tank item.
   *
   * @param graphics the graphics context in which to draw this item.
   */
  public void draw(Graphics graphics) {
    drawString(graphics, appearance, col, row);
  }


  /**
   * Causes this item to take its turn in the fish-tank simulation whether float straight up, left
   * up or right up.
   */
  public void move() {

    if (Math.random() < 0.33) { // straight up
      if (row > 0) { // continue floating up
        row--;
      } else if (row <= 0) {
        FishTank.fishList.remove(this);
      }

    } else if (Math.random() < 0.66) { // right up
      if (row > 0) { // continue floating up and move right
        row--;
        col += 1;
      } else if (row <= 0) {
        FishTank.fishList.remove(this);
      }

    } else { // left up
      if (row > 0) { // continue floating up and move left
        row--;
        col -= 1;
      } else if (row <= 0) {
        FishTank.fishList.remove(this);
      }

    }
    // Occasionally change a . to a o or a o to a O
    if (Math.random() < 0.05) {
      if (appearance.equals(".")) {
        appearance = "o";
      } else if (appearance.equals("o")) {
        appearance = "O";
      }
    }
  }

}
