public class Player{
  int maxHp;
  int hp;
  Sword sword = new Sword();
  Armor armor = new Armor();

  public Player(){
    maxHp = 100;
    hp = 100;
    
  }
 public String takeDamage(String damaged){
      int damager = Integer.parseInt((damaged.substring(damaged.indexOf(",")+1,damaged.length())));
   int dodged = (int)((Math.random()*100)+1);
   if (armor.getDodge() >= dodged){
     damager = 0;
     return "You dodged the attack";
   } else {
       hp -= (damager - armor.getDefense());
       if (hp <= 0){
           System.out.println("You have died!");
           System.exit(0);
       }
       return damaged.substring(0, damaged.indexOf(",")) + (damager-armor.getDefense());
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
  public void fullHp(){
    hp = maxHp;
  }






  
}