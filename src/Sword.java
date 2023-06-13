public class Sword{
  int[] damage;
  String[] damageTypes;
  String upgrades;
  
  public Sword(){
    damage = new int[]{0,0,0,0,5};
    damageTypes = new String[]{"earth","fire","ice","electric","normal"};
    upgrades = "";
  }

    public int dealDamage(double[] mults){
        double total = 0;
        total += damage[0] * mults[0];
        total += damage[1] * mults[1];
        total += damage[2] * mults[2];
        total += damage[3] * mults[3];
        total += damage[4] * mults[4];


        return (int)total;

    }
  public int[] getDamages(){
    return damage;
  }
  public void setDamages(int[] newer){
    damage = newer;
  }

  
}