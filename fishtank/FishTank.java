package fishtank;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 * A fish tank simulation.
 */
public class FishTank {

  /** The width of a character. */
  protected static final int CHAR_WIDTH = 6;
  /** The height of a character. */
  protected static final int CHAR_HEIGHT = 10;
  /** The ArrayList fishList which contains all the fish items created. */
  protected static ArrayList<UnderWaterThing> fishList = new ArrayList<UnderWaterThing>();

  /** The ArrayList addThings which contains all the fish items that are added. */
  protected static ArrayList<UnderWaterThing> addThings = new ArrayList<>();
  /** The ArrayList removeThings which contains all the fish items that are removed. */
  protected static ArrayList<UnderWaterThing> removeThings = new ArrayList<>();

  /**
   * Add removed fish items to removeThing.
   * 
   * @param thing fish items that are removed from fishList.
   */
  public static void removeThing(UnderWaterThing thing) {
    System.out.println("Removing: " + thing);
    removeThings.add(thing);
  }

  /**
   * Add added fish items to addThing.
   * 
   * @param thing fish items that are added to fishList.
   */
  public static void addThing(UnderWaterThing thing) {
    System.out.println("Adding: " + thing);
    addThings.add(thing);
  }


  /**
   * Start the fishies!
   * 
   * @param pars ignored.
   */
  public static void main(String[] pars) {

    // The window in which the fish swim.
    FishFrame fishFrame = new FishFrame();
    fishFrame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent event) {
        System.exit(0);
      }
    });

    UnderWaterThing[][] myLittleFishies =
        new UnderWaterThing[(int) (480 / CHAR_HEIGHT)][(int) (640 / CHAR_WIDTH)];
    myLittleFishies[23][18] = new Fish();
    myLittleFishies[23][18].setLocation(23, 18);
    myLittleFishies[6][12] = new Fish();
    myLittleFishies[6][12].setLocation(6, 12);
    myLittleFishies[17][4] = new Fish();
    myLittleFishies[17][4].setLocation(17, 4);
    myLittleFishies[15][28] = new Fish();
    myLittleFishies[15][28].setLocation(15, 28);
    myLittleFishies[23][18] = new Fish();
    myLittleFishies[23][18].setLocation(15, 36);
    myLittleFishies[16][35] = new Fish();
    myLittleFishies[16][35].setLocation(16, 35);
    myLittleFishies[16][35] = new Fish();
    myLittleFishies[16][35].setLocation(16, 35);
    myLittleFishies[16][22] = new Fish();
    myLittleFishies[16][22].setLocation(16, 18);
    myLittleFishies[23][18] = new Fish();
    myLittleFishies[23][18].setLocation(23, 18);
    myLittleFishies[6][12] = new Fish();
    myLittleFishies[6][12].setLocation(6, 12);
    myLittleFishies[10][20] = new HungryFish();
    myLittleFishies[10][20].setLocation(10, 33);
    myLittleFishies[24][33] = new Seaweed(6);
    myLittleFishies[24][33].setLocation(24, 33);
    myLittleFishies[32][25] = new Seaweed(7);
    myLittleFishies[32][25].setLocation(32, 25);
    myLittleFishies[13][25] = new Seaweed(5);
    myLittleFishies[13][25].setLocation(13, 25);
    // new fish item added to the FishTank
    myLittleFishies[20][25] = new Seaweed(5);
    myLittleFishies[20][25].setLocation(20, 25);
    myLittleFishies[30][25] = new Snail();
    myLittleFishies[30][25].setLocation(20, 25);

    // Show it all!
    fishFrame.setSize(640, 480);
    fishFrame.setLocation(10, 10);
    fishFrame.setVisible(true);

    // Every .3 seconds, tell each item in the fishtank to take
    // a turn.
    while (true) {

      // process through fishList
      fishList.addAll(addThings);
      addThings.clear();
      fishList.removeAll(removeThings);
      removeThings.clear();

      for (int i = 0; i < fishList.size(); i++) {
        UnderWaterThing fish = fishList.get(i);
        fish.move();
        // check if the snail could eat seaweed
        if (fish instanceof Snail) {
          for (int j = 0; j < fishList.size(); j++) {
            UnderWaterThing food = fishList.get(j);
            if (food instanceof Seaweed) {
              ((Snail) fish).eatSeaweed((Seaweed) food);
            }
          }
        }
      }

      // Tell the fishtank to redraw itself.
      fishFrame.repaint();

      // Wait .3 seconds before redoing the queue.
      try {
        Thread.sleep(300);
      } catch (Exception exception) {
        System.exit(-1);
      }
    }

  }
}
