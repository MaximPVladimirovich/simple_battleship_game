import java.util.ArrayList;

public class DotComBust {
  private GameGelper helper = new GameGelper();
  private ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
  private int numOfGuesses = 0;

  private void setUpGame() {
    int numOfComsToCreate = 3;

    for (int a = 0; a < numOfComsToCreate; a++) {
      DotCom com = new DotCom();
      com.setName(helper.getRandomName());
      dotComList.add(com);
    }

    System.out.println("Your goal is to sink three dot coms.");

    for (DotCom com : dotComList) {
      System.out.print(com.getName() + " ");
      ArrayList<String> placement = helper.placeDotCom(dotComList.size());
      com.setPlacementCells(placement);
    }

    System.out.println("Try to sink them all in the fewest number of guesses.");
  }

  public void startPlaying() {
    while (!dotComList.isEmpty()) {
      String input = helper.getUserInput("Enter a guess");
      checkUserGuess(input);
    }

    endGame();
  }

  public void checkUserGuess(String input) {
    numOfGuesses++;
    String result = "miss";

    for (int i = 0; i < dotComList.size(); i++) {
      DotCom com = dotComList.get(i);
      result = com.checkGuess(input);

      if (result.equals("hit")) {
        break;
      }

      if (result.equals("kill")) {
        dotComList.remove(i);
        break;
      }
    }

    System.out.println(result);
  }

  public void endGame() {
    System.out.println("All Dot Coms are killed, Your stock is now worthless.");
    if (numOfGuesses <= 18) {
      System.out.println("It only took you " + numOfGuesses + " guesses.");
      System.out.println("You got out before your options sank.");
    } else {
      System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
      System.out.println("Fish are dancing with your options.");
    }
  }

  public static void main(String[] args) {
    DotComBust game = new DotComBust();
    game.setUpGame();
    game.startPlaying();
  }

}
