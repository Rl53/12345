public class Orc extends Monster{

    private boolean weapon;





    public Orc(String elder, int mHp, int h, int d, int rW, int rL, String s){
        super(elder, mHp, h, d, rW, rL, s);
        weapon = true;

    }



    @ Override
    public int attack(int b){
        if (weapon){
            System.out.println("Orc " + (b+1) +" hits you with their weapon of "+getElement()+".");
            return getDamage() * 2;
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
            System.out.println("Orc " + (b+1)+ " moves aggressively.");
        }
        return getDamage();
    }

}
