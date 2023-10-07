package pacman;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Model extends JPanel implements ActionListener {

    private Dimension d; //height and width of the playing field
    private final Font smallFont = new Font("Arial", Font.BOLD, 14);
    private boolean inGame = false; //if game is running
    private boolean dying = false; //if pacman is alive

    private final int BLOCK_SIZE = 24;
    private final int N_BLOCKS = 15;//row,col
    private final int SCREEN_SIZE = N_BLOCKS * BLOCK_SIZE;
    private final int MAX_GHOSTS = 12;
    private final int PACMAN_SPEED = 6;

    private int N_GHOSTS = 5; //at beginning
    private int lives, score;
    private int[] dx, dy; //position of the ghost
    private int[] ghost_x, ghost_y, ghost_dx, ghost_dy, ghostSpeed;

    private Image heart, ghost;
    private Image up, down, left, right; //pacman animation

    private int pacman_x, pacman_y, pacmand_x, pacmand_y;
    private int req_dx, req_dy; //TAdapter (arrow keys)

    private final int validSpeeds[] = {1, 2, 3, 4, 6, 8};
    private final int maxSpeed = 6;

    private int currentSpeed = 3;
    private short[] screenData;
    private Timer timer;//allows the animation

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
    //225 possible position in the game, 0=blue obstacles, 1=left border,2=top,4=right,8=bottom,
    //16=white dots

    public Model() {

        loadImages();
        initVariables();
        setFocusable(true);
        initGame();
    }


    private void loadImages() {
        down = new ImageIcon("/home/samdani1412/Pac-Man-Game/src/images/down.gif").getImage();
        up = new ImageIcon("/home/samdani1412/Pac-Man-Game/src/images/up.gif").getImage();
        left = new ImageIcon("/home/samdani1412/Pac-Man-Game/src/images/left.png").getImage();
        right = new ImageIcon("/home/samdani1412/Pac-Man-Game/src/images/right.gif").getImage();
        ghost = new ImageIcon("/home/samdani1412/Pac-Man-Game/src/images/ghost.gif").getImage();
        heart = new ImageIcon("/home/samdani1412/Pac-Man-Game/src/images/heart.png").getImage();

    }
    private void initVariables() {

        screenData = new short[N_BLOCKS * N_BLOCKS];
        d = new Dimension(400, 400);
        ghost_x = new int[MAX_GHOSTS];
        ghost_dx = new int[MAX_GHOSTS];
        ghost_y = new int[MAX_GHOSTS];
        ghost_dy = new int[MAX_GHOSTS];
        ghostSpeed = new int[MAX_GHOSTS];
        dx = new int[4];
        dy = new int[4];

        timer = new Timer(60, this);//animations
        timer.start();
    }


    private void initGame() {

        lives = 3;
        score = 0;
        initLevel();
        N_GHOSTS = 5;
        currentSpeed = 3;
    }

    private void initLevel() {

        int i;
        for (i = 0; i < N_BLOCKS * N_BLOCKS; i++) {
            screenData[i] = levelData[i];
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

}