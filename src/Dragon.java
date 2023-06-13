
import javax.swing.*;
import java.awt.Rectangle;

public class Dragon extends Monster{
  private boolean breath;





  public Dragon(int mHp, int h, int d, int rW, int rL, String s){
    super( mHp, h, d, rW, rL,new double[]{1,0.5,1.5,1,1}, s,new ImageIcon("src/slime2-removebg-preview (1).png"));
    breath = false;

  }



  public boolean isBreath(){
    return breath;
  }


  @ Override
  public int attack(int b){
    if (breath){
      breath = false;
      System.out.println("The Dragon "  +" breaths out a cone of fire.");
      return getDamage() * 2;
    }
    int value = (int)(Math.random() * 4)+1;
    if (value == 1){
      breath = true;
    }
    int extra = (int)(Math.random() * 3)+1;
    if (extra == 1){
      System.out.println("The Dragon " + " slashes with it's claws.");
    }if (extra == 2){
      System.out.println("The Dragon " + " hits you with it's tail.");
    }if (extra == 3){
      System.out.println("The Dragon " + " bites down on you.");
    }
    System.out.println("The Dragon "  + " does " + getDamage() + " damage.");
    return getDamage();
  }

}