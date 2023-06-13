import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import javax.swing.*;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import static java.awt.Font.BOLD;

// a subclass of JPanel; this panel has been designed entirely in code (not using the UI designer)
public class AnimationPanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener {
    private int movingMessageX;

    private boolean won;
    private boolean gameOver;

    private Upgrades upgrades;
    private Timer timer;

    private int turns;

    private Rectangle button1;

    private Rectangle button2;

    private Rectangle button3;

    private boolean upgrading;
    private boolean rolled;

    private Room[] rooms;

    private Player player;

    private boolean selecting;

    private int currentRoom;

    private String message;

    private Timer why;

    private Timer nextLetter;

    private int currentLetters;

    private String hpAmount;

    private String dodge;

    private String defense;
    private int action;

//    private Button test2;

    private ImageIcon bu;

    private boolean canMove;

    private boolean messageLoaded;

    private String loadedMessage;







    // constructor
    public AnimationPanel() {
        // initialize variables
        makeButtons();
//ImageIcon test = new ImageIcon(getClass().getClassLoader().getResource("wfwijijfij.png"));
        message = "";
        hpAmount = "";
        dodge = "";
        defense = "";
        won = false;
        gameOver = false;
        loadedMessage = "";
        messageLoaded = false;
        player = new Player();
        addMouseListener(this);
        selecting = false;
        upgrading = false;
        rolled = false;
        turns = 3;
        upgrades = new Upgrades(player);
        canMove = true;
        why = new Timer(750, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                canMove = true;
                if (messageLoaded){
                    write(loadedMessage);
                    messageLoaded = false;
                }
            }
        });
        nextLetter = new Timer(25, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                currentLetters++;
            }
        });
        nextLetter.start();


        // initialize Timer object, responsible for the animation
        timer = new Timer(10, this); // set timer to have 10ms pulses; each pulse triggers an ActionEvent
        timer.start();


        rooms = new Room[10];
        for (int i = 0; i < 10; i++){
            rooms[i] = new Room(i +1);
        }
        currentRoom = 0;
        game();


    }
    public void makeButtons(){
        button1 = new Rectangle(225,775,200,75);
        button2 = new Rectangle(475,775,200,75);
        button3 = new Rectangle(725,775,200,75);


    }
    public void game() {
        write("You descend into a massive, scorched cavern, and encounter your first enemy. Press any button to begin");

    }

    public void write(String actualwords){
        currentLetters = 0;
        message = actualwords;
            repaint();
    }

    // important method that is inherited from JComponent and overridden;
    // this method automatically gets called by the graphics engine
    // when the engine it detects that the panel needs to be redrawn/updated
    @Override
    public void paint(Graphics gp) {
        hpAmount = "HP: " + player.getHp() + "/"+ player.getMax();
        defense = "Defense: "+player.getArmor().getDefense();
        dodge = "Dodge: "+player.getArmor().getDodgeNum();

        super.paint(gp); // must do this!
        Graphics2D g2d = (Graphics2D) gp; // cast gp to a 2D graphics object so we can do more advanced stuff

//        ImageIcon background = new ImageIcon("src/.png");
//        Image bgI = background.getImage();
//        g2d.drawImage(bgI, 0, 0, this);

        // draw blue message on screen
        g2d.setColor(Color.blue);
        Font myFont = new Font("Arial", BOLD, 14);
        g2d.setFont(myFont);


//         message = "Move orange square to gray! Dodge the red enemy!";
//        if (won) {
//            message = "YOU WIN!!!!";
//        }
//        if (gameOver) {
//            message = "YOU LOSE!!!";
//        }
         // write message at location: (x, 100)

        // draw gray target rectangle on the screen
        // since it doesn't move, we can use a simple fillRect rather than create a Rectangle object
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, 1200, 100);
        g2d.fillRect(0, 750, 1200, 150);// draw the top border

        g2d.setColor(Color.darkGray);
        g2d.fillRect(225,775,200,75);
        g2d.fillRect(475,775,200,75);
        g2d.fillRect(725,775,200,75);
        ImageIcon what = new ImageIcon("src/dungeon1.png");
        g2d.drawImage(what.getImage(), 0, 100,this);
        g2d.draw(button1);
        g2d.draw(button2);
        g2d.draw(button3);
        g2d.setColor(Color.LIGHT_GRAY);
        if ((currentLetters <= message.length())){
            g2d.drawString(message.substring(0,currentLetters), 50, 50);
        } else {
            g2d.drawString(message, 50, 50);
        }

        g2d.drawString(hpAmount, 1050, 25);
        g2d.drawString(defense, 1050, 50);
        g2d.drawString(dodge, 1050, 75);
        g2d.setColor(Color.RED);
