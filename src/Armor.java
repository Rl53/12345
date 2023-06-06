public class Armor{
  int defense;
  int baseDefense;
  int dodge;
  String upgrades;
  boolean evading;

  public Armor(){
    defense = 3;
    baseDefense = 3;
    dodge = 10;
    upgrades = "";
  }
  public int getDodge(){
    if (evading == false){
      return 0;
    }
    return dodge;
  }
  public int getDodgeNum(){
    return dodge;
  }
  public int getDefense(){
    return defense;
  }
  
  public void setDefense(int newer){
    baseDefense = newer;
  }
  
  public void setDodge(int newer){
    dodge = newer;
  }
  
  public void resetDefense(){
    defense = baseDefense;
  }
  public void reinforce(){
    defense += baseDefense;
    }
  public boolean getEvading(){
    return evading;
  }
  public void evadeToggle(boolean state){
    if (state){
      evading = true;
    } else {
      evading = false;
    }
  }

  


  
}