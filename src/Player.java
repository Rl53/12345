import javax.swing.*;
import java.util.ArrayList;

public class Player{
  int maxHp;
  int hp;
  Sword sword = new Sword();
  Armor armor = new Armor();

    private ArrayList<ImageIcon> playerStuff;

  public Player(){
      playerStuff = new ArrayList<>();
    maxHp = 100;
    hp = 100;
    playerStuff.add(new ImageIcon("src/person2.png"));
    playerStuff.add(new ImageIcon("src/startarmor.png"));
    
  }
 public String takeDamage(int damaged) {
     int damager = damaged;
     int dodged = (int) ((Math.random() * 100) + 1);
     if (armor.getDodge() >= dodged) {
         damager = 0;
         return "You dodged the attack";
     } else {
         hp -= (damager - armor.getDefense());
         if (hp <= 0) {
             System.out.println("You have died!");
             System.exit(0);
         }
         return "" + damaged + (damager - armor.getDefense());
     }
 }

     public int dmgTaken(int damaged){
         int damager = damaged;
         int dodged = (int)((Math.random()*100)+1);
         if (armor.getDodge() >= dodged){
             damager = 0;
             return 0;
         } else {
             hp -= (damager - armor.getDefense());

             return(damager-armor.getDefense());
         }
   }
  public Sword getSword(){
    return sword;
  }
  public int getMax(){
    return maxHp;
  }

  public int getHp(){ return hp;}

  public void hpMore(int more){
    hp += more;
  }
  public Armor getArmor(){
    return armor;
  }
  public void setMax(int newer){
    maxHp = newer;
  }

  public ArrayList<ImageIcon> getImages(){
      return playerStuff;
  }
  public void addImage(ImageIcon adder){
      playerStuff.add(adder);
  }
  public void fullHp(){
    hp = maxHp;
  }






  
}