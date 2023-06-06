import java.awt.*;

public class Monster {

    private int maxHp;
    private int hp;
    private int damage;
    private String element;

    private Rectangle rect;
    private int rectWidth;
    private int rectLength;
    private String species;

    public Monster(String elder, int mHp, int h, int d, int rW, int rL, String s){
        species = s;
        maxHp = mHp;
        hp = h;
        damage = d;
        rect = new Rectangle(rW,rL);
        int value = (int)(Math.random() * 4)+1;
        if (value == 1){
            element = "fire";
        } else if (value == 2){
            element = "ice";
        } else if (value == 3){
            element = "lightning";
        } else if (value == 4){
            element = "earth";
        }
        if (elder.equals("elder")){
            hp = 90;
            maxHp = 90;
            damage = 30;
        }

    }

    public String getElement(){
        return element;
    }

    public int getHp(){
        return hp;
    }

    public void changeHP(int newHp) {
        hp = newHp;
    }

    public int getDamage() {
        return damage;
    }

    public String getSpecies() {return species;}

    public Rectangle getBody(){ return rect;}

    public int attack(int b){
        return damage;
    }

    public String takeDamage(int damaged){
        hp -= damaged;
        if (hp <= 0){
            return "That "+element+ " " + species + " has died!";
        }
        return "You deal "+damaged+ " damage.";
    }

    public boolean isDead(){
        if (hp <= 0){
            return true;
        }
        return false;
    }






}

