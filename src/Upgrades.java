import javax.swing.*;

public class Upgrades{
    private Player player;
    private int[] upgradeselect;

    private ImageIcon given;
    public Upgrades(Player play){
        player = play;
        upgradeselect = new int[3];
    }

  public String rewards(){
    String big = "";
    for (int i = 0; i < 3; i++){
      upgradeselect[i] = (int)(Math.random()*15)+1;
     big+=(getItem(upgradeselect[i])+"("+(i+1)+"), ");
    }

//    doItem(choice,p);
    return big;
  }
  public int[] getOptions(){
        return upgradeselect;
  }

  public String getItem(int decide){
    if (1 <= decide && decide <= 2){
      return "health potion";
    }
    if (decide == 3 || decide == 4){
       return "life crystal";
    }
    if (decide == 5){
      return "flaming edge (sword upgrade)";
    }
    if (decide == 6){
      return "chilling edge (sword upgrade)";
    }
    if (decide == 7){
      return "electric edge (sword upgrade)";
    }
    if (decide == 8){
      return "earthen edge (sword upgrade)";
    }
    if (decide == 9){
      return "elemental nullifier (sword tradeoff)";
    }
    if (decide == 10){
      return "magical whetstone (sword upgrade)";
    }
    if (decide == 11){
      return "better metal (armor upgrade)";
    }
    if (decide == 12){
      return "Heavy Runes (armor tradeoff)";
    }
    if (decide == 13){
      return "Wind Rune (armor upgrade)";
    }
    if (decide == 14){
      return "remove armor (armor tradeoff)";
    }
    if (decide == 15){
      return "Cursed blade (weapon tradeoff)";
    }
    return "not happening";
  }
  public String doItem(int decide){
   if (1 <= decide && decide <= 2){
      player.fullHp();
       given = new ImageIcon("src/fire.png");
     return ("You drink the potion and heal to full hp");
    }
    if (decide == 3 || decide == 4){
        player.setMax(player.getMax()+50);
        player.hpMore(50);
        given = new ImageIcon("src/fire.png");

        return ("You crush the crystal and gain 50 max hp, healing 50 hp as well");
    }
    if (decide == 5){
          int[] thing = player.getSword().getDamages();
          thing[1] += 4;
        player.getSword().setDamages(thing);
        given = new ImageIcon("src/fire.png");

           return ("Your sword now deals 4 more fire damage");

    }
    if (decide == 6){
          int[] thing = player.getSword().getDamages();
          thing[1] += 4;
        player.getSword().setDamages(thing);
        given = new ImageIcon("src/fire.png");

        return ("Your sword now deals 4 more frost damage");

    }
    if (decide == 7){
          int[] thing = player.getSword().getDamages();
          thing[2] += 4;
        player.getSword().setDamages(thing);
        given = new ImageIcon("src/fire.png");
        return ("Your sword now deals 4 more lightning damage");

    }
    if (decide == 8){
          int[] thing = player.getSword().getDamages();
          thing[0] += 4;
        player.getSword().setDamages(thing);
        given = new ImageIcon("src/fire.png");
        return ("Your sword now deals 4 more earth damage");

    }
    if (decide == 9){
           int[] thing = player.getSword().getDamages();
            int sum = 0;
            for (int i = 0; i < 5; i++){
            sum += thing[i];
            thing[i]= 0;
      }
        player.getSword().setDamages(thing);
            thing[3]+= sum + 2;

        given = new ImageIcon("src/fire.png");
           return ("All your sword's elemental damage has become normal plus two.");

    }
    if (decide == 10){
           int[] thing = player.getSword().getDamages();
           thing[4] += 4;
        player.getSword().setDamages(thing);
        given = new ImageIcon("src/fire.png");
        return ("Your sword now deals 4 more normal damage");

    }
    if (decide == 11){
        player.getArmor().setDefense(player.getArmor().getDefense()+3);
        given = new ImageIcon("src/fire.png");           return ("You replace the metal in your armor, granting plus 3 defense.");

    }
    if (decide == 12){
        player.getArmor().setDefense((int)(player.getArmor().getDefense()*1.5));
        player.getArmor().setDodge((int)(player.getArmor().getDodge()/2));
        given = new ImageIcon("src/fire.png");           return ("You apply the rune to your armor and feel it harden... and become heavier. You gain 1.5 times defense but halved dodge chance.");

    }
    if (decide == 13){
        player.getArmor().setDodge(player.getArmor().getDodge()+15);
        given = new ImageIcon("src/fire.png");           return ("You apply the rune of wind to your.... head? That can't be healthy, but you gain plus 15 percent to your dodge chance.");
    }
    if (decide == 14){
        player.getArmor().setDefense((int)(0));
        player.getArmor().setDodge((int)(player.getArmor().getDodge()*2));
        given = new ImageIcon("src/fire.png");           return ("You throw off practically all of your armor, doubling dodge chance but removing all defense.");

    }
    if (decide == 15){
          int[] thing = player.getSword().getDamages();
          thing[4] += 8;
        player.getSword().setDamages(thing);
        player.setMax(player.getMax()-25);
        given = new ImageIcon("src/fire.png");           return ("After putting something you definetly shouldn't have touched on your sword, you gain 8 more physical damage, but are drained of 25 maxhp.");

    }
    return "never";
  }

  public ImageIcon getSprite(){
        return given;
  }



  
}