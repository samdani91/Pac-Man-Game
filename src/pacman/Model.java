package pacman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Model extends JPanel implements ActionListener {

    private Dimension d;
    private final Font smallFont =  new Font("Arial",Font.BOLD,14);
    private boolean inGame = false;

    private final int BLOCK_SIZE=24;
    private final int NUM_BLOCKS=15;
    private final int SCREEN_SIZE=NUM_BLOCKS*BLOCK_SIZE;
    private final int MAX_GHOSTS=12;
    private final int PACMAN_SPEED=6;

    private int NUM_GHOSTS=6;
    private int lives,score;
    private int []dx,dy;
    private int ghost_x,ghost_y,ghost_dx,ghost_dy,ghostSpeed;

    private Image heart,ghost;
    private Image up,down,left,right;

    private int req_dx,req_dy;
    private int pacman_x,pacman_y,pacman_dx,pacman_dy;

    private final int validSpeeds[]={1,2,3,4,6,8};
    private final int maxSpeed=6;
    private final int currentSpeed=3;
    private short[] screenData;
    private Timer timer;

    private final short levelData[] = {
            19, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 22,
            17, 16, 16, 16, 16, 24, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            25, 24, 24, 24, 28, 0, 17, 16, 16, 16, 16, 16, 16, 16, 20,
            0,  0,  0,  0,  0,  0, 17, 16, 16, 16, 16, 16, 16, 16, 20,
            19, 18, 18, 18, 18, 18, 16, 16, 16, 16, 24, 24, 24, 24, 20,
            17, 16, 16, 16, 16, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
            17, 16, 16, 16, 16, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
            17, 16, 16, 16, 24, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
            17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 18, 18, 18, 18, 20,
            17, 24, 24, 28, 0, 25, 24, 24, 16, 16, 16, 16, 16, 16, 20,
            21, 0,  0,  0,  0,  0,  0,   0, 17, 16, 16, 16, 16, 16, 20,
            17, 18, 18, 22, 0, 19, 18, 18, 16, 16, 16, 16, 16, 16, 20,
            17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            25, 24, 24, 24, 26, 24, 24, 24, 24, 24, 24, 24, 24, 24, 28
    };




    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
