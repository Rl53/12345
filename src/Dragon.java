
import java.awt.Rectangle;

public class Dragon extends Monster{
  private boolean breath;





  public Dragon(String elder, int mHp, int h, int d, int rW, int rL, String s, boolean b){
    super(elder, mHp, h, d, rW, rL, s);
    breath = false;

  }



  public boolean isBreath(){
    return breath;
  }


  @ Override
  public int attack(int b){
    if (breath){
      breath = false;
      System.out.println("Dragon " + (b+1) +" breaths out a blast of "+getElement()+".");
      return getDamage() * 2;
    }
    int value = (int)(Math.random() * 4)+1;
    if (value == 1){
      breath = true;
    }
    int extra = (int)(Math.random() * 3)+1;
    if (extra == 1){
      System.out.println("Dragon " + (b+1)+ " slashes with it's claws.");
    }if (extra == 2){
      System.out.println("Dragon " + (b+1)+ " hits you with it's tail.");
    }if (extra == 3){
      System.out.println("Dragon " + (b+1)+ " bites down on you.");
    }
    System.out.println("Dragon " + (b+1) + " does " + getDamage() + " damage.");
    return getDamage();
  }

}