package Game.vue;

import Game.controleur.*;

import javax.swing.*;
import java.awt.*;

public class Screen implements Vue {
    /**
     *Vue principale initialisant la fenêtre.
     * @gameStep représente l'état du jeu.
     */

    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;

    private JFrame frame = new JFrame("Screen");
    private Controleur controleur;

    public Screen(Controleur controleur){
        this.controleur = controleur;

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        frame.setResizable(true);

        setStep(Etat.CONNECTION);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public void setStep(Etat gameStep){

        switch (gameStep) {
            case CONNECTION :
                Connection connection = new Connection(this, controleur);
                afficherMenuConnection(connection);
                break;
            case PARTIE_EN_COURS :
                frame.getContentPane().removeAll();
                Partie partie = new Partie(this, controleur);
                affichePartie(partie);
                frame.pack();
                break;
            case VICTOIRE:
                frame.getContentPane().removeAll();
                FinPartie finPartie = new FinPartie(this, controleur);
                afficheFinDePartie(finPartie);
                frame.pack();
                break;
        }
    }


    @Override
    public void afficherMenuConnection(Connection connection) {
        frame.add(connection);
    }

    @Override
    public void affichePartie(Partie partie) {
        frame.add(partie);
    }

    @Override
    public void afficheFinDePartie(FinPartie finPartie) {
        frame.add(finPartie);
    }

    public JFrame getFrame() {
        return frame;
    }
}
