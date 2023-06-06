import java.util.Scanner;
public class Lair{
//   Room[] rooms;
//
//   Player player = new Player();


  public Lair(){
//    rooms = new Room[10];
//    for (int i = 0; i < 10; i++){
//      rooms[i] = new Room(i +1);
//    }
//    game();
  }

//  public void game(){
//    System.out.println("You descend into a massive, scorched cavern, and encounter your first dragon.");
//    for (int i = 0; i < 10; i++){
//      while (rooms[i].dragonsDead()==false){
//
//
//        combatTurn(rooms[i].getDragons(),i);
//
//
//
//      }
//      if (i == 9){
//        System.out.println("You have slain the elder dragon and emerge from the cavern victorious!");
//        System.exit(0);
//      }
//
//      Upgrades.rewards(player);
//      introduction(i);
//    }
//
//  }

//  public void introduction(int i){
//    System.out.println("You walk into the next room of the lair and find "+(rooms[i+1].getDragons()).length + " Dragons before you.");
//  }


  
  public void combatTurn(Dragon[] dragons, int i){
//    //Generate Breath Dialogue
//    for (int b = 0; b < dragons.length; b++){
//      if(dragons[b].isBreath()== true){
//        System.out.println("Dragon "+(b+1)+" is inhaling deeply.");
//      }
//    }
//    //reset modified armor values
//    player.getArmor().evadeToggle(false);
//    player.getArmor().resetDefense();
//    //loop for player actions
//    for (int b = 3; b > 0; b--){
//    if (player.getArmor().getEvading()){
//       System.out.println("You have "+b+" actions remaining,\"attack\" a dragon or \"defend\"");
//    } else {
//    System.out.println("You have "+b+" actions remaining,\"attack\" a dragon"+", start to \"evade\", "+"or \"defend\"");
//    }
//    String move = scan.nextLine();
//      //attack code
//    if (move.equals("attack")){
//      rooms[i].targetList();
//      int target = scan.nextInt();
//      scan.nextLine();
//      if (!(1 <= target && target <= dragons.length)){
//        System.out.println("For some reason, you attack a random spot of air.");
//      } else {
//        dragons[target-1].takeDamage(player.getSword().dealDamage(dragons[target-1].getElement()));
//      }
//      //defend code
//    } else if (move.equals("defend")){
//      player.getArmor().reinforce();
//      System.out.println("You reinforce your armor.");
//      //dodge code
//    } else if (move.equals("evade")){
//      player.getArmor().evadeToggle(true);
//      System.out.println("You prepare to dodge attacks.");
//      //if they mess up somehow
//    } else {
//      System.out.println("You waste an action doing some nonsense.");
//    }
//      if (rooms[i].dragonsDead()){
//        break;
//      }
//    }
//
//    //dragon attacks
//    if (rooms[i].dragonsDead()==false){
//
//    for (int b = 0; b < dragons.length; b++){
//      if (dragons[b].isDead()!= true){
//      player.takeDamage(dragons[b].attack(b));
//      }
//
//    }
//    }
  }





  
}