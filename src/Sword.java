public class Sword{
  int[] damage;
  String[] damageTypes;
  String upgrades;
  
  public Sword(){
    damage = new int[]{0,0,0,0,5};
    damageTypes = new String[]{"earth","fire","ice","electric","normal"};
    upgrades = "";
  }

  public int dealDamage(String element){
    int total = 0;
      if (element.equals("lightning")){
        total += damage[0] * 2;
        total += damage[1];
        total += damage[2];
        total += damage[3]/2;
        total += damage[4];

    }
    if (element.equals("fire")){
        total += damage[0];
        total += damage[1]/2;
        total += damage[2]*2;
        total += damage[3];
        total += damage[4];

    }
    if (element.equals("ice")){
        total += damage[0];
        total += damage[1]*2;
        total += damage[2]/2;
        total += damage[3];
        total += damage[4];

    }
    if (element.equals("earth")){
        total += damage[0]/2;
        total += damage[1];
        total += damage[2];
        total += damage[3]*2;
        total += damage[4];

    }
    return total;
    
  }
  public int[] getDamages(){
    return damage;
  }
  public void setDamages(int[] newer){
    damage = newer;
  }

  
}