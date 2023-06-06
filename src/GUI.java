import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// at 7:32 part 4 !!!!

public class GUI {
    GameManager g;
    JFrame window;
    public JPanel background[] = new JPanel[10];
    public JLabel backgroundLabel[] = new JLabel[10];

    public JTextArea message;
    public GUI(GameManager g){
        this.g = g;
        createField();
        makeScene();
        window.setVisible(true);
    }

    public void createField() {
        window = new JFrame();
        window.setSize(900,700);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.gray);
        window.setLayout(null);

        message = new JTextArea("  TestT Imdwjdk");
        message.setBounds(50,35,800,150);
        message.setBackground(Color.darkGray);
        message.setForeground(Color.white);
        message.setEditable(false);
        message.setLineWrap(true);
        message.setWrapStyleWord(true);
        message.setFont(new Font("Times New Roman", Font.PLAIN,28));
        window.add(message);
    }

    public void makeBG(int num, String bgFile){

        background[num] = new JPanel();
        background[num].setBounds(50,185,800,350);
        background[num].setBackground(Color.black);
        background[num].setLayout(null);
        window.add(background[num]);
        backgroundLabel[num] = new JLabel();
        backgroundLabel[num].setBounds(0,0,800,350);

        ImageIcon bgI = new ImageIcon(getClass().getClassLoader().getResource(bgFile));
        backgroundLabel[num].setIcon(bgI);
    }

    public void createObj(int num, int x, int y, int width, int height, String fileName, String choice, String command) {

        JPopupMenu popMenu = new JPopupMenu();
        JMenuItem menuItem[] = new JMenuItem[4];

        menuItem[1] = new JMenuItem(choice);
        menuItem[1].addActionListener(g.handler);
        menuItem[1].setActionCommand(command);
        popMenu.add(menuItem[1]);

        JLabel objLabel = new JLabel();
        objLabel.setBounds(x,y,width,height);


        ImageIcon objIcon = new ImageIcon(getClass().getClassLoader().getResource(fileName));
        objLabel.setIcon(objIcon);

        objLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    popMenu.show(objLabel,e.getX(),e.getY());
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        background[num].add(objLabel);

    }

    public void addArrow(int num, int x, int y, int width, int height, String fileName, String command) {
        ImageIcon arrow = new ImageIcon(getClass().getClassLoader().getResource(fileName));
        JButton arrowButton = new JButton();
        arrowButton.setBounds(x,y,width,height);
        arrowButton.setBackground(null);
        arrowButton.setContentAreaFilled(false);
        arrowButton.setFocusPainted(false);
        arrowButton.setIcon(arrow);
        arrowButton.addActionListener(g.handler);
        arrowButton.setActionCommand(command);
        arrowButton.setBorderPainted(false);

        background[num].add(arrowButton);

    }
    public void makeScene(){
        makeBG(1,"wood-3072434_1280_40.jpg");
        createObj(1,450,-185,600,800,"bagi652r8p5rtheitedk0vmidk_50.png","Continue","talkMore");
        addArrow(1,-85,-200,800,800,"clipart21503_1_15.png","goBG2");
        background[1].add(backgroundLabel[1]);

        makeBG(2, "cave-2604672_1280.jpg");
        addArrow(1,-85,-200,800,800,"clipart21503_1_15.png","goBG2");
        background[2].add(backgroundLabel[2]);
    }


}





