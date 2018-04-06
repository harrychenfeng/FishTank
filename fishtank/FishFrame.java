package fishtank;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 * Displays the fish tank.
 */
public class FishFrame extends JFrame {

  /** My Serializable id. */
  private static final long serialVersionUID = 1409191926708912242L;

  /**
   * Paints this fish tank.
   *
   * @param graphics the graphics context to use for painting.
   */
  public void paint(Graphics graphics) {

    // Get my width and height.
    int width = getBounds().width;
    int height = getBounds().height;

    // Paint the window white.
    graphics.setColor(Color.white);
    graphics.fillRect(0, 0, width, height);

    // Tell all the fishtank items to draw themselves.
    for (int i = 0; i < FishTank.fishList.size(); i++) {
      UnderWaterThing fish = FishTank.fishList.get(i);
      fish.draw(graphics);
    }
  }
}
