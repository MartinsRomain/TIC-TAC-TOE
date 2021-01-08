package Game.controleur;

import Game.exceptions.CasePriseException;
import Game.exceptions.OutOfTabException;
import Game.modele.Coordonnees;
import Game.modele.*;
import Game.vue.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Partie extends JPanel {

    Map<JButton, Coordonnees> matriceButtons = new HashMap<>();

    public Partie(Screen screen , Controleur controleur) {

        JPanel zonePlateau = new JPanel();
        Piece[][] matrice = controleur.getTableau().getTableau();

        initButtonMatrice(controleur, screen, zonePlateau, matrice);

        setLayout(new BorderLayout());

        zonePlateau.setLayout(new GridLayout(3,3));
        JLabel label = new JLabel("Tic Tac Toe");
        label.setBackground(new Color(208, 192, 122));
        label.setOpaque(true);
        label.setFont(new Font("Arial", Font.BOLD, 60));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label, BorderLayout.NORTH);
        add(zonePlateau, BorderLayout.CENTER);

        screen.getFrame().getContentPane().add(this);
    }

    public void initButtonMatrice(Controleur controleur, Screen screen, JPanel zone,Piece[][] matrice){

        String buttonLabel = "";


        for (int x = 0; x < matrice.length; x++) {
            for (int y = 0; y < matrice.length; y++) {
                Piece piece = matrice[x][y];
                switch (piece) {
                    case X:
                        buttonLabel = "X";
                        break;
                    case O:
                        buttonLabel = "O";
                        break;
                    case VIDE:
                        buttonLabel = " ";
                        break;
                }
                JButton button = new JButton(buttonLabel);
                button.addActionListener(ActionEvent ->{
                    Coordonnees coordonnees = matriceButtons.get(button);
                    try {
                        if (matrice[coordonnees.getX()][coordonnees.getY()] == Piece.VIDE)
                            controleur.placerPiece(coordonnees.getX(),coordonnees.getY());
                            reloadButtonMatrice(matrice);
                            if(controleur.isWin()) {
                                screen.setStep(Etat.VICTOIRE);
                            }
                    } catch (CasePriseException | OutOfTabException e) {
                        e.printStackTrace();
                    }
                });
                button.setFont(new Font("Arial", Font.BOLD,75));
                matriceButtons.put(button,new Coordonnees(x,y));
                zone.add(button);
            }
        }

    }

    public void reloadButtonMatrice(Piece[][] matrice){
        Iterator it =  matriceButtons.keySet().iterator();

        while (it.hasNext()){
            JButton button = (JButton) it.next();
            Coordonnees coo = matriceButtons.get(button);
            Piece piece = matrice[coo.getX()][coo.getY()];
            switch (piece){
                case VIDE:
                    button.setText(" ");
                    break;
                case O:
                    button.setText("O");
                    break;
                case X:
                    button.setText("X");
                    break;
            }

        }

    }
}
