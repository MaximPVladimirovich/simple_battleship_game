import java.util.ArrayList;

public class DotCom {
  private ArrayList<String> placementCells;
  private String name;

  public void setPlacementCells(ArrayList<String> cells) {
    placementCells = cells;
  }

  public void setName(String n) {
    name = n;
  }

  public String getName() {
    return name;
  }

  public String checkGuess(String input) {
    String result = "miss";
    int index = placementCells.indexOf(input);

    if (index >= 0) {
      placementCells.remove(index);
      result = "hit";
    } else {
      if (placementCells.isEmpty()) {
        result = "kill";
      }
    }

    return result;
  }
}
