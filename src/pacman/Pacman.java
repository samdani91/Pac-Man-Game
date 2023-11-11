package pacman;

import javax.swing.JFrame;

public class Pacman extends JFrame{

    public Pacman() {
        add(new Model());
        /*This is the constructor of the Pacman class.
        It gets executed when an instance of the class is created.
        Inside the constructor, a new instance of the Model class is created and
        added to the frame using the add method.
        * */
    }


    public static void main(String[] args) {
        Pacman pac = new Pacman();
        pac.setVisible(true);
        pac.setTitle("Pacman");
        pac.setSize(380,420);
        pac.setDefaultCloseOperation(EXIT_ON_CLOSE);
        pac.setLocationRelativeTo(null);

    }

}