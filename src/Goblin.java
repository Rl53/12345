
import javax.swing.*;
import java.awt.Rectangle;

public class Goblin extends Monster{
    private int potions;





    public Goblin(int mHp, int h, int d, int rW, int rL, String s){
        super( mHp, h, d, rW, rL,new double[]{1.0,0.5,0.5,0.75,1.25}, s,new ImageIcon("src/slime2-removebg-preview (1).png"));
        int rand = (int) (Math.random() * 3);
        potions = rand * 2;

    }





    @ Override
    public int attack(int b){
        if (getHp() + 10 <= getMaxHp()) {
            if (potions > 0) {
                potions--;
                changeHP(getHp() + 2);
                System.out.println("Goblin " + (b + 1) + " uses a potion, and heals 2 HP. This goblin has " + potions + " potions left.");
            }
        }
        int extra = (int)(Math.random() * 3)+1;
        if (extra == 1){
            System.out.println("Goblin " + (b+1)+ " throws a rock at you.");
        }if (extra == 2){
            System.out.println("Goblin " + (b+1)+ " attacks with its club.");
        }if (extra == 3){
            System.out.println("Goblin " + (b+1)+ " approaches closer.");
        }
        System.out.println("Goblin " + (b+1) + " does " + getDamage() + " damage.");

        return getDamage();
    }

}