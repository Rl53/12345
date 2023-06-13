import javax.swing.*;

public class Orc extends Monster{

    private boolean weapon;
    public String weaponName;



    public Orc(int mHp, int h, int d, int rW, int rL, String s){
        super( mHp, h, d, rW, rL,new double[]{1,1,1,1,1}, s,new ImageIcon("src/slime2-removebg-preview (1).png"));
        weapon = true;
        int chance = (int)(Math.random()*3)+1;
        if (chance == 1){
            weaponName = "large club";
        } else if (chance == 2){
            weaponName = "Stone axe";
        } else {
            weaponName = "Old sword";
        }
    }



    @ Override
    public int attack(int b){
        if (weapon){
            System.out.println("Orc " + (b+1) +" hits you with their "+weaponName+".");
            return (int)(getDamage() * 1.5);
        }
        int value = (int)(Math.random() * 4)+1;
        if (value == 1){
            weapon = false;
            System.out.println("This orc's weapon broke.");
        }
        int extra = (int)(Math.random() * 3)+1;
        if (extra == 1){
            System.out.println("Orc " + (b+1)+ " swings their arms.");
        }if (extra == 2){
            System.out.println("Orc " + (b+1)+ " hurls a boulder at you.");
        }if (extra == 3){
            System.out.println("Orc " + (b+1)+ " charges into you.");
        }
        System.out.println("Orc " + (b+1) + " does " + getDamage() + " damage.");

        return getDamage();
    }

}