//        for (int i = 0; i <player.getImages().size();i++){
//            if (i ==0){
//                g2d.drawImage(player.getImages().get(i).getImage(), 527, 478, this);
//            } else {
//                g2d.drawImage(player.getImages().get(i).getImage(), 525, 480, this);
//            }
//        }
        for (ImageIcon things : player.getImages())
        {
            g2d.drawImage(things.getImage(), 200, 400, this);
        }

        if (!upgrading) {
            int increment = 0;
            for (int i = 0; i < rooms[currentRoom].getMonsters().length; i++) {
               // adds enemy picture
                if (rooms[currentRoom].getMonsters()[i].isDead()==false) {
                    g2d.drawImage(rooms[currentRoom].getMonsters()[i].getImage().getImage(), 800 + i * 75,500+ i * 75 , this);
                }

            }
        }





    }



    // updates the x value for the string message by adding a small increment each time,
    // and resetting back to the left edge when it moves off the screen

    // updates the x and y values for the red rectangle by adding a small increment each time,
    // and resetting to edges when it goes off the screen


    // there is no easy way to automatically detect if two rectangles touch,
    // so we must write a method to do that



    // -------------- ActionListener interface method --------------
    // called for each Timer event (occurs every 10ms)
    // The timer + this method causes the animation to occur!
    @Override
    public void actionPerformed(ActionEvent e) {
        // only move the message and the red enemy if the game is not over

        repaint(); // forces the "paint" method above to be re-queued in the graphics engine
    }

    // -------------- MouseListener interface methods (5 required, only 2 used) --------------
    // called when the mouse button is pressed in
    @Override
    public void mousePressed(MouseEvent e) {
      int rand = 1; //(int) (Math.random()*2);
        if (canMove) {

//        try {
//            wait(1000);
//        } catch (InterruptedException ex) {
//            throw new RuntimeException(ex);
//        }

                if (selecting) {
                    write("Please choose a mob to attack.");
                    if (button1.contains(e.getPoint())) {
                        write(rooms[currentRoom].getMonsters()[0].takeDamage(player.getSword().dealDamage(rooms[currentRoom].getMonsters()[0].getResists())));
                        selecting = false;


                    }
                    //defend
                    if (button2.contains(e.getPoint()) && (rooms[currentRoom].getMonsters().length > 1)) {
                        write(rooms[currentRoom].getMonsters()[1].takeDamage(player.getSword().dealDamage(rooms[currentRoom].getMonsters()[1].getResists())));
                        selecting = false;


                    }
                    //evade
                    if (button3.contains(e.getPoint()) && (rooms[currentRoom].getMonsters().length > 2)) {
                        write(rooms[currentRoom].getMonsters()[2].takeDamage(player.getSword().dealDamage(rooms[currentRoom].getMonsters()[2].getResists())));
                        selecting = false;

                    }
                    //check for upgradin time
                    if (rooms[currentRoom].monsterDead()) {
                        write("You have slain all the enemies in the room and move to and find one of three rewards:");
                        upgrading = true;
                        rolled = true;

                    } else {
                        loadedMessage = "Choose to attack (1), defend (2), or start evading (3).";
                        messageLoaded = true;
                    }
//                    loadedMessage = "Choose to attack, defend, or start evading.";
//                    messageLoaded = true;
                    INAMINUTE();
                    turns--;
                    if (rand == 1) {
                        monsterMove();

                    }
                    INAMINUTE();
                } else if (upgrading) {

                    if (rolled) {
                        write(upgrades.rewards());
                        rolled = false;
                    }

                    if (button1.contains(e.getPoint())) {
                        write(upgrades.doItem(upgrades.getOptions()[0]));
                        upgrading = false;
                        currentRoom++;
                        player.addImage(upgrades.getSprite());
                        turns = 3;
                    }
                    //defend
                    if (button2.contains(e.getPoint())) {
                        write(upgrades.doItem(upgrades.getOptions()[1]));
                        upgrading = false;
                        currentRoom++;
                        player.addImage(upgrades.getSprite());
                        turns = 3;
                    }
                    //evade
                    if (button3.contains(e.getPoint())) {
                        write(upgrades.doItem(upgrades.getOptions()[2]));
                        upgrading = false;
                        currentRoom++;
                        player.addImage(upgrades.getSprite());
                        turns = 3;
                    }


                } else {
                    write("Choose to attack, defend, or start evading.");
                    //attack
                    if (button1.contains(e.getPoint())) {
                        action = 1;
                        selecting = true;
                        write("Please choose a mob to attack.");

                    }
                    //defend
                    if (button2.contains(e.getPoint())) {
                        player.getArmor().reinforce();
                        write("You reinforce your armor.");
                        turns--;
                        loadedMessage = "Choose to attack, defend, or start evading.";
                        messageLoaded = true;
                        INAMINUTE();


                    }
                    //evade
                    if (button3.contains(e.getPoint())) {
                        player.getArmor().evadeToggle(true);
                        write("You prepare to dodge attacks.");
                        turns--;

                        loadedMessage = "Choose to attack, defend, or start evading.";
                        messageLoaded = true;
                        INAMINUTE();

                    }
                }


            }


            INAMINUTE();
        }


    public void INAMINUTE(){
        if (canMove == true) {

            canMove = false;
            why.start();
        } else {
            why.restart();
        }
        }




    public void monsterMove() {
        if (rooms[currentRoom].monsterDead() == false) {

            for (int b = 0; b < rooms[currentRoom].getMonsters().length; b++) {

                if (!rooms[currentRoom].getMonsters()[b].isDead()) {
                    write("The player takes " + player.dmgTaken(rooms[currentRoom].getMonsters()[b].attack(b)) + " damage.");
                    if (player.getHp() <= 0) {
                        write("You lost all your health. GAME OVER");
                    }
                }

            }
        }
        player.getArmor().evadeToggle(false);
        player.getArmor().resetDefense();
    }

    // called when the mouse button is released
    @Override
    public void mouseReleased(MouseEvent e) {


    }
    @Override
    public void mouseClicked(MouseEvent e) { } // unused but needed for interface

    @Override
    public void mouseEntered(MouseEvent e) { } // unused but needed for interface

    @Override
    public void mouseExited(MouseEvent e) { } // unused but needed for interface

    // -------------- MouseMotionListener interface methods (2 required, only 1 used) --------------
    // called when user has clicked in and is dragging the mouse
    @Override
    public void mouseDragged(MouseEvent e) { }

    @Override
    public void mouseMoved(MouseEvent e) { } // unused but needed for interface
}
