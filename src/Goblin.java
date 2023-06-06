
import java.awt.Rectangle;

public class Goblin extends Monster{
    private int potions;





    public Goblin(String elder, int mHp, int h, int d, int rW, int rL, String s){
        super(elder, mHp, h, d, rW, rL, s);
        int rand = (int) (Math.random() * 3);
        potions = rand * 2;

    }





    @ Override
    public int attack(int b){
        if (potions > 0){
            potions--;
            changeHP(getHp() + 10);
            System.out.println("Goblin " + (b+1) +" uses a potion, and heals 10 HP. This goblin has " + potions + " potions left.");
        }
        int extra = (int)(Math.random() * 3)+1;
        if (extra == 1){
            System.out.println("Goblin " + (b+1)+ " throws a rock at you.");
        }if (extra == 2){
            System.out.println("Goblin " + (b+1)+ " attacks with its club.");
        }if (extra == 3){
            System.out.println("Goblin " + (b+1)+ " approaches closer.");
        }
        return getDamage();
    }

}