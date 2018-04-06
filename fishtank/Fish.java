package fishtank;

import java.awt.Color;
import java.awt.Graphics;

/**
 * A fish.
 */
public class Fish extends UnderWaterThing {

  /** How this fish appears on the screen. */
  protected String appearance;

  /** Indicates whether this fish is moving right. */
  protected boolean goingRight;


  /**
   * Constructs a new fish.
   */
  public Fish() {
    colour = Color.cyan.darker().darker().darker();
    appearance = "><>";
    goingRight = true;
    FishTank.fishList.add(this);
  }


  /**
   * Causes this fish to blow a bubble.
   */
  public void blowBubble() {
    Bubble bubble = new Bubble();
    bubble.setLocation(col, row);
  }


  /**
   * Build and initialize this fish's forward and backward appearances.
   */
  public String reverseAppearance() {

    if (appearance == "><>") {
      appearance = "<><";
    } else if (appearance == "<><") {
      appearance = "><>";
    } else if (appearance == "><MEHUNGRY>") {
      appearance = "<YGNUHEM><";
    } else if (appearance == "<YGNUHEM><") {
      appearance = "><MEHUNGRY>";
    }

    return appearance;
  }


  /**
   * Turns this fish around, causing it to reverse direction.
   */
  public void turnAround() {
    goingRight = !goingRight;
    appearance = reverseAppearance();
  }


  /**
   * Draws this fish tank item.
   *
   * @param graphics the graphics context in which to draw this item.
   */
  public void draw(Graphics graphics) {
    drawString(graphics, appearance, row, col);
  }


  /**
   * Causes this item to take its turn in the fish-tank simulation.
   */
  public void move() {

    // Move one spot to the right or left.
    if (goingRight) {
      if (row >= 0 && row < (int) (640 / FishTank.CHAR_WIDTH) - 5) {
        // inside right edge, continue going right
        row += 1;
      } else if (row >= (int) (640 / FishTank.CHAR_WIDTH) - 5) { // force it to move left
        row -= 1;
      } else {
        row += 1;
      }

    } else {
      if (row > 0 && row < (int) (640 / FishTank.CHAR_WIDTH) - 5) {
        // inside left edge, continue going left
        row -= 1;
      } else if (row <= 0) { // force it to move right
        row += 1;
      } else {
        row -= 1;
      }
    }

    // Figure out whether I blow a bubble.
    if (Math.random() < 0.1) {
      blowBubble();
    }

    // Figure out whether I turn around.
    if (Math.random() < 0.1) {
      turnAround();
    }

    // Figure out whether to move up or down, or neither.
    if (Math.random() < 0.1) { // move down
      if (col >= 5 && col < (int) (480 / FishTank.CHAR_HEIGHT)) {
        // above lower bound, continue going up
        col += 1;
      } else if (col >= (int) (480 / FishTank.CHAR_HEIGHT)) { // force it to move up
        col -= 1;
      } else {
        col += 1;
      }

    } else if (Math.random() < 0.2) { // move up
      if (col > 5 && col < (int) (480 / FishTank.CHAR_HEIGHT)) {
        // below upper bound, continue going up
        col -= 1;
      } else if (col <= 5) { // force it to go down
        col += 1;
      } else {
        col -= 1;
      }
    }
  }

}
