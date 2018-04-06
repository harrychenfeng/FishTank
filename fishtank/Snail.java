package fishtank;

/**
 * Snail.
 */
public class Snail extends Fish {

  /**
   * Constructs a new snail.
   */
  public Snail() {
    appearance = "~@";
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
    if (Math.random() < 0.1) {
      turnAround();
    }

  }


  /**
   * Build and initialize this snail's forward and backward appearances.
   */
  public String reverseAppearance() {
    if (appearance == "@~") {
      appearance = "~@";
    } else if (appearance == "~@") {
      appearance = "@~";
    }
    return appearance;
  }

  /**
   * A snail meet and eat the seaweed.
   * 
   * @param weed the seaweed which will be eat by the snail.
   */
  public void eatSeaweed(Seaweed weed) {
    if (row == weed.row) {
      FishTank.fishList.remove(weed);
    }
  }
}
