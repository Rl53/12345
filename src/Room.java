public class Room {
  Monster[] monsters;


  public Room(int counter) {
    // species will randomize and change after adding more classes

    if (counter < 4) {
      Monster[] m = {randomMon()};
      monsters = m;
    } else if (counter < 7) {
      Monster[] m = {randomMon(), randomMon()};
      monsters = m;
    } else if (counter < 10) {

      Monster[] m = {randomMon(), randomMon(), randomMon()};
      monsters = m;
    } else if (counter == 10) {

      Monster[] m = {new Dragon(100, 100, 20, 10, 400, "dragon"), randomMon()};
      monsters = m;
    }
  }

  public Monster randomMon() {
    int chance = (int) (Math.random() * 3) + 1;
    if (chance == 1) {
      return new Orc(10, 10, 9, 10, 400, "orc");
    } else if (chance == 2) {
      return new Goblin(10, 10, 9, 10, 400, "goblin");
    } else {
      return new Goblin(10, 10, 9, 10, 400, "goblin");
    }
  }

  public boolean monsterDead() {
    for (int i = 0; i < monsters.length; i++) {
      if (!monsters[i].isDead()) {
        return false;
      }
    }
    return true;
  }

  public Monster[] getMonsters() {
    return monsters;
  }

  public void targetList() {
    System.out.print("Which creature do you attack, ");
    for (int i = 0; i < monsters.length; i++) {
      System.out.print("the " + monsters[i].getSpecies() + "(" + (i + 1) + "), ");
    }
    System.out.println("?");
  }


}