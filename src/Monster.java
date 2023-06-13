import javax.swing.*;
import java.awt.*;

public class Monster {

    private int maxHp;
    private int hp;
    private int damage;
    private double[] resistences;

    private ImageIcon one;

    private Rectangle rect;
    private int rectWidth;
    private int rectLength;
    private String species;

    public Monster( int mHp, int h, int d, int rW, int rL, double[] resist,String s, ImageIcon bussin){
        one = bussin;
        species = s;
        maxHp = mHp;
        hp = h;
        damage = d;
        rect = new Rectangle(rW,rL);
        resistences = resist;

    }

    public double[] getResists(){
        return resistences;
    }

    public int getHp(){
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
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

    public ImageIcon getImage(){
        return one;
    }

    public String takeDamage(int damaged){
        hp -= damaged;
        if (hp <= 0){
            return "That creature has died!";
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

